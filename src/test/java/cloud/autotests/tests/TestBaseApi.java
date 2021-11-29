package cloud.autotests.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseApi {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }
}