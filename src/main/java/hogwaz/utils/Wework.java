package hogwaz.utils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Wework {
    public static String token;

    public static  String  getWeworkToken(String corpsecret){

           return  given().log().all()
                    .queryParam("corpid",WeworkConfig.getInstance().corpid)
                    .queryParam("corpsecret",corpsecret)
                    .when().get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
            .then().log().all().statusCode(200).body("errmsg",equalTo("ok"))
            .extract().path("access_token");

    }

    public static  String getToken(){
        if(token ==null) {
        token = getWeworkToken(WeworkConfig.getInstance().contactsecret);

        }
        return token;
    }

//    public static String getContactToken(){
//        if(token==null){
//           token = getWeworkToken(WeworkConfig.getInstance().contactsecret);
//        }
//        return token;
//    }


//    public static void main(String args[]){
//        Wework wework = new Wework();
//       System.out.println( wework.getToken());
//    }
}
