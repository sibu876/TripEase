package tripease.example.TripEase.dtos.responses;


import lombok.*;
import tripease.example.TripEase.Enum.Status;


import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResdtos {
    private String pickup;
    private String destination;
    private int tripdistence;
    private Status tripstatus;
    private double billamount;
    Date bookedAt;
    Date lastupdateAt;
    CustomerResdtos customerResdtos;
    CabResdtos cabResdtos;

}
