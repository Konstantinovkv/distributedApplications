package distributedApplications.serviceImplementation;

import distributedApplications.model.footballModel.FootballDTO;

public interface FootballServiceImplementation {

    /**
     * Sends a request to the football api and returns the results.
     *
     * @return The results mapped into the FootballDTO class
     */
    FootballDTO getFootballInfo();
}
