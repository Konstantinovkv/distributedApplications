package distributedApplications.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import distributedApplications.model.NasaDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class NasaService {

    private static final Logger LOGGER = Logger.getLogger(NasaService.class.getName());
    private String url = "https://api.nasa.gov/planetary/apod?api_key=<API-KEY>>";
    private NasaDTO nasaDTO;

    public NasaDTO getPicture(){
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            ObjectMapper objectMapper = new ObjectMapper();
            nasaDTO = objectMapper.readValue(response.body().string(), NasaDTO.class);

        } catch (IOException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return nasaDTO;
    }
}
