package az.pashabank.mscollege.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {

    private Long id;
    private String name;
    private String lastname;
    private CollegeModel college;
}
