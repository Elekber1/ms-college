package az.pashabank.mscollege.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeDto {

    private Long id;
    private String name;
    private String city;

}
