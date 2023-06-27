package com.example.genealogv;

import com.example.genealogv.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
public class HelloController {
    //http://localhost:8080/index
    //@RequestMapping(value = "/index")//这里默认的请求方式为get请求,get请求是web上的请求，修改请求方式用method
    @RequestMapping(value = "/index",method= RequestMethod.POST)

  public String index(User user){
        System.out.println(user);//单独在控制台打印出来
        return"";

    }
    //http://localhost:8080/index2?name=wdl&age=18
    /*@RequestMapping(value = "index2",method=RequestMethod.GET)
    public String index2(String name,String age){

        return "我是"+name+" "+"今年"+age;

    }

    @GetMapping(value = "/text/**")
    public String test(){
        return"通配符请求";
    }

}*/
 /*@Select("select * from User where Id =#{Id}")
 User selectById(int Id);

 @Select("select * from User")//
 @Results({
         @Result(column = "Id", property = "Id"),
         @Result(column = "Name", property = "Name"),
         @Result(column = "Password", property = "Password"),
         @Result(column = "Id", property = "families", javaType = List.class,
                 many = @Many(select = "com.example.genealogv.mapper.FamilyMapper.selectByld")
         ),
 }
 )
  List<User> selectAllFamiliesAndUser();

 单表 @Select("select * from User")//寻找你配置的数据库中的数据
    public List<User> find();

    @Insert("insert into User values(#{id},#{name},#{password})")
    public int insert(User user);//int表示插入了几个值
    @Delete("delete from User where id=#{id}")
    public int deleteUserById(int id);
    @Update("update User set name=#{name},password=#{password} where id=#{id}")
    public int updateUserById(User user);
    @Select("select * from User where id=#{id}")//根据ID查找
    public User findByID(int id);*/
