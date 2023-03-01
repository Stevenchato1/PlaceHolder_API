package placeHolderTesting;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class CRUD {
    final  String url = "https://jsonplaceholder.typicode.com";

    @Before
    public void setUp(){
        RestAssured.config = new RestAssuredConfig().encoderConfig(EncoderConfig.encoderConfig().defaultContentCharset("UTF-8"));
        RestAssured.baseURI=url;
    }

    @Test
    public void a_create(){
        Map<String, Object> placeHolder = new HashMap<>();

    }

}
