package az.pashabank.mscollege.service;

import az.pashabank.mscollege.dto.CollegeDto;
import az.pashabank.mscollege.model.CollegeModel;
import az.pashabank.mscollege.repository.CollegeRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeRepositroy collegeRepositroy;

    @Autowired
    public CollegeServiceImpl(CollegeRepositroy collegeRepositroy) {
        this.collegeRepositroy = collegeRepositroy;
    }

    @Override
    public List<CollegeDto> findAllCollege() {
        return collegeRepositroy.findAllCollege();
    }

    @Override
    public CollegeDto findCollegeById(Long collegeId) {
        List<CollegeDto> result = collegeRepositroy.findAllCollege().stream().filter(collegeDto -> collegeDto.getId().equals(collegeId)).collect(Collectors.toList());
        return result.isEmpty() == false ? result.get(0) : null;
    }

    @Override
    public void addCollege(CollegeModel college) {
        collegeRepositroy.addCollege(college);
    }

    @Override
    public void updateCollege(CollegeModel college) {
    collegeRepositroy.updateCollege(college);
    }

    @Override
    public void deleteCollegeById(Long collegeId) {
    collegeRepositroy.deleteCollegeById(collegeId);
    }
}
