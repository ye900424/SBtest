package thread.ExecutorTest;

/**
 * Author     :Administrator
 * Time       :16:23
 * Project    :CMSM
 * Package    :org.apache.http.examples.entity.mime
 */
public class MyBean {
    String name;
    String age;
    String tel;
    String address;
    MyBean1 myBean1;

    public MyBean(){

    }

    public MyBean(String a,String b,String c,String d,MyBean1 myBean1){
        name =a;
        age = b;
        tel = c;
        address = d;
        this.myBean1 = myBean1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MyBean1 getMyBean1() {
        return myBean1;
    }

    public void setMyBean1(MyBean1 myBean1) {
        this.myBean1 = myBean1;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", myBean1=" + myBean1.toString() +
                '}';
    }
}
