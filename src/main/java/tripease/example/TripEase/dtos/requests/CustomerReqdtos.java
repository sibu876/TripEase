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
public class CustomerReqdtos {

    private String name;
    private String emailId;
    private int age;
    private Gender gender;
}
