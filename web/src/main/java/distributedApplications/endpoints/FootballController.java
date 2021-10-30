package distributedApplications.endpoints;

import distributedApplications.model.footballModel.FootballDTO;
import distributedApplications.serviceImplementation.FootballServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/football")
public class FootballController {

    @Autowired
    private FootballServiceImplementation footballServiceImplementation;

    @GetMapping(value = "/info")
    public ResponseEntity<FootballDTO> getPictureOfTheDay(){
        return new ResponseEntity<>(footballServiceImplementation.getFootballInfo(), HttpStatus.OK);
    }

}
