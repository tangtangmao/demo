package com.testerhomer.hogwaz.contact;


import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import hogwaz.utils.Wework;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Department {
    public String random =String.valueOf( System.currentTimeMillis());

    public Response listDepart(String id){
       Response response =  given().log().all()
               .param("access_token",Wework.getToken())
                .param("id",id)
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then().log().all().statusCode(200).extract().response();

       return response;

    }

    public Response createDepart(String name, String parentid){
        DocumentContext documentContext =  JsonPath.parse(this.getClass().getResourceAsStream("/data/creatDepart.json"));
        String body = documentContext.set("$.name",name).set("$.parentid",parentid).jsonString();
        return   given().log().all().contentType(ContentType.JSON)
                .queryParam("access_token",Wework.getToken())
               .body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all().statusCode(200).extract().response();
    }

    public Response creatDepartByMap(HashMap<String,Object> map){
        DocumentContext documentContext = JsonPath.parse(this.getClass().getResourceAsStream("/data/creatDepart.json"));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(),entry.getValue());
        });

        return given().log().all().contentType(ContentType.JSON)
                .queryParam("access_token",Wework.getToken())
                .body(documentContext.jsonString()).when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all().statusCode(200).extract().response();

    }
}
