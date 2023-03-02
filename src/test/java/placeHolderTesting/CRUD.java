package placeHolderTesting;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CRUD {
    final  String url = "https://jsonplaceholder.typicode.com";
    public static String value= "1";

    @Before
    public void setUp(){
        RestAssured.config = new RestAssuredConfig().encoderConfig(EncoderConfig.encoderConfig().defaultContentCharset("UTF-8"));
        RestAssured.baseURI=url;
    }

    @Test
    public void a_create(){
        Map<String, Object> placeHolder = new HashMap<>();
        placeHolder.put("title","Steven");
        placeHolder.put("body","Huasupoma");
        placeHolder.put("userId",1);

        given().log().all().contentType(ContentType.JSON).body(placeHolder)
                .when().post("/posts")
                .then().log().all().assertThat().statusCode(201).and().body("id",notNullValue()
                , "title",equalTo("Steven")
                ,"body",equalTo("Huasupoma"));
    }

    @Test
    public void b_update(){
        Map<String, Object> placeHolder = new HashMap<>();
        placeHolder.put("id",value);
        placeHolder.put("title","Modificado");
        placeHolder.put("body","Modificado");
        placeHolder.put("userId",1);
        given().log().all().contentType(ContentType.JSON).body(placeHolder).pathParam("id",value)
                .when().put("/posts/{id}")
                .then().log().all().assertThat().statusCode(200).and().body("id",notNullValue()
                        , "title",equalTo("Modificado")
                        ,"body",equalTo("Modificado"));
    }

    @Test
    public void c_getForId(){
        given().log().all().contentType(ContentType.JSON).pathParam("id",value)
                .when().get("/posts/{id}").then().log().all().assertThat().statusCode(200).and().body("id",equalTo(1));
    }

    @Test
    public void d_deleteForId(){
        given().log().all().contentType(ContentType.JSON).pathParam("id",value)
                .when().delete("/posts/{id}").then().log().all().assertThat().statusCode(200);
    }


}
