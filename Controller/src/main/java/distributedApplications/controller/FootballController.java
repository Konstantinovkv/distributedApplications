package distributedApplications.controller;

import distributedApplications.model.footballModel.FootballDTO;
import distributedApplications.service.FootballService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/football")
public class FootballController {

    @GetMapping(value = "/info")
    public ResponseEntity<FootballDTO> getPictureOfTheDay(){
        FootballService footballService = new FootballService();
        return new ResponseEntity<>(footballService.getFootballInfo(), HttpStatus.OK);
    }

}
