package uz.najot.springbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najot.springbooking.dto.iml.ClientDto;
import uz.najot.springbooking.dto.iml.ClientInfoDto;
import uz.najot.springbooking.dto.DataMapper;
import uz.najot.springbooking.entity.Client;
import uz.najot.springbooking.entity.Park;
import uz.najot.springbooking.entity.ParkSizeActive;
import uz.najot.springbooking.entity.Tariff;
import uz.najot.springbooking.entity.enums.ClientType;
import uz.najot.springbooking.model.ResMessage;
import uz.najot.springbooking.repository.ClientRepository;
import uz.najot.springbooking.repository.ParkRepository;
import uz.najot.springbooking.repository.ParkSizeActiveRepository;
import uz.najot.springbooking.repository.TariffRepository;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ParkRepository parkRepository;
    private final ParkSizeActiveRepository parkSizeActiveRepository;
    private final TariffRepository tariffRepository;
    private final DataMapper dataMapper;
    @Transactional
    public ResMessage save(ClientDto clientDto) {

        Park park = parkRepository.getReferenceById(clientDto.getParkId());
        Optional<ParkSizeActive> optionalParkSizeActive = parkSizeActiveRepository.findByIdAndIsActive(clientDto.getPlace_id(), true);
        if (optionalParkSizeActive.isPresent()){
            ParkSizeActive parkSizeActive = optionalParkSizeActive.get();
            parkSizeActive.setIsActive(false);
//            parkSizeActiveRepository.save(parkSizeActive);
            Client client = new Client(clientDto.getCarNumber(), ClientType.ENTERED, park, null, null,parkSizeActive);
            Client save = clientRepository.save(client);
        }


        return ResMessage.getSuccess(null);
    }

    public ResMessage getInfo(String carNumber, Integer parkId) {
        Optional<Client> optionalClient = clientRepository.findByParkIdAndCarNumberAndClientType(parkId, carNumber, ClientType.ENTERED);
        if (optionalClient.isPresent()){
            Client client = optionalClient.get();
            Date createdDate = client.getCreatedDate();
            int diff= (int) (new Date().getTime()-createdDate.getTime())/1000/60;
            Optional<Tariff> optionalTariff = tariffRepository.findByEndTimeGreaterThanEqualAndStartTimeLessThanEqual(diff, diff);
            if (optionalTariff.isPresent()){
                Tariff tariff = optionalTariff.get();
                client.setTariff(tariff);
                clientRepository.save(client);
                ClientInfoDto infoMapper = getInfoMapper(client);

                return ResMessage.getSuccess(infoMapper);
            }

        }else {
            return new ResMessage(101,"Not found",null);
        }
         return new ResMessage(101,"Not found",null);
    }
    static ClientInfoDto getInfoMapper(Client client){
        ClientInfoDto clientInfoDto = new ClientInfoDto();
        clientInfoDto.setId(client.getId());
        clientInfoDto.setTariff(client.getTariff());
        clientInfoDto.setCarNumber(client.getCarNumber());
        clientInfoDto.setUpdatedDate(client.getUpdateDate());
        clientInfoDto.setCreateDate(client.getCreatedDate());
        return clientInfoDto;
    }

    public ResMessage payClient(Double sum, Integer clientId, Integer parkId) {
        Optional<Client> optionalClient = clientRepository.findByIdAndParkIdAndClientType(clientId, parkId, ClientType.ENTERED);
        if (optionalClient.isPresent()){
            Client client = optionalClient.get();
            Double price = client.getTariff().getPrice();
            if (price.equals(sum)){
                client.setPayment(price);
                client.setClientType(ClientType.EXITED);
                clientRepository.save(client);
                ParkSizeActive parkSizeActive = client.getParkSizeActive();
                parkSizeActive.setIsActive(true);
                parkSizeActiveRepository.save(parkSizeActive);
                return ResMessage.getSuccess(null);
            }else {
                return new ResMessage(102,"sum not enough", null);
            }
        }
        return  new ResMessage(101, "not found", null);
    }


}
