package personal.gabornt.artistinfo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DescriptionRepository {
    public String getDescription() {
        return "<p><b>Nirvana</b> was an American rock band ...bla bla...";
    }
}
