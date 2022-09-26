package uz.najot.springbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tariff extends BaseEntity{
    private int startTime;
    private int endTime;
    private Double price;
}
