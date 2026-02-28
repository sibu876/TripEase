package tripease.example.TripEase.dtos.responses;

import lombok.*;
import tripease.example.TripEase.Enum.Gender;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResdtos {

    private String name;
    private String emailId;
    private int age;
}
