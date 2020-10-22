//package com.baiwu.test;
//
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.Test;
//
//import static io.restassured.RestAssured.baseURI;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.Matchers.hasItems;
//
//public class TestCeshi {
//    @Test
//    public void testJson(){
//        given().when().get("http://127.0.0.1:8000/lotto.json")
//                //判断lottoId是否等于5
//                .then().log().all().
//                body("lotto.lottoId",equalTo(5))
//        //        winnerId的取值包括23和54
//                .body("lotto.winners.winnerId",hasItems(23,54))
//        .body("lotto.winners.findAll{it.winnerId}",hasItems())
//        ;
//    }
//
//    @Test
//    public void testXml(){
//        given().when().get("http://127.0.0.1:8000/test.xml")
//                .then().log().all()
//                //判断他的商品名称中是否有Chocolate
//                .body("shopping.category.item.name",hasItems("Chocolate"))
//                //判断第一个category中的第二个item的值是coffee
//                .body("shopping.category[0].item[1].name",equalTo("Coffee"))
//                //判断category中的属性为groceries的个数，这里的type是属性，所以前面要加@符号
//                .body("shopping.category.findAll { it.@type == 'groceries' }.size()",equalTo(1))
//                .body("shopping.category.item.findAll { item -> def price = item.price.toFloat(); price >= 10 && price <= 20 }.name",hasItems("Coffee"))
//                .body("shopping.category.item.findAll {it.price ==10}.name",equalTo("Chocolate"))
//                .body("shopping.category.item.findAll {it.price ==10}.price",equalTo("10"));
//
//
//    }
//
//
//
//}
