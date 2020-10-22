package contact;



import com.testerhomer.hogwaz.contact.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;

import static org.hamcrest.core.IsEqual.equalTo;


public class DepartmentT {
    Department department;

    @BeforeEach
    public void setUp() throws Exception {
        department = new Department();

    }

    @Test
    public void listDepart() {
        department.listDepart("1").then().body("errmsg",equalTo("ok"));
    }

    @Test
    public void createDepart() {
      department.createDepart("xi1n1"+department.random,"1").then().body("errmsg",equalTo("created"));
//        department.createDepart();
    }

    @Test
    public void creatDepartByMap() {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("name","map_"+department.random);
//        map.put("");
        department.creatDepartByMap(map).then().body("errmsg",equalTo("created"));
    }

    //测试部门中带有中文字符
    @Test
    public void creatDepartByChinese(){
        department.createDepart("部门_"+department.random,"1").then().body("errmsg",equalTo("created"));
    }

    //数据驱动测试
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/data/createDepartment.csv")
//    public void createDepartbyDataSource(String name,String parentid, int errcode){
//        department.createDepart(name,parentid).then().body("errcode",equalTo(errcode));
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"驱动_1","bumen_"})
//    public void createDepartbyDataSource(String name){
//        String namenew = name+department.random;
//        department.createDepart(namenew,"1").then().body("errcode",equalTo(0));
//    }

}