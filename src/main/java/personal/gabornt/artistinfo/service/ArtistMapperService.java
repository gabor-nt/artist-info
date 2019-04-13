package personal.gabornt.artistinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.gabornt.artistinfo.model.dto.Album;
import personal.gabornt.artistinfo.model.dto.ArtistDetails;
import personal.gabornt.artistinfo.model.dto.musicbrainz.Artist;
import personal.gabornt.artistinfo.repository.CoverImageRepository;
import personal.gabornt.artistinfo.repository.DescriptionRepository;

import java.util.stream.Collectors;

@Service
public class ArtistMapperService {
    private final DescriptionRepository descriptionRepository;
    private final CoverImageRepository coverImageRepository;

    @Autowired
    public ArtistMapperService(DescriptionRepository descriptionRepository, CoverImageRepository coverImageRepository) {
        this.descriptionRepository = descriptionRepository;
        this.coverImageRepository = coverImageRepository;
    }

    public ArtistDetails map(Artist artist) {
        return new ArtistDetails(
                artist.getId(),
                descriptionRepository.getDescription(),
                artist.getReleaseGroups().stream().map((release) -> new Album(
                        release.getId(),
                        release.getTitle(),
                        coverImageRepository.createImageUrl(release.getId())
                )).collect(Collectors.toList())
        );
    }
}
