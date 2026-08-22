package dsnakam.escolas_perto_de_mim.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanciaServiceTest {

    @Test
    void shouldReturnDistance() {
        DistanciaService distanciaService = new DistanciaService(null);

        double distance = distanciaService.calculateDistance(-23.6844267, -46.6275367, -23.686102, -46.6269518);
        double expectedResponse = 0.1956;
        assertEquals(expectedResponse, distance, 0.001);
    }

}
