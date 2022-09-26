package uz.najot.springbooking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.najot.springbooking.dto.ParkGetName;
import uz.najot.springbooking.repository.ParkRepository;

import java.util.List;

@SpringBootTest
class SpringBookingApplicationTests {

    @Autowired
    ParkRepository parkRepository;
    @Test
    void contextLoads() {
        List<ParkGetName> name = parkRepository.getName();
        System.out.println(name);
    }

}
