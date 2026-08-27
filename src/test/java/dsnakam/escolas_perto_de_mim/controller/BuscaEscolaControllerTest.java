package dsnakam.escolas_perto_de_mim.controller;

import dsnakam.escolas_perto_de_mim.dto.GeocodigoUsuarioDTO;
import dsnakam.escolas_perto_de_mim.exception.EnderecoNaoEncontradoException;
import dsnakam.escolas_perto_de_mim.service.DistanciaService;
import dsnakam.escolas_perto_de_mim.service.GeocodigoUsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BuscaEscolaControllerTest {

    @Mock
    private GeocodigoUsuarioService geocodigoUsuarioService;

    @Mock
    private DistanciaService distanciaService;

    @InjectMocks
    private BuscaEscolaController buscaEscolaController;

    @Test
    void shouldReturnEmptyListWhenNoEscolasAreFound() {
        String testEndereco = "test endereço";

        GeocodigoUsuarioDTO fakeGeocodigo =
                new GeocodigoUsuarioDTO("-23.5613", "-46.6565");

        List<DistanciaService.EscolaDistancia> expectedEscolas = List.of();

        when(geocodigoUsuarioService.findCoordinates(testEndereco))
                .thenReturn(List.of(fakeGeocodigo));

        when(distanciaService.searchEscolasProximas(
                -23.5613,
                -46.6565
        )).thenReturn(expectedEscolas);

        List<DistanciaService.EscolaDistancia> actualEscolas =
                buscaEscolaController.buscarEscolas(testEndereco);

        assertEquals(expectedEscolas, actualEscolas);

        verify(geocodigoUsuarioService).findCoordinates(testEndereco);

        verify(distanciaService).searchEscolasProximas(
                -23.5613,
                -46.6565
        );
    }

    @Test
    void shouldThrowExceptionWhenEnderecoNotFound() {
        String testEndereco = "test endereço";

        when(geocodigoUsuarioService.findCoordinates(testEndereco)).thenThrow(new EnderecoNaoEncontradoException("Endereço não encontrado."));
        assertThrows(EnderecoNaoEncontradoException.class, () -> buscaEscolaController.buscarEscolas(testEndereco));

        verify(geocodigoUsuarioService).findCoordinates(testEndereco);
    }
}
