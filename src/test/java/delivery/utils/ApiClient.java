package delivery.utils;

import com.google.gson.Gson;
import delivery.api.BaseSetupApi;
import delivery.dto.LoginDto;
import delivery.dto.OrderDto;
import delivery.dto.OrderDtoBuilderAndFactory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiClient extends BaseSetupApi {
    public static Response getOrders(RequestSpecification spec){

        return given()
                .spec(spec)
                .log()
                .all()
                .get( "orders")
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public static String authorizeAndGetToken(String username, String password){
        LoginDto loginDto = new LoginDto(username, password);

        String token = given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body( new Gson().toJson(loginDto  ) )
                .post("login/student" )
                .then()
                .log()
                .all()
                .extract()
                .response()
                .asString();
        return token;
    }
    // HOMEWORK. Create an order
    public static Response createOrder(RequestSpecification spec, OrderDto orderDto){

        return given()
                .spec(spec)
                .log()
                .all()
                .body("{\"status\": \"OPEN\", \"courierId\": 0, \"customerName\": \"Olga\", \"customerPhone\": \"111111\", \"comment\": \"new order\", \"id\": 1}")
                .post( "orders")
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

}