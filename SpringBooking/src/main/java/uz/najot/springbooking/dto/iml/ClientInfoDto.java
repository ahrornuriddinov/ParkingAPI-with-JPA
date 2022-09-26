package uz.najot.springbooking.dto.iml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najot.springbooking.entity.Tariff;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfoDto {
    private Integer id;
    private String carNumber;
    private Date createDate;
    @JsonProperty("exited")
    private Date updatedDate;
    private Tariff tariff;
}
