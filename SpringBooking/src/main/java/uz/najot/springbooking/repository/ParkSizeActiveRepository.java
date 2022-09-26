package uz.najot.springbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import uz.najot.springbooking.dto.ParkSizeDto;
import uz.najot.springbooking.entity.ParkSizeActive;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkSizeActiveRepository extends JpaRepository<ParkSizeActive, Integer> {
    List<ParkSizeDto> getByParkIdAndIsActive(Integer parkId,boolean isActive);
    Optional<ParkSizeActive> findByIdAndIsActive(Integer id, Boolean isActive);
}