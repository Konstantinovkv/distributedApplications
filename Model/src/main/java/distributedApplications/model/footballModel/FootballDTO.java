package distributedApplications.model.footballModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class FootballDTO {

    @JsonIgnore
    public Query query;
    public List<Datum> data;

}
