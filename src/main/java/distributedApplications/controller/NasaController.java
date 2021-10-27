package distributedApplications.controller;

import distributedApplications.model.NasaDTO;
import distributedApplications.service.NasaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/nasa")
public class NasaController {

    @GetMapping(value = "/picture")
    public ResponseEntity<NasaDTO> getPictureOfTheDay(){
        NasaService nasaService = new NasaService();
        return new ResponseEntity<>(nasaService.getPicture(), HttpStatus.OK);
    }

}
