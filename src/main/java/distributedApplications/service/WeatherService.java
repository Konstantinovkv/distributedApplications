package distributedApplications.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import distributedApplications.exception.InvalidCityNameException;
import distributedApplications.model.weatherModels.WeatherDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WeatherService {

    private String url = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String apiKey = "&appid=<API-KEY>";
    private String defaultCity = "Plovdiv";
    private WeatherDTO weatherDTO;

    public WeatherDTO getWeatherInfo(String city) throws IOException, InvalidCityNameException {
        if (city.isEmpty()){
            city = defaultCity;
        }
        nameChecker(city);
        String completeUrl = url + city + apiKey;

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(completeUrl)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();

        ObjectMapper objectMapper = new ObjectMapper();
        weatherDTO = objectMapper.readValue(response.body().string(), WeatherDTO.class);

        return weatherDTO;
    }

    private void nameChecker(String city) throws InvalidCityNameException {
        Pattern p = Pattern.compile("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$");
        Matcher m = p.matcher(city);
        if (!m.matches()) {
            throw new InvalidCityNameException("Invalid city name.");
        }
    }

}
