package tripease.example.TripEase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tripease.example.TripEase.dtos.requests.CabReqdtos;
import tripease.example.TripEase.dtos.responses.CabResdtos;
import tripease.example.TripEase.entity.Cab;
import tripease.example.TripEase.entity.Driver;
import tripease.example.TripEase.exceptions.DriverNotFoundException;
import tripease.example.TripEase.repository.DriverRepository;
import tripease.example.TripEase.transformer.CabTransformer;

import java.util.Optional;

@Service
public class CabServices {

    @Autowired
    DriverRepository driverRepository;

    public CabResdtos addCab(CabReqdtos cabReqdtos,int id) {
        Optional<Driver> optionaldriver = driverRepository.findById(id);
        if(optionaldriver.isEmpty()){
            throw new DriverNotFoundException("Driver Id is Not found");
        }
        Driver driver = optionaldriver.get();
        Cab cab = CabTransformer.cabReqdtostoCab(cabReqdtos);
        driver.setCab(cab);
        driverRepository.save(driver);

        return CabTransformer.cabToCabResdtos(driver.getCab(),driver);
    }
}
