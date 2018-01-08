package thread.ExecutorTest;

/**
 * Author     :Administrator
 * Time       :16:31
 * Project    :CMSM
 * Package    :org.apache.http.examples.entity.mime
 */
public class MyBean1 {
    String A;
    String B;


    public MyBean1(String a,String b){
        A = a;
        B = b;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    @Override
    public String toString() {
        return "MyBean1{" +
                "A='" + A + '\'' +
                ", B='" + B + '\'' +
                '}';
    }
}
