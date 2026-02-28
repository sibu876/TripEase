package tripease.example.TripEase.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tripease.example.TripEase.dtos.requests.CabReqdtos;
import tripease.example.TripEase.dtos.responses.CabResdtos;
import tripease.example.TripEase.services.CabServices;

@RestController
@RequestMapping("/Cab")
public class CabController {

    @Autowired
    CabServices cabServices;

    @PostMapping("/add/{id}")
    public CabResdtos addCab(@RequestBody CabReqdtos cabReqdtos , @PathVariable("id") int id){
        return cabServices.addCab(cabReqdtos,id);
    }
}
