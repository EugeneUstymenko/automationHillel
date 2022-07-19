package ui.tests.restassureddemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.OrderDto;
import dto.PetDto;
import helpers.PreRequestsScriptsRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RestAssuredExampleTest {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    private RequestSpecification requestSpecification;

    @BeforeClass
    private void setUp(){
        requestSpecification = new RequestSpecBuilder()
                        .setBaseUri(BASE_URL)
                        .addHeader("Content-Type", "application/json")
                        .build();
    }

    @Test
    @SneakyThrows
    public void createPet(){
        PetDto requestPet = PetDto
                .builder()
                .status("available")
                .name("Barsik")
                .build();

        //Request creating pet
        String petId = RestAssured
                .given()
                .spec(requestSpecification)
                .body(new ObjectMapper().writeValueAsString(requestPet))// from java obj to json
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getString("id");

        //Request getting pet
        JsonPath jsonResponsePet = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/pet/" + petId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        //from json to java obj
        PetDto responsePet = new ObjectMapper().readValue(jsonResponsePet.prettify(), PetDto.class);

        assertThat(responsePet)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(requestPet);
    }

    @Test
    @SneakyThrows
    public void creteOrder(){
        OrderDto requestOrder = OrderDto
                .builder()
                .id(10101)
                .petId(1)
                .quantity(1000)
                .shipDate(PreRequestsScriptsRestAssured.setData())
                .status(PreRequestsScriptsRestAssured.StatusOrderPet.approved)
                .complete(true)
                .build();

        int orderId = RestAssured
                .given()
                .spec(requestSpecification)
                .body(new ObjectMapper().writeValueAsString(requestOrder))
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getInt("id");


        JsonPath jsonResponseOrder = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/store/order/" + orderId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        OrderDto responseOrder = new ObjectMapper().readValue(jsonResponseOrder.prettify(), OrderDto.class);

        assertThat(responseOrder)
                .isEqualTo(requestOrder);

    }

    @Test
    public void collectionTest(){
        List<String> actualCollection;
        actualCollection = List.of("one", "two", "three", "four");

        assertThat(actualCollection)
                .hasSize(4)
                .allMatch(element -> element.length() > 2)
                .anyMatch(element -> element.length() == 4)
                .noneMatch(String :: isEmpty); //Method reference
    }
}

