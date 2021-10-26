package distributedApplications.model.weatherModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Coord{
    public double lon;
    public double lat;
}
