package com.codej;


import com.alibaba.fastjson.JSONObject;
import com.codej.Model.Book;
import com.codej.Model.Student;
import org.junit.Test;

public class MyTest2 {

    @Test
    public void toJson(){
        Student student = new Student();
        student.setAge(27);
        student.setId(1002);
        student.setName("rose");
//      new book
        Book book = new Book();
        book.setId(1);
        book.setName("老罗Java");
        book.setPrice(123.0);
        student.setBook(book);
        String jsonString = JSONObject.toJSONString(student);
        System.out.println(jsonString);

//        {"age":27,"book":{"id":1,"name":"老罗Java","price":123.0},"id":1002,"name":"rose"}
//        转对象
        String json = "{\"age\":27,\"book\":{\"id\":1,\"name\":\"老罗Java\",\"price\":123.0},\"id\":1002,\"name\":\"rose\"}";
        Student jsonToObject = JSONObject.parseObject(json, Student.class);
        System.out.println(jsonToObject.toString());
        Book book1 = jsonToObject.getBook();
        String name = book1.getName();
        System.out.println(name);

//        JSONObject取
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject book2 = jsonObject.getJSONObject("book");
        String price = book2.getString("price");
        System.out.println(price);
    }
}
