package distributedApplications.model.weatherModel;

import lombok.Getter;

import java.util.List;

@Getter
public class WeatherDTO {

    public Coord coord;
    public List<Weather> weather;
    public String base;
    public Main main;
    public int visibility;
    public Wind wind;
    public Clouds clouds;
    public Rain rain;
    public int dt;
    public Sys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;

}
