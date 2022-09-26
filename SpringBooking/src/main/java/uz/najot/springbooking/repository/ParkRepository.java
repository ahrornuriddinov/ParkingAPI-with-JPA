package uz.najot.springbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.najot.springbooking.dto.iml.ParkDto;
import uz.najot.springbooking.entity.Park;

import java.util.List;

@Repository
public interface ParkRepository extends JpaRepository<Park, Integer> {
    @Query("select new uz.najot.springbooking.dto.iml.ParkDto(id,name) from Park ")
    List<ParkDto> getNameAndId();


}