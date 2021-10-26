package distributedApplications.response;

import distributedApplications.model.weatherModels.WeatherDTO;
import lombok.Getter;

@Getter
public class WeatherResponse {

    public WeatherResponse(String message, WeatherDTO weatherInfo) {
        this.message = message;
        this.weatherInfo = weatherInfo;
    }

    private String message;
    private WeatherDTO weatherInfo;
}
