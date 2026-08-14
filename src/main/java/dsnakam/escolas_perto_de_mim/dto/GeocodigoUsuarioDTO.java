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
public class GeocodigoUsuarioDTO {

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lon")
    private String lon;
}
