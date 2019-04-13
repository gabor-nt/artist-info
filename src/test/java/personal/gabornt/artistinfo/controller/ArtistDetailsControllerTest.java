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
    public void getDetailsById() {
        final UUID testID = UUID.fromString("5b11f4ce-a62d-471e-81fc-a69a8278c7da");
        RestAssured.given()
                .get("/" + testID)
                .then()
                .log().ifValidationFails()
                .statusCode(HttpStatus.OK.value())
                .body("mbid", equalTo(testID.toString()))
                .body("description", equalTo("<p><b>Nirvana</b> was an American rock band ...bla bla..."))
                .body("albums[4].id", equalTo("1b022e01-4da6-387b-8658-8678046e4cef"))
                .body("albums[4].title", equalTo("Nevermind"))
                .body("albums[4].Image", equalTo("http://coverartarchive.org/release/a146429a-cedc-3ab0-9e41-1aaf5f6cdc2d/3012495605.jpg"))
        ;
    }

}
