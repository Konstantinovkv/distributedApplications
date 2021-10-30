package distributedApplications.serviceImplementation;

import distributedApplications.model.NasaDTO;

public interface NasaServiceImplementation {

    /**
     * Sends a request to the nasa api and returns the results.
     *
     * @return The results mapped into the NasaDTO class
     */
    NasaDTO getPicture();
}
