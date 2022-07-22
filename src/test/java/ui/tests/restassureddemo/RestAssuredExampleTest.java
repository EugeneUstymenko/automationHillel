package ui.tests.restassureddemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.petdto.Category;
import dto.OrderDto;
import dto.petdto.PetDto;
import helpers.PreRequestsScriptsRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RestAssuredExampleTest {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    private RequestSpecification requestSpecification;
    private Long petId;

    @BeforeClass
    private void setUp(){
        requestSpecification = new RequestSpecBuilder()
                        .setBaseUri(BASE_URL)
                        .addHeader("Content-Type", "application/json")
                        .build();
    }

    @BeforeMethod
    public void setPetId(){
        petId = 14123351002L;
    }

    @Test
    @SneakyThrows
    public void createPet(){
        PetDto requestPet = PetDto
                .builder()
                .status("available")
                .name("Barsik")
                .id(petId)
                .category(Category
                        .builder()
                        .name("Pushistiki")
                        .build())
                .build();

        //Request creating pet
        RestAssured
                .given()
                .spec(requestSpecification)
                .body(new ObjectMapper().writeValueAsString(requestPet))// from java obj to json
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

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

        System.out.println("Pet id: " + petId);
    }

    @Test
    @SneakyThrows
    public void creteOrder(){
        OrderDto requestOrder = OrderDto
                .builder()
                .id(7020L)
                .petId(petId)
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

        System.out.println("Order id: " + orderId);
    }

    @Test
    @SneakyThrows
    public void lestResponseTest(){
        String responseJson = RestAssured
                .given()
                .spec(requestSpecification)
                .params("status", "available")
                .when()
                .get("/pet/findByStatus")
                .then()
                .extract()
                .body()
                .asString();

        PetDto[] listPetDto = new ObjectMapper().readValue(responseJson, PetDto[].class);

        assertThat(listPetDto)
                .allMatch(element -> element.getStatus().equals("available"));
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


