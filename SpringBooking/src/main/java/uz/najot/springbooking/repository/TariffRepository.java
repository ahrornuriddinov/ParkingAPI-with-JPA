package uz.najot.springbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import uz.najot.springbooking.entity.Tariff;

import java.util.Optional;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Integer> {
    Optional<Tariff> findByEndTimeGreaterThanEqualAndStartTimeLessThanEqual(Integer time, Integer secondTime);
}