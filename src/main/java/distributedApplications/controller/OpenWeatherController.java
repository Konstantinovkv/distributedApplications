package distributedApplications.controller;

import distributedApplications.exception.InvalidCityNameException;
import distributedApplications.model.weatherModels.City;
import distributedApplications.model.weatherModels.WeatherDTO;
import distributedApplications.response.WeatherResponse;
import distributedApplications.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/weather")
public class OpenWeatherController {

    private static final Logger LOGGER = Logger.getLogger(OpenWeatherController.class.getName());

    @GetMapping(value = "/forecast")
    public ResponseEntity<WeatherResponse> getTheWeather(@RequestBody City city){
        WeatherService weatherService = new WeatherService();
        WeatherDTO weatherDTO;
        try {
            weatherDTO = weatherService.getWeatherInfo(city.getCity());
        } catch (IOException | InvalidCityNameException e) {
            LOGGER.log(Level.INFO, e.getMessage());
            return new ResponseEntity<>(new WeatherResponse(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new WeatherResponse("Success.", weatherDTO), HttpStatus.OK);
    }

}
