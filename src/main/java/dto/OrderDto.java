package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import helpers.PreRequestsScriptsRestAssured;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

    private Long id;
    private Long petId;
    private int quantity;
    private String shipDate;
    private PreRequestsScriptsRestAssured.StatusOrderPet status;
    private boolean complete;

}
