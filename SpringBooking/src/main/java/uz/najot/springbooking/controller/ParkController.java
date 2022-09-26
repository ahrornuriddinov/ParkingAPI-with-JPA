package uz.najot.springbooking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.najot.springbooking.entity.Park;
import uz.najot.springbooking.model.ResMessage;
import uz.najot.springbooking.service.ParkService;

@RestController
@RequestMapping("/park")
@RequiredArgsConstructor
public class ParkController {
    private final ParkService parkService;

    @PostMapping
    public ResMessage savePark(@RequestBody Park park){
        return parkService.savePark(park);
    }
    @GetMapping
    public ResMessage getParkList(){
        return parkService.getParkList();
    }
    @GetMapping("{parkId}")
    public ResMessage getParkExistSize(@PathVariable Integer parkId){
        return parkService.getParkExistSize(parkId);
    }
}
