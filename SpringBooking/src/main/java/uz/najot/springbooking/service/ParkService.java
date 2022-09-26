package uz.najot.springbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najot.springbooking.dto.iml.ParkDto;
import uz.najot.springbooking.dto.ParkSizeDto;
import uz.najot.springbooking.entity.Park;
import uz.najot.springbooking.model.ResMessage;
import uz.najot.springbooking.repository.ParkRepository;
import uz.najot.springbooking.repository.ParkSizeActiveRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkService {
    private final ParkRepository parkRepository;
    private final ParkSizeActiveRepository parkSizeActiveRepository;

    public ResMessage savePark(Park park) {
        parkRepository.save(park);
        return ResMessage.getSuccess(0, "success");
    }

    public ResMessage getParkList() {
        List<ParkDto> list = parkRepository.getNameAndId();
        return new ResMessage(0,"success",list);
    }

    public ResMessage getParkExistSize(Integer parkId) {
        List<ParkSizeDto> parkSize = parkSizeActiveRepository.getByParkIdAndIsActive(parkId, true);
        return ResMessage.getSuccess(parkSize);
    }
}
