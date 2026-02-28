package tripease.example.TripEase.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tripease.example.TripEase.Enum.Gender;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverReqdtos {
    private String name;
    private String emailId;
    private String driverage;
    private String drivinglisence;
    private Gender gender;
}
