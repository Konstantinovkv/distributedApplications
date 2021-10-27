package distributedApplications.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import distributedApplications.model.NasaDTO;
import distributedApplications.model.footballModel.FootballDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FootballService {

    private static final Logger LOGGER = Logger.getLogger(FootballService.class.getName());
    private final String url = "https://app.sportdataapi.com/api/v1/soccer/leagues?apikey=<API-KEY>";
    private FootballDTO footballDTO;

    public FootballDTO getFootballInfo(){
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(url)
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

}
