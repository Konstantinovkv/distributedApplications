package distributedApplications.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import distributedApplications.model.NasaDTO;
import distributedApplications.model.footballModel.FootballDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FootballService {

    private static final Logger LOGGER = Logger.getLogger(FootballService.class.getName());
    private final String url = "https://app.sportdataapi.com/api/v1/soccer/leagues?apikey=";
    private FootballDTO footballDTO;

    public FootballDTO getFootballInfo(){

        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(createUrl())
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            ObjectMapper objectMapper = new ObjectMapper();
            footballDTO = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), FootballDTO.class);

        } catch (IOException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return footballDTO;
    }

    private String readApiKey(){
        Path fileName = Path.of("footballApiKey.txt");
        String apiKey = null;
        try {
            apiKey = Files.readString(fileName) ;
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Cannot find footballApiKey.txt");
        }
        return apiKey;
    }

    private String createUrl(){
        return url + readApiKey();
    }

}
