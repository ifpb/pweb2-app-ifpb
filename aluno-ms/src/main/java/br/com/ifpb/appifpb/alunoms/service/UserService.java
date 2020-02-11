package br.com.ifpb.appifpb.alunoms.service;

import br.com.ifpb.appifpb.alunoms.controller.dto.UserDTO;
import br.com.ifpb.appifpb.alunoms.domain.auth.User;
import br.com.ifpb.appifpb.alunoms.domain.auth.events.UserRegisted;
import br.com.ifpb.appifpb.alunoms.repository.UserRepository;
import br.com.ifpb.appifpb.alunoms.service.exception.UserException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ApplicationEventPublisher applicationEventPublisher;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ApplicationEventPublisher applicationEventPublisher) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(UserDTO userDTO) throws UserException {
        System.out.println(userDTO);
        User user = new User(userDTO.getMatricula(), userDTO.getSenha(), false);
        try{
            user.setSenha(passwordEncoder.encode(user.getSenha()));
            this.userRepository.save(user);
            this.applicationEventPublisher.publishEvent(
                    new UserRegisted(
                            userDTO.getMatricula(),
                            userDTO.getNomeCompleto(),
                            userDTO.getCurso(),
                            LocalDateTime.now()
                    )
            );
        } catch (DataIntegrityViolationException e) {
            throw new UserException("Login já cadastrado");
        }
    }

}
