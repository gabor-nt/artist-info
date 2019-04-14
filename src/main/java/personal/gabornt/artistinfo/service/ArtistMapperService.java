package personal.gabornt.artistinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.gabornt.artistinfo.model.dto.Album;
import personal.gabornt.artistinfo.model.dto.ArtistDetails;
import personal.gabornt.artistinfo.model.dto.musicbrainz.Artist;
import personal.gabornt.artistinfo.model.dto.musicbrainz.Relation;
import personal.gabornt.artistinfo.model.dto.musicbrainz.Release;
import personal.gabornt.artistinfo.repository.CoverArtRepository;
import personal.gabornt.artistinfo.repository.DescriptionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistMapperService {
    private final DescriptionRepository descriptionRepository;
    private final CoverArtRepository coverArtRepository;

    @Autowired
    public ArtistMapperService(DescriptionRepository descriptionRepository, CoverArtRepository coverArtRepository) {
        this.descriptionRepository = descriptionRepository;
        this.coverArtRepository = coverArtRepository;
    }

    public ArtistDetails map(Artist artist) {
        return new ArtistDetails(
                artist.getId(),
                buildDescription(artist.getRelations()),
                mapAlbums(artist.getReleaseGroups())
        );
    }

    private String buildDescription(List<Relation> relations) {
        return relations
                .stream()
                .filter(rel -> rel.getType() == Relation.Type.discogs)
                .map(rel -> descriptionRepository.getDescription(rel.getUrl().getResource()))
                .findFirst().orElse("Not found");
    }

    private List<Album> mapAlbums(List<Release> releaseGroups) {
        return releaseGroups.stream().map((release) -> new Album(
                release.getId(),
                release.getTitle(),
                coverArtRepository.getCoverImageUrl(release.getId())
        )).collect(Collectors.toList());
    }

}
