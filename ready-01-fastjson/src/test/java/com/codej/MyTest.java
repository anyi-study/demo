package com.codej;


import com.alibaba.fastjson.JSONObject;
import com.codej.Model.Student;
import org.junit.Test;

public class MyTest {

    @Test
    public void toJson(){
        Student student = new Student();
        student.setAge(27);
        student.setId(1002);
        student.setName("rose");
        System.out.println(student.toString());
        //使用fastjson将对象转换成string
        String json = JSONObject.toJSONString(student);
        System.out.println("json格式的student："+json);
        //json转对象
        String jsonStudent = "{\"age\":28,\"id\":1005,\"name\":\"laoluo\"}";
        Student rose = JSONObject.parseObject(jsonStudent, Student.class);
        System.out.println(rose);
    }
}
