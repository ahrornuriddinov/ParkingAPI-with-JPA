package uz.najot.springbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.najot.springbooking.entity.Client;
import uz.najot.springbooking.entity.enums.ClientType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByParkIdAndCarNumberAndClientType(Integer parkId, String carNumber, ClientType clientType);
    Optional<Client> findByIdAndParkIdAndClientType(Integer id, Integer parkId, ClientType clientType);

}