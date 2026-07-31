package dsnakam.escolas_perto_de_mim.loader;

import tools.jackson.databind.json.JsonMapper;
import tools.jackson.core.type.TypeReference;
import dsnakam.escolas_perto_de_mim.dto.EscolaImportacaoDTO;
import dsnakam.escolas_perto_de_mim.entity.Escola;
import dsnakam.escolas_perto_de_mim.service.EscolaImportacaoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EscolaDataLoader implements CommandLineRunner {

    private final EscolaImportacaoService escolaImportacaoService;

    public EscolaDataLoader(EscolaImportacaoService escolaImportacaoService) {
        this.escolaImportacaoService = escolaImportacaoService;
    }

    @Override
    public void run(String... args) throws Exception {
        JsonMapper mapper = new JsonMapper();

        List<EscolaImportacaoDTO> escolas = mapper.readValue(
                new ClassPathResource("endereco_escolas_2025.json").getInputStream(),
                new TypeReference<List<EscolaImportacaoDTO>>() {}
        );

        List<Escola> salvas = escolaImportacaoService.importAll(escolas);

        System.out.println("Importação concluída: " + escolas.size() + " escolas processadas.");
    }
}