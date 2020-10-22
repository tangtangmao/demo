package com.baiwu.test;

//import com.sun.org.apache.xpath.internal.operations.String;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class TestKeTangPai {
//    public static Response response = null;

    public  static Response response;
//    @BeforeClass
//    public static void  login(){
//
//        //信任https的任意证书
//        useRelaxedHTTPSValidation();
//        RestAssured.proxy("127.0.0.1",8888);
//        response =  given().log().all()
//                .header("User-Agent"," Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:81.0) Gecko/20100101 Firefox/81.0")
//                .header("Referer"," https://www.ketangpai.com/User/login.html")
//                .header("X-Requested-With","XMLHttpRequest")
//                .cookie("PHPSESSID","egis40lfv4p7ac3ifn74irlmv1")
//                .cookie(" ketangpai_home_slb","0f03ac6dd07e82c9681b0eaf692bee6b")
//                .formParam("email","1185375204@qq.com")
//                .formParam("password","15030805249youar")
//                .formParam("remember","0")
//                .when().post("https://www.ketangpai.com/UserApi/login")
//                .then().statusCode(200).log().all()
//       .extract().response();
//        System.out.print(response);
//////        return response;
//    }

    @Test
    public void testLogin(){
       response   = given().log().all()
            .header("User-Agent"," Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:81.0) Gecko/20100101 Firefox/81.0")
            .header("Referer"," https://www.ketangpai.com/User/login.html")
            .header("X-Requested-With","XMLHttpRequest")
            .cookie("PHPSESSID","egis40lfv4p7ac3ifn74irlmv1")
            .cookie(" ketangpai_home_slb","0f03ac6dd07e82c9681b0eaf692bee6b")
            .formParam("email","1185375204@qq.com")
            .formParam("password","15030805249youar")
            .formParam("remember","0")
            .when().post("https://www.ketangpai.com/UserApi/login")
            .then().statusCode(200).extract().response();
        System.out.println(response);
    }


//    @Test
//    public void userIo1(){
//        //信任https的任意证书
//        useRelaxedHTTPSValidation();
//        RestAssured.proxy("127.0.0.1",8888);
//      Map<String,String > cookies = response.getCookies();
////        String  cookie1 = response.getCookie("ketangpai_home_slb");
////        String cookie2 = response.getCookie("ketangpai_home_remember");
//
//        for(Map.Entry<String,String> entry:cookies.entrySet()) {
//          given().cookie(entry.getKey(),entry.getValue())
//                .cookie("SERVERID","553148816b04afb87eda8976b8b359b3|1603184294|1603184290")
//                .cookie("gr_user_id","a1482915-275b-48c8-8730-97bf9b4fbdb4")
//                .cookie("f6be9b42a39b4860a217be43fe0feb1a_gr_session_id_91adfcca-27d2-4cd0-8dd1-70bda03e751a","true")
//                .cookie("f6be9b42a39b4860a217be43fe0feb1a_gr_session_id","91adfcca-27d2-4cd0-8dd1-70bda03e751a")
//                .cookie("grwng_uid","cb627529-67aa-4e9b-b161-8050fcb92c70")
//                .when().get("https://www.ketangpai.com/User/setting.html ")
//                .then().log().all().statusCode(200).body("html.body.div[1].h1",equalTo("优优"));
//        }
//
//    }

    @Test
    public void userIo(){
        //信任https的任意证书
        useRelaxedHTTPSValidation();
        RestAssured.proxy("127.0.0.1",8888);
        String  cookie1 = response.getCookie("ketangpai_home_slb");
        String cookie2 = response.getCookie("ketangpai_home_remember");
        given()
                .cookie("ketangpai_home_slb",cookie1)
                .cookie("ketangpai_home_remember",cookie2)
                .cookie("PHPSESSID","egis40lfv4p7ac3ifn74irlmv1")
                .cookie("SERVERID","553148816b04afb87eda8976b8b359b3|1603184294|1603184290")
                .cookie("gr_user_id","a1482915-275b-48c8-8730-97bf9b4fbdb4")
                .cookie("f6be9b42a39b4860a217be43fe0feb1a_gr_session_id_91adfcca-27d2-4cd0-8dd1-70bda03e751a","true")
                .cookie("f6be9b42a39b4860a217be43fe0feb1a_gr_session_id","91adfcca-27d2-4cd0-8dd1-70bda03e751a")
                .cookie("grwng_uid","cb627529-67aa-4e9b-b161-8050fcb92c70")
                .when().get("https://www.ketangpai.com/User/setting.html ")
                .then().log().all().statusCode(200).body("html.body.div[1].h1",equalTo("优优"));
    }

    //处理参数比较复杂的情况，可以凡在map中，此时需要引入一个“jackson-dataformat-xml”的包
//
}
