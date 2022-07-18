package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import helpers.PreRequestsScripts;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Data
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private PreRequestsScripts.StatusOrderPet status;
    private boolean complete;

}
