package delivery.api;

import delivery.dto.OrderDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import delivery.utils.ApiClient;


public class OrderTest extends BaseSetupApi {

    @Test
    void getOrderInformationAndCheckResponse() {

        Response response = ApiClient.getOrders(getAuthenticatedRequestSpecification());

        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK")
        );

    }

    // 14 homework. Test for new order creation
    @Test
    void createOrderAndCheckResponse() {

        Response response = ApiClient.createRandomOrder(getAuthenticatedRequestSpecification());


        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK"),
                () -> Assertions.assertNotNull(response.getBody().path("id"))
        );

    }

    // 15 Homework. Delete method
    @Test
    void deleteOrderById() {
        Response response = ApiClient.createRandomOrder(getAuthenticatedRequestSpecification());
        int orderId = response.getBody().path("id");

        Response responseOrderDeletion = ApiClient.deleteOrderById(getAuthenticatedRequestSpecification(), orderId);
    }
}

