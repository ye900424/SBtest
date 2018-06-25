package JVM_test;

/**
 * Author     :Administrator
 * Time       :12:04
 * Project    :CMSM
 * Package    :JVM_test
 */
public class Eden2Old {
    private static int _1MB = 1024*1024;

    public static void main(String[] args) {
//        System.out.println(args[0]);
        byte[] array1,array2,array3,array4 ;
        array1 = new byte[2 * _1MB];
        array2 = new byte[2 * _1MB];
        array3 = new byte[2 * _1MB];
        array4 = new byte[4 * _1MB];
        System.out.println("over~");
    }
}
