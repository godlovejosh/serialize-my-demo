package com.google.code.gson.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import serialize.entity.model.TradeDO;

import java.util.List;

/**
 * @author wuxing
 */
public class Demo01 {

    @Test
    public void test01() {
        TradeDO tradeDO = new TradeDO();
        tradeDO.setId(10000L);
        Gson gson = new Gson();
        String json = gson.toJson(tradeDO);
        System.out.println(json);
        TradeDO tradeDO1 = gson.fromJson(json, TradeDO.class);
        System.out.println(tradeDO1.getId());
    }

    @Test
    public void test02() {
        Gson gson = new Gson();
        // 基本数据类型的解析
        int i = gson.fromJson("100", int.class);              //100
        double d = gson.fromJson("\"99.99\"", double.class);  //99.99
        boolean b = gson.fromJson("true", boolean.class);     // true
        String str = gson.fromJson("String", String.class);   // String

        System.out.println(i);
        System.out.println(d);
        System.out.println(b);
        System.out.println(str);

        // 基本数据类型的生成
        String jsonNumber = gson.toJson(100);       // 100
        String jsonBoolean = gson.toJson(false);    // false
        String jsonString = gson.toJson("String"); //"String"

        System.out.println(jsonNumber);
        System.out.println(jsonBoolean);
        System.out.println(jsonString);
    }

    // 内部类 无法序列化，只能序列化 外部类
    @Test
    public void test03() {
        class User {
            public String name;
            public int age;
            public String emailAddress;

            public User(String name, int age, String emailAddress) {
                this.name = name;
                this.age = age;
                this.emailAddress = emailAddress;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getEmailAddress() {
                return emailAddress;
            }

            public void setEmailAddress(String emailAddress) {
                this.emailAddress = emailAddress;
            }
        }
        Gson gson = new Gson();
        User user = new User("怪盗kidou",24, "address");
        Student stu = new Student("怪盗kidou",24, "address");
        String jsonObject1 = gson.toJson(user);
        String jsonObject2 = gson.toJson(stu);
        System.out.println(jsonObject1);
        System.out.println(jsonObject2);

        String jsonString = "{\"name\":\"怪盗kidou\",\"age\":24}";
        Student stu1 = gson.fromJson(jsonString, Student.class);
        System.out.println(stu1);
    }

    // 序列化空对象
    @Test
    public void test04() {
        Anno anno = new Anno();
        Gson gson = new Gson();
        System.out.println(gson.toJson(anno));
    }

    @Test
    public void test05() {
        Anno anno = new Anno();
        anno.setId(1000L);
        anno.setOrderNo("O1000");
        anno.setWaybillNo("W1000");
        Gson gson = new Gson();
        String a = gson.toJson(anno);
        System.out.println(a);
        String b1 = "{\"id\":1000,\"order_no\":\"O1000\",\"waybill_no\":\"W1000\"}";   // waybill_no
        String b2 = "{\"id\":1000,\"order_no\":\"O1000\",\"way_bill_no\":\"W1000\"}";  // way_bill_no
        String b3 = "{\"id\":1000,\"order_no\":\"O1000\",\"waybillNo\":\"W1000\"}";  // waybillNo
        String b4 = "{\"id\":1000,\"order_no\":\"O1000\",\"way_billNo\":\"W1000\"}";  // way_billNo
        Anno c1 = gson.fromJson(b1, Anno.class);
        Anno c2 = gson.fromJson(b2, Anno.class);
        Anno c3 = gson.fromJson(b3, Anno.class);
        Anno c4 = gson.fromJson(b4, Anno.class);
        System.out.println(c1.getWaybillNo());
        System.out.println(c2.getWaybillNo());
        System.out.println(c3.getWaybillNo());
        System.out.println(c4.getWaybillNo());
    }

    @Test
    public void test06() {
        Gson gson = new Gson();
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    /**
     * 但对于List将上面的代码中的 String[].class 直接改为 List<String>.class 是行不通的。
     * 对于Java来说List<String> 和List<User> 这俩个的字节码文件只一个那就是List.class，这是Java泛型使用时要注意的问题 泛型擦除。
     * 注：TypeToken的构造方法是protected修饰的,所以上面才会写成new TypeToken<List<String>>() {}.getType() 而不是  new TypeToken<List<String>>().getType()
     */
    @Test
    public void test07() {
        Gson gson = new Gson();
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
