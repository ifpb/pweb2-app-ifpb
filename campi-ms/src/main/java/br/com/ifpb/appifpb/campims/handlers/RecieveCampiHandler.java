package br.com.ifpb.appifpb.campims.handlers;

import br.com.ifpb.appifpb.campims.channel.CampiChannel;
import br.com.ifpb.appifpb.campims.model.CampiDesistente;
import br.com.ifpb.appifpb.campims.repositories.CampiDesistenteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RecieveCampiHandler {

    private final CampiDesistenteRepository campiDesistenteRepository;

    @StreamListener(CampiChannel.INPUT)
    public void onCampiRecieved(List<CampiDesistente> infoCampi) {
//        campiDesistenteRepository.deleteAll();
//        infoCampi.forEach(campiDesistenteRepository::save);
//        log.info("informações de campi cadastradas com sucesso!");
    }

}
