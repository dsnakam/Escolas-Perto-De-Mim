package dsnakam.escolas_perto_de_mim.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "escolas")
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeEscola;

    @Column(nullable = false)
    private String diretoriaEnsino;

    @Column(nullable = false)
    private String municipio;

    @Column(nullable = false, unique = true)
    private Long codigoEscola;

    @Column(nullable = false, unique = true)
    private Long codigoMec;

    @Column(nullable = false)
    private String tipoLogradouro;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;
}
