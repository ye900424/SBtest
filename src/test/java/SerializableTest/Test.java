package SerializableTest;


import lombok.Data;
import model.Person;

import java.io.*;

/**
 * Created by caoyang on 2017/7/31.
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person subject = new Subject(1l,"cy");
        subject.setId(9l);

        File file = new File("/Users/caoyang/Desktop/test.text");

        //subject对象序列化过程
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(subject);
        oos.flush();
        oos.close();
        fos.close();


        //subject对象反序列化过程
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person st1 = (Person) ois.readObject();
        System.out.println("Subject = " + st1.toString());

        ois.close();
        fis.close();


    }

    public static native String nativeTest();
}

@Data
class Subject extends Person{

//    private static final long serialVersionUID = -6838680554727006134L;

    private Long id ;
    private Long ide ;

    private String name;

    public Subject(Long id ,String name ){
        super(id,name);
        this.id = id;
        this.name = name;
    }

}
