package tripease.example.TripEase.dtos.responses;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CabResdtos {
    private String cabNumber;

    private String cabModel;
    private double perkmrate;
    private  boolean available;
    private DriverResdtos driverResdtos;

}
