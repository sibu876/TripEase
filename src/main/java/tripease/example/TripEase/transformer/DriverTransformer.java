package tripease.example.TripEase.transformer;

import tripease.example.TripEase.dtos.requests.DriverReqdtos;
import tripease.example.TripEase.dtos.responses.DriverResdtos;
import tripease.example.TripEase.entity.Driver;

public class DriverTransformer {
    public static Driver driverReqtoDriver(DriverReqdtos driverReqdtos){
       return  Driver.builder()
               .name(driverReqdtos.getName())
               .driverage(driverReqdtos.getDriverage())
               .drivingLisence(driverReqdtos.getDrivinglisence())
               .emailId(driverReqdtos.getEmailId())
               .gender(driverReqdtos.getGender()).build();
    }

    public static DriverResdtos driverToDriverResdtos(Driver driver){
        return DriverResdtos.builder()
                .name(driver.getName())
                .driverage(driver.getDriverage())
                .emailId(driver.getEmailId()).build();
    }
}
