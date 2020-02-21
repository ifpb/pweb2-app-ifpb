package br.com.ifpb.appifpb.campims.service;

import br.com.ifpb.appifpb.campims.dto.CampiComPercentualDTO;
import br.com.ifpb.appifpb.campims.dto.NomeCampiDTO;
import br.com.ifpb.appifpb.campims.repositories.CampiDesistenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CampiDesistenteService {

    private final CampiDesistenteRepository campiRepository;

    public CampiComPercentualDTO buscarCampusPorNome(String nomeCampus){
        return this.campiRepository.listarCampusPorNome(nomeCampus);
    }
}
