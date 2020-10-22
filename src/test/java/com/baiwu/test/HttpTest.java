package com.baiwu.test;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.CoreMatchers.equalTo;

public class HttpTest {
    @BeforeClass
    public static  void beforeClass(){
        baseURI = "https://www.baidu.com/";
    }


    @Test
    public void testBaidu(){
        given()
                .queryParam("wd","MP3")
                .when()
                .get("http://www.baidu.com/s")
                .then().log().all()
                .statusCode(200);
//                .body("html.head.title",equalTo("MP3_百度搜索"));
    }


    @Test
    public void testMp3(){
        useRelaxedHTTPSValidation();
        given()
                .queryParam("wd","mp3")
                .when()
                .get("http://www.baidu.com/s")
                .then()
                .log().all()
                .statusCode(200)
                .body("html.head.title",equalTo("mp3_百度搜索"));
    }

}
