package delivery.api;

import delivery.dto.OrderDto;
import delivery.dto.OrderDtoBuilderAndFactory;
import delivery.utils.RandomDataGenerator;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import delivery.utils.ApiClient;


public class OrderTest extends BaseSetupApi {

    @Test
    void getOrderInformationAndCheckResponse() {

        Response response = ApiClient.getOrders(getAuthenticatedRequestSpecification() );

        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK")
        );

    }
    // 14 homework. Test for new order creation
    @Test
    void createOrderAndCheckResponse() {
      // order creation (may use factory) -> replace new OrderDto???? correctly initialize new OrderDto
       Response response = ApiClient.createOrder(getAuthenticatedRequestSpecification(), new OrderDto() );
       // Response response = ApiClient.createOrder(getAuthenticatedRequestSpecification(), new OrderDtoBuilderAndFactory() );




        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK")
        );

    }
}
