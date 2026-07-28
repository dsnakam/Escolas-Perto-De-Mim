package dsnakam.escolas_perto_de_mim.repository;

import dsnakam.escolas_perto_de_mim.entity.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escola, Long> {
}
