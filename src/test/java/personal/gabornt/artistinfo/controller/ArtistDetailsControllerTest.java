package personal.gabornt.artistinfo.controller;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArtistDetailsControllerTest {
    @LocalServerPort
    int port;

    @Before
    public void setup() {
        RestAssured.port = port;
        RestAssured.basePath = "/artists";
    }

    @Test
    public void getDetailsById_ShouldReturnExample() {
        final UUID testID = UUID.fromString("5b11f4ce-a62d-471e-81fc-a69a8278c7da");
        RestAssured.given()
                .get("/" + testID)
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .body("mbid", equalTo(testID.toString()))
                .body("description",
                        equalTo("Alternative rock band from Aberdeen, Washington, USA.\r\n\r\nNirvana formed in 1987. Considered by many to be the leading lights of the Seattle grunge scene of the late 1980s/early 1990s, and perhaps the most influential rock band of Generations X & Y, Nirvana was a powerful trio of musicians who brought a unique aesthetic to a growing-stale rock scene.  They had already made some waves on Sub Pop with their debut, \"[m=13773]\".  But it wasn't until their major-label debut for [l=DGC]/[l=Geffen Records], 1991's \"[m=13814]\" - perhaps, more specifically, the first 30 seconds of \"[m=22439]\" - that they broke into the mainstream of America - not really because they wanted to. Lead singer frontman [a=Kurt Cobain]'s death (suicide) in April 1994 brought an untimely end to the band. Drummer [a=Dave Grohl] went on to form the [a=Foo Fighters].  In the fall of 2004, \"[m=42482]\" (a 3-CD/DVD set of mostly unreleased material) confirmed that interest in the band is still very high. Most young rock stars today will likely cite Nirvana as a major influence on them. Nirvana disbanded in 1994.")
                )
                .body("albums[4].id", equalTo("1b022e01-4da6-387b-8658-8678046e4cef"))
                .body("albums[4].title", equalTo("Nevermind"))
                .body("albums[4].Image",
                        equalTo("http://coverartarchive.org/release/a146429a-cedc-3ab0-9e41-1aaf5f6cdc2d/3012495605.jpg")
                )
        ;
    }

    @Test
    public void getDetailsById_ShouldReturnAlternative_WhenArtistHasNoDiscogsRelation() {
        final UUID testID = UUID.fromString("e5d5f00f-9f3a-4fc5-b082-07e65278fdfb");
        RestAssured.given()
                .get("/" + testID)
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .body("mbid", equalTo(testID.toString()))
                .body("description", equalTo("Not found"))
                .body("albums[2].id", equalTo("e7cc5033-b6b4-46c2-bae6-d8ebf5d9798a"))
                .body("albums[2].title", equalTo("Adlait"))
                .body("albums[2].Image",
                        equalTo("http://coverartarchive.org/release/37f953e1-14da-4268-ba2b-7c63eac25184/15314067900.jpg")
                )
        ;
    }

    @Test
    public void getDetailsById_ShouldReturnAlternative_WhenArtistHasNoDiscogsDescription() {
        final UUID testID = UUID.fromString("d909c383-5063-4c05-8006-acaebdff142c");
        RestAssured.given()
                .get("/" + testID)
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .body("mbid", equalTo(testID.toString()))
                .body("description", equalTo(""))
                .body("albums[5].id", equalTo("f3c8f096-0dd7-4d20-9732-ed8ba6ccc231"))
                .body("albums[5].title", equalTo("Queen of Golden Dogs"))
                .body("albums[5].Image",
                        equalTo("http://coverartarchive.org/release/3b997eda-902d-4986-83c4-2d86cd3c8f11/20998820774.jpg")
                )
        ;
    }

    @Test
    public void getDetailsById_ShouldX_WhenIdIsInvalid() {
        final UUID testID = UUID.fromString("00000000-0000-0000-0000-000000000000");

        RestAssured.given()
                .get("/" + testID)
                .then()
                .log().all()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .body("message", equalTo("Artist not found"))
        ;
    }

}
