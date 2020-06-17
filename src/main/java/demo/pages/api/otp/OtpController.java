package demo.pages.api.otp;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OtpController {
    public Response getOtpNumber(String userId) throws InterruptedException {
        //pokemonName = pokemonName.toLowerCase();
        Thread.sleep(7000);
        Response response = given().baseUri("https://pokeapi.co").basePath("/api")
                .pathParam("userId", userId)
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON).get("/otp/{userId}");
        response.getBody().prettyPrint();
        return response;
    }
}
