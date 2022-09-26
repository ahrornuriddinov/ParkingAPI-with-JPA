package uz.najot.springbooking.dto.iml;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String carNumber;
    private Integer parkId;
    private Integer place_id;
}
