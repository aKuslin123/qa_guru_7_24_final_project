package cloud.autotests.tests.api;

import cloud.autotests.annotations.JiraIssue;
import cloud.autotests.annotations.JiraIssues;
import cloud.autotests.model.User;
import cloud.autotests.tests.TestBaseApi;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.is;

public class ReqresinTests extends TestBaseApi {

    @Test
    @JiraIssues({@JiraIssue("HOMEWORK-273")})
    void registerUserTest() {
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("pistol");
        given()
                .contentType(JSON)
                .body(user)
                .when()
                .post("/api/register")
                .then()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @JiraIssues({@JiraIssue("HOMEWORK-273")})
    void successLoginTest() {
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("cityslicka");
        given()
                .contentType(JSON)
                .body(user)
                .when()
                .post("/api/login")
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @JiraIssues({@JiraIssue("HOMEWORK-273")})
    void successCreateTest() {
        User user = new User();
        user.setName("morpheus");
        user.setJob("zion resident");
        given()
                .contentType(JSON)
                .body(user)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .body("name", is(user.getName()))
                .body("job", is(user.getJob()));
    }

    @Test
    @JiraIssues({@JiraIssue("HOMEWORK-273")})
    void unsuccess404UpdateTest() {
        User user = new User();
        user.setName("morpheus");
        user.setJob("zion resident");
        given()
                .contentType(JSON)
                .body(user)
                .when()
                .patch("/1api/users/2")
                .then()
                .statusCode(404);
    }

    @Test
    @JiraIssues({@JiraIssue("HOMEWORK-273")})
    void successDeleteTest() {
        given()
                .when()
                .delete("/api/users/2")
                .then()
                .statusCode(204);
    }
}