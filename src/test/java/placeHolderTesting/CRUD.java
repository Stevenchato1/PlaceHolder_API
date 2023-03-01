package placeHolderTesting;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import org.junit.Before;

public class CRUD {
    final  String url = "https://jsonplaceholder.typicode.com";

    @Before
    public void setUp(){
        RestAssured.config = new RestAssuredConfig().encoderConfig(EncoderConfig.encoderConfig().defaultContentCharset("UTF-8"));
        RestAssured.baseURI=url;
    }

}
