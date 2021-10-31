package distributedApplications.endpoints;

import distributedApplications.exception.InvalidCityNameException;
import distributedApplications.model.weatherModel.City;
import distributedApplications.model.weatherModel.WeatherDTO;
import distributedApplications.response.WeatherResponse;
import distributedApplications.serviceImplementation.WeatherServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/weather")
public class OpenWeatherController {

    @Autowired
    private WeatherServiceImplementation weatherServiceImplementation;
    private static final Logger LOGGER = Logger.getLogger(OpenWeatherController.class.getName());

    @PostMapping(value = "/forecast")
    public ResponseEntity<WeatherResponse> getTheWeather(@RequestBody City city){
        WeatherDTO weatherDTO;
        try {
            weatherDTO = weatherServiceImplementation.getWeatherInfo(city.getCity());
        } catch (IOException | InvalidCityNameException e) {
            LOGGER.log(Level.INFO, e.getMessage());
            return new ResponseEntity<>(new WeatherResponse(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new WeatherResponse("Success.", weatherDTO), HttpStatus.OK);
    }

}
