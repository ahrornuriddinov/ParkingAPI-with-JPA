package uz.najot.springbooking.dto;

import org.mapstruct.Mapper;
import uz.najot.springbooking.dto.iml.ClientInfoDto;
import uz.najot.springbooking.dto.iml.ParkDto;
import uz.najot.springbooking.entity.Client;

@Mapper(componentModel = "spring")
public interface DataMapper {
    ClientInfoDto getDto(Client t);

}
