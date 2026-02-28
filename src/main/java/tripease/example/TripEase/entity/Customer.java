package tripease.example.TripEase.entity;


import jakarta.persistence.*;
import lombok.*;
import tripease.example.TripEase.Enum.Gender;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;

    @Column(unique = true,nullable = false)
    private String emailId;

    private int age;
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Customer_id")
    List<Booking> bookings = new ArrayList<>();

}
