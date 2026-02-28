package tripease.example.TripEase.entity;


import jakarta.persistence.*;
import lombok.*;
import tripease.example.TripEase.Enum.Gender;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DriverId;
    private String name;

    @Column(unique = true,nullable = false)
    private String emailId;

    private String drivingLisence;
    private String driverage;
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="driver_id")
    List<Booking> bookings = new ArrayList<>();

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="cab_id")
    Cab cab;
}
