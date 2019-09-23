package az.pashabank.mscollege.service;


import az.pashabank.mscollege.dto.CollegeDto;
import az.pashabank.mscollege.model.CollegeModel;

import java.util.List;

public interface CollegeService {

    List<CollegeDto> findAllCollege();
    CollegeDto findCollegeById(Long collegeId);
    void addCollege(CollegeModel college);
    void updateCollege(CollegeModel college);
    void deleteCollegeById(Long collegeId);
}
