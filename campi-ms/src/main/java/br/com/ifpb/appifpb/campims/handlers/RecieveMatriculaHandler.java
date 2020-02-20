package br.com.ifpb.appifpb.campims.handlers;

import br.com.ifpb.appifpb.campims.channel.RegChannel;
import br.com.ifpb.appifpb.campims.model.MatriculaLimpa;
import br.com.ifpb.appifpb.campims.repositories.MatriculaLimpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RecieveMatriculaHandler {

    private final MatriculaLimpaRepository matriculaLimpaRepository;

    @StreamListener(RegChannel.INPUT)
    public void onMatriculasRecieved(List<MatriculaLimpa> matriculasLimpas) {
        matriculaLimpaRepository.deleteAll();
        matriculasLimpas.forEach(matriculaLimpaRepository::save);
        log.info("matriculas limpas cadastradas com sucesso!");
    }

}
