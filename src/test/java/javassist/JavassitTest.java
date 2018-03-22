package javassist;

import model.Person;

/**
 * Created by C.A.O on 2018/3/7.
 */
public class JavassitTest {
    public static void main(String[] args) throws NotFoundException, CannotCompileException {
        replaceMethodBody("model.Person", "print", "System.out.println(\"this method is changed dynamically!\");");
        Person person = new Person();
        person.print();
    }

    public static void replaceMethodBody(String clazzName, String methodName, String newMethodBody) {
        try {
            CtClass clazz = ClassPool.getDefault().get(clazzName);
            CtMethod method = clazz.getDeclaredMethod(methodName);
            method.setBody(newMethodBody);
            clazz.toClass();
        } catch (NotFoundException | CannotCompileException e) {
            throw new RuntimeException(e);
        }
    }
}
