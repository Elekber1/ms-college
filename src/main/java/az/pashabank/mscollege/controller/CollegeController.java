package az.pashabank.mscollege.controller;

import az.pashabank.mscollege.dto.CollegeDto;
import az.pashabank.mscollege.model.CollegeModel;
import az.pashabank.mscollege.service.CollegeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CollegeController {

    @Autowired
    CollegeService collegeService;

    private static final Logger LOGGER= LoggerFactory.getLogger(CollegeController.class);

    // ok
    @GetMapping(value = "/findAllCollege")
    public List<CollegeDto> findAllStudents() {
        List<CollegeDto> colleges = collegeService.findAllCollege();
        return colleges;
    }

    // ok
    @GetMapping(value = "/findCollegeById/{collegeId}")
    public CollegeDto findCollegeById(@PathVariable Long collegeId) {
        return collegeService.findCollegeById(collegeId);
    }
    // ok
    @PostMapping(value = "/addCollege")
    public ResponseEntity addCollege(@RequestParam(value = "id", required = false) Long id,
                                     @RequestParam(value = "name", required = false) String name,
                                     @RequestParam(value = "city", required = false) String city,
                                     HttpServletRequest httpServletRequest) {
        LOGGER.info("addCollege "+ httpServletRequest.getRemoteAddr());
        CollegeModel collegeModel = new CollegeModel();
        collegeModel.setId(id);
        collegeModel.setName(name);
        collegeModel.setCity(city);
        collegeService.addCollege(collegeModel);
        if (collegeModel.getId() != null && collegeModel.getName() != null && collegeModel.getCity() != null ) {
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    // ok
    @PostMapping(value = "/updateCollege")
    public ResponseEntity updateCollege(@RequestParam(value = "id", required = false) Long id,
                                     @RequestParam(value = "name", required = false) String name,
                                     @RequestParam(value = "city", required = false) String city,
                                     HttpServletRequest httpServletRequest) {
        LOGGER.info("updateCollege "+ httpServletRequest.getRemoteAddr());
        CollegeModel collegeModel = new CollegeModel();
        collegeModel.setId(id);
        collegeModel.setName(name);
        collegeModel.setCity(city);
        collegeService.updateCollege(collegeModel);
        if (collegeModel.getId() != null && collegeModel.getName() != null && collegeModel.getCity() != null ) {
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    // ok
    @PostMapping(value = "/deleteCollege/{collegeId}")
    public ResponseEntity deleteCollege(@PathVariable Long collegeId,
                                        HttpServletRequest httpServletRequest) {
        LOGGER.info("deleteCollege "+ httpServletRequest.getRemoteAddr());
        collegeService.deleteCollegeById(collegeId);
        if (collegeId != null ) {
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
