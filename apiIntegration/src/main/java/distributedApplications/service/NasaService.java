package distributedApplications.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import distributedApplications.model.NasaDTO;
import distributedApplications.serviceImplementation.NasaServiceImplementation;
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
public class NasaService implements NasaServiceImplementation {

    private static final Logger LOGGER = Logger.getLogger(NasaService.class.getName());
    private final String url = "https://api.nasa.gov/planetary/apod?api_key=";
    private NasaDTO nasaDTO;

    public NasaDTO getPicture(){
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(createUrl())
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            ObjectMapper objectMapper = new ObjectMapper();
            nasaDTO = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), NasaDTO.class);

        } catch (IOException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return nasaDTO;
    }

    private String readApiKey(){
        Path fileName = Path.of("nasaApiKey.txt");
        String apiKey = null;
        try {
            apiKey = Files.readString(fileName) ;
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Cannot find nasaApiKey.txt");
        }
        return apiKey;
    }

    private String createUrl(){
        return url + "FjAXiWT40XtMzRZc7RWiZl5XV5xIiEI49DCzvXFb";
    }

}
