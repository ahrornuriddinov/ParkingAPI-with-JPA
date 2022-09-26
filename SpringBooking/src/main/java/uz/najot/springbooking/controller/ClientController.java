package uz.najot.springbooking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.najot.springbooking.dto.iml.ClientDto;
import uz.najot.springbooking.model.ResMessage;
import uz.najot.springbooking.service.ClientService;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    @PostMapping
    public ResMessage saveClient(@RequestBody ClientDto clientDto){
        return clientService.save(clientDto);
    }
    @GetMapping("get_info/{parkId}")
    public ResMessage exitClient(@RequestParam String carNumber, @PathVariable Integer parkId){
        return clientService.getInfo(carNumber, parkId);
    }
    @PostMapping("{parkId}")
    public ResMessage payClient(@RequestParam Double sum, @RequestParam Integer clientId, @PathVariable Integer parkId){
        return clientService.payClient(sum,clientId,parkId);
    }


}
