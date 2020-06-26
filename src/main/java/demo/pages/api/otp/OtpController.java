package demo.pages.api.otp;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OtpController {
    public Response getOtpNumber(String userId) {

//        Thread.sleep(7000);
//        Response response = given().baseUri("https://pokeapi.co").basePath("/member")
//                .pathParam("userId", userId)
//                .log().all()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON).get("/{userId}");
//        response.getBody().prettyPrint();
//        return response;
        String bodyRequest = "{\n" +
                "\"queue\":\"getOTP\",\n" +
                "\"message\": \"" + userId + "\"\n" +
                "}";
        Response response = given().baseUri("https://member-domain.herokuapp.com")
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyRequest)
                .accept(ContentType.JSON).get("/member");
        response.getBody().prettyPrint();
        System.out.println(response.path("code").toString());
        return response;
    }
}
