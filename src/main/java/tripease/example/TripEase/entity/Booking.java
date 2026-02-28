package tripease.example.TripEase.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import tripease.example.TripEase.Enum.Status;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookingId;
    private String pickup;
    private String destination;
    private int tripdistence;
    private Status tripstatus;
    private double billamount;
    @CreationTimestamp
    Date bookedAt;

    @UpdateTimestamp
    Date lastupdateAt;


}
