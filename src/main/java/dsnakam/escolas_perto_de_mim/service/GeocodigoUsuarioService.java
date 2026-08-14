package dsnakam.escolas_perto_de_mim.service;

import dsnakam.escolas_perto_de_mim.dto.GeocodigoUsuarioDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service

public class GeocodigoUsuarioService {
    private final RestClient restClient = RestClient.builder()
            .baseUrl("https://nominatim.openstreetmap.org")
            .defaultHeader("User-Agent", "EscolasPertoDeMim")
            .build();

    public List<GeocodigoUsuarioDTO> findCoordinates(final String q) {
        return this.restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("q", q)
                        .queryParam("format", "json")
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<List<GeocodigoUsuarioDTO>>() {});
    }
}
