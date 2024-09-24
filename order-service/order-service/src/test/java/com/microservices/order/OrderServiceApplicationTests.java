package com.microservices.order;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.shaded.org.hamcrest.Matchers;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mySQLContainer.start();
	}

	@Test
	void shouldSubmitOrder() {
		String submitOrderJSON = """
				      {
				           "sku_Code": "iphone 15",
				           "price": 80000,
				           "quantity": 1
				      }
				      """;
		var responseBodyString = RestAssured.given()
				.contentType("application/json")
				.body(submitOrderJSON)
				.when()
				.post("/order/create")
				.then()
				.log().all()
				.statusCode(201)
				.extract()
				.body().asString();

		// Log the response for debugging
		System.out.println("Response Body: " + responseBodyString);

		// Use assertTrue to check if response contains the string
		assertTrue(responseBodyString.contains("Order Placed Successfully"));

	}

}
