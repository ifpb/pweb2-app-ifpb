package br.com.ifpb.appifpb.alunoms.handlers;

import br.com.ifpb.appifpb.alunoms.channel.UserChannel;
import br.com.ifpb.appifpb.alunoms.domain.aluno.Aluno;
import br.com.ifpb.appifpb.alunoms.domain.auth.User;
import br.com.ifpb.appifpb.alunoms.domain.auth.events.UserRegisted;
import br.com.ifpb.appifpb.alunoms.repository.AlunoRepository;
import br.com.ifpb.appifpb.alunoms.repository.UserRepository;
import br.com.ifpb.appifpb.alunoms.service.exception.UserException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserRegistedHandler {

    private final UserChannel userChannel;

    private final AlunoRepository alunoRepository;

    private final UserRepository userRepository;

    @TransactionalEventListener
    public void onUserRegistrado(UserRegisted evento) {
        System.out.println("Emitindo");
        userChannel.userChannel().send(new GenericMessage(evento.getMatricula()));
        log.info("Aluno registrado com a matricula ="+evento.getMatricula());
    }

    @StreamListener(UserChannel.INPUT)
    public void onUserRecieved(Aluno aluno) throws UserException {
        Optional<User> userOptional = this.userRepository.findById(aluno.getId());
        User user = userOptional.orElseThrow(() -> new UserException("Usuário não cadastrado no sistema"));
        user.setAtivo(true);
        this.alunoRepository.save(aluno);
        this.userRepository.save(user);
        log.info("Dados recuperados do aluno com matricula " + aluno.getNome());
    }
}
