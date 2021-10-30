package distributedApplications.serviceImplementation;

import distributedApplications.exception.InvalidCityNameException;
import distributedApplications.model.weatherModel.WeatherDTO;

import java.io.IOException;

public interface WeatherServiceImplementation {

    /**
     * Validates the input and sends a request to the weather api
     * for a particular city and returns the results.
     *
     * @return The results mapped into the WeatherDTO class
     */
    WeatherDTO getWeatherInfo(String city) throws IOException, InvalidCityNameException;
}
