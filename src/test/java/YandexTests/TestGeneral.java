package YandexTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;

import static expectedStatusCodes.StatusCodes.SCClearTrash202;
import static yandexDiskMethods.requestsData.RequestsData.*;
import static yandexDiskMethods.requestsData.RequestsData.TRASH;

public class TestGeneral {
    @BeforeMethod
    public void clearTrash() {
        RestAssured.given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, TOKEN)
                .when()
                .delete(BASE_URL + TRASH)
                .then()
                .statusCode(SCClearTrash202);
    }
}
