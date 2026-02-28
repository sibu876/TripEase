package tripease.example.TripEase.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabId;

    @Column(unique = true,nullable = false)
    private String cabNumber;

    private String cabModel;

    private double perkmrate;

    private boolean available;
}
