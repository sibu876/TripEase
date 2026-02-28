package tripease.example.TripEase.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tripease.example.TripEase.dtos.requests.DriverReqdtos;
import tripease.example.TripEase.dtos.responses.DriverResdtos;
import tripease.example.TripEase.entity.Driver;
import tripease.example.TripEase.repository.DriverRepository;
import tripease.example.TripEase.transformer.DriverTransformer;

@Service
public class DriverServices {

    @Autowired
    DriverRepository driverRepository;
    public DriverResdtos addDriver(DriverReqdtos driverReqdtos) {
        Driver driver = DriverTransformer.driverReqtoDriver(driverReqdtos);
        Driver saveddriver = driverRepository.save(driver);
        return DriverTransformer.driverToDriverResdtos(saveddriver);
    }
}
