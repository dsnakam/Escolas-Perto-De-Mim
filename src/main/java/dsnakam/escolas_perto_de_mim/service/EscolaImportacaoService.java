package dsnakam.escolas_perto_de_mim.service;

import dsnakam.escolas_perto_de_mim.dto.EscolaImportacaoDTO;
import dsnakam.escolas_perto_de_mim.entity.Escola;
import dsnakam.escolas_perto_de_mim.repository.EscolaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EscolaImportacaoService {

    private final EscolaRepository escolaRepository;

    public EscolaImportacaoService(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

    public Escola convert(EscolaImportacaoDTO dto) {

        Escola escola = new Escola();

        escola.setNomeEscola(dto.getNomeEscola());
        escola.setDiretoriaEnsino(dto.getDiretoriaEnsino());
        escola.setMunicipio(dto.getMunicipio());
        escola.setCodigoEscola(dto.getCodigoEscola());
        escola.setCodigoMec(dto.getCodigoMec());
        escola.setTipoLogradouro(dto.getTipoLogradouro());
        escola.setEndereco(dto.getEndereco());
        escola.setNumero(dto.getNumero());
        escola.setBairro(dto.getBairro());
        escola.setCep(dto.getCep());

        escola.setLatitude(
                Double.parseDouble(dto.getLatitude().replace(",", "."))
        );

        escola.setLongitude(
                Double.parseDouble(dto.getLongitude().replace(",", "."))
        );

        return escola;
    }

    public List<Escola> importAll(List<EscolaImportacaoDTO> dtos) {
        List<Escola> escolas = new ArrayList<>();

        for (EscolaImportacaoDTO dto : dtos) {
            escolas.add(convert(dto));
        }

        return escolaRepository.saveAll(escolas);
    }

    public boolean savedEscolasExists() {
        return escolaRepository.count() > 0;
    }
}