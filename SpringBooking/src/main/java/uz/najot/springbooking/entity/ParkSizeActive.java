package uz.najot.springbooking.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
public class ParkSizeActive extends BaseEntity{
    @ManyToOne
    private Park park;

    public ParkSizeActive(Park park) {
        this.park = park;
    }
}
