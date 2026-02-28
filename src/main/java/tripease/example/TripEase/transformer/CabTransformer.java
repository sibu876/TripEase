package tripease.example.TripEase.transformer;

import tripease.example.TripEase.dtos.requests.CabReqdtos;
import tripease.example.TripEase.dtos.responses.CabResdtos;
import tripease.example.TripEase.entity.Cab;
import tripease.example.TripEase.entity.Driver;

public class CabTransformer {
    public static Cab cabReqdtostoCab(CabReqdtos cabReqdtos){
        return Cab.builder()
                .cabModel(cabReqdtos.getCabModel())
                .cabNumber(cabReqdtos.getCabNumber())
                .perkmrate(cabReqdtos.getPerkmrate())
                .available(true).build();
    }
    public static CabResdtos cabToCabResdtos(Cab cab, Driver driver){
        return CabResdtos.builder()
                .cabModel(cab.getCabModel())
                .cabNumber(cab.getCabNumber())
                .perkmrate(cab.getPerkmrate())
                .available(cab.isAvailable())
                .driverResdtos(DriverTransformer.driverToDriverResdtos(driver)).build();
    }
}
