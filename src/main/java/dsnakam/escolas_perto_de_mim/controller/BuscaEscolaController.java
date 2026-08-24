package dsnakam.escolas_perto_de_mim.controller;

import dsnakam.escolas_perto_de_mim.dto.GeocodigoUsuarioDTO;
import dsnakam.escolas_perto_de_mim.exception.EnderecoNaoEncontradoException;
import dsnakam.escolas_perto_de_mim.service.DistanciaService;
import dsnakam.escolas_perto_de_mim.service.GeocodigoUsuarioService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuscaEscolaController {
    private final GeocodigoUsuarioService geocodigoUsuarioService;
    private final DistanciaService distanciaService;

    public BuscaEscolaController(GeocodigoUsuarioService geocodigoUsuarioService, DistanciaService distanciaService) {
        this.geocodigoUsuarioService = geocodigoUsuarioService;
        this.distanciaService = distanciaService;
    }

    @GetMapping("/escolas-proximas")
    public List<DistanciaService.EscolaDistancia> buscarEscolas(@RequestParam("q") String q) {
        GeocodigoUsuarioDTO geocodigoUsuario = geocodigoUsuarioService.findCoordinates(q).get(0);
        double latUsuario = Double.parseDouble(geocodigoUsuario.getLat());
        double lonUsuario = Double.parseDouble(geocodigoUsuario.getLon());

        return distanciaService.searchEscolasProximas(latUsuario, lonUsuario);
    }

}
