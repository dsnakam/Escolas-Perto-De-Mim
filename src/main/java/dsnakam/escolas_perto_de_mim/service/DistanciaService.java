package dsnakam.escolas_perto_de_mim.service;

import dsnakam.escolas_perto_de_mim.entity.Escola;
import dsnakam.escolas_perto_de_mim.repository.EscolaRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DistanciaService {

    private final EscolaRepository escolaRepository;

    public DistanciaService(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double latRad1 = Math.toRadians(lat1);
        double latRad2 = Math.toRadians(lat2);
        double lonRad1 = Math.toRadians(lon1);
        double lonRad2 = Math.toRadians(lon2);

        double deltaLat = latRad1 - latRad2;
        double deltaLon = lonRad1 - lonRad2;

        double a = Math.pow(Math.sin(deltaLat/2), 2) + Math.cos(latRad1) * Math.cos(latRad2) * Math.pow(Math.sin(deltaLon/2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = 6371 * c;
        return distance;
    }

    public record EscolaDistancia(Escola escola, double distancia) {}

    public List<EscolaDistancia> searchEscolasProximas(double latUsuario, double lonUsuario) {
        List<EscolaDistancia> escolaDistanciaList = escolaRepository.findAll()
                .stream()
                .map(escola -> {
                    double distancia = calculateDistance(latUsuario, lonUsuario, escola.getLatitude(), escola.getLongitude());
                    EscolaDistancia escolaDistancia = new EscolaDistancia(escola, distancia);
                    return escolaDistancia;
                })
                .sorted(Comparator.comparingDouble(EscolaDistancia::distancia))
                .limit(100)
                .toList();
        return escolaDistanciaList;
    }

}
