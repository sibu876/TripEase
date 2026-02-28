package tripease.example.TripEase.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tripease.example.TripEase.dtos.requests.DriverReqdtos;
import tripease.example.TripEase.dtos.responses.DriverResdtos;
import tripease.example.TripEase.services.DriverServices;

@RestController
@RequestMapping("/Driver")
public class DriverController {

    @Autowired
    DriverServices driverServices;

    @PostMapping("/add")
    public DriverResdtos addDriver(@RequestBody DriverReqdtos driverReqdtos){
        return  driverServices.addDriver(driverReqdtos);
    }
}
