package uz.najot.springbooking.entity;

import lombok.*;
import uz.najot.springbooking.entity.enums.ClientType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends BaseEntity {
    @Column(nullable = false)
    private String carNumber;
    @Enumerated(EnumType.STRING)
    private ClientType clientType;
    @ManyToOne
    private Park park;
    @ManyToOne
    private Tariff tariff;
    private Double payment;
    @ManyToOne
    private ParkSizeActive parkSizeActive;


}
