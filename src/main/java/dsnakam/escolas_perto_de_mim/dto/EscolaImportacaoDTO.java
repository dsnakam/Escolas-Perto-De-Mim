package dsnakam.escolas_perto_de_mim.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EscolaImportacaoDTO {

    @JsonProperty("NOMESC")
    private String nomeEscola;

    @JsonProperty("DE")
    private String diretoriaEnsino;

    @JsonProperty("MUN")
    private String municipio;

    @JsonProperty("COD_ESC")
    private Long codigoEscola;

    @JsonProperty("CODESCMEC")
    private Long codigoMec;

    @JsonProperty("COMPLEMENTO")
    private String tipoLogradouro;

    @JsonProperty("ENDESC")
    private String endereco;

    @JsonProperty("NUMESC")
    private String numero;

    @JsonProperty("BAIESC")
    private String bairro;

    @JsonProperty("CEP")
    private String cep;

    @JsonProperty("DS_LATITUDE")
    private String latitude;

    @JsonProperty("DS_LONGITUDE")
    private String longitude;
}
