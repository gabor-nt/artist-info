package personal.gabornt.artistinfo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import personal.gabornt.artistinfo.service.DiscogsWebService;

@Repository
public class DescriptionRepository {
    private final DiscogsWebService webService;

    @Autowired
    public DescriptionRepository(DiscogsWebService webService) {
        this.webService = webService;
    }

    @Cacheable("descriptions")
    public String getDescription(String resourcePath) {
        return webService.getArtist(getLastPartOfPath(resourcePath)).getProfile();
    }

    private String getLastPartOfPath(String resourcePath) {
        String[] split = resourcePath.split("/");
        return split[split.length - 1];
    }
}
