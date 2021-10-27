package distributedApplications.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import distributedApplications.exception.InvalidCityNameException;
import distributedApplications.model.weatherModel.WeatherDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WeatherService {

    private static final Logger LOGGER = Logger.getLogger(WeatherService.class.getName());

    private final String url = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String defaultCity = "Plovdiv";
    private WeatherDTO weatherDTO;

    public WeatherDTO getWeatherInfo(String city) throws IOException, InvalidCityNameException {
        if (city.isEmpty()){
            city = defaultCity;
        }
        nameChecker(city);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(createUrl(city))
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();

        ObjectMapper objectMapper = new ObjectMapper();
        weatherDTO = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), WeatherDTO.class);

        return weatherDTO;
    }

    private void nameChecker(String city) throws InvalidCityNameException {
        Pattern p = Pattern.compile("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$");
        Matcher m = p.matcher(city);
        if (!m.matches()) {
            throw new InvalidCityNameException("Invalid city name.");
        }
    }

    private String readApiKey(){
        Path fileName = Path.of("weatherApiKey.txt");
        String apiKey = null;
        try {
            apiKey = Files.readString(fileName) ;
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Cannot find weatherApiKey.txt");
        }
        return apiKey;
    }

    private String createUrl(String city){
        Object[] params = new Object[]{city};
        return MessageFormat.format(url + "{0}&appid=" + readApiKey(), params);
    }

}
