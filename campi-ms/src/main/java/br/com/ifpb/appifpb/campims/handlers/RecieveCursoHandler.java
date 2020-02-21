package br.com.ifpb.appifpb.campims.handlers;

import br.com.ifpb.appifpb.campims.channel.RegChannel;
import br.com.ifpb.appifpb.campims.channel.StudentChannel;
import br.com.ifpb.appifpb.campims.model.CampiDesistente;
import br.com.ifpb.appifpb.campims.model.InfoCurso;
import br.com.ifpb.appifpb.campims.model.MatriculaLimpa;
import br.com.ifpb.appifpb.campims.repositories.InfoCursoRepository;
import br.com.ifpb.appifpb.campims.repositories.MatriculaLimpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RecieveCursoHandler {

    private final InfoCursoRepository infoCursoRepository;

    @StreamListener(StudentChannel.INPUT)
    public void onUCursosRecieved(List<InfoCurso> infoCursos) {
//        infoCursoRepository.deleteAll();
//        infoCursos.forEach(infoCursoRepository::save);
//        log.info("informações de cursos cadastradas com sucesso!");
    }
}
