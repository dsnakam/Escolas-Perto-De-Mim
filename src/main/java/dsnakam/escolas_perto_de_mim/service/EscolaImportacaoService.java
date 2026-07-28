package dsnakam.escolas_perto_de_mim.service;

import dsnakam.escolas_perto_de_mim.dto.EscolaImportacaoDTO;
import dsnakam.escolas_perto_de_mim.entity.Escola;
import dsnakam.escolas_perto_de_mim.repository.EscolaRepository;
import org.springframework.stereotype.Service;

@Service
public class EscolaImportacaoService {

    private final EscolaRepository escolaRepository;

    public EscolaImportacaoService(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

    public Escola importar(EscolaImportacaoDTO dto) {

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

        return escolaRepository.save(escola);
    }
}