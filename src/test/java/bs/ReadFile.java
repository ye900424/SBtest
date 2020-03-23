package bs;


import java.io.*;

/**
 * @author C.A.O
 * @date 2020/1/9
 */
public class ReadFile {

    public static void main(String[] args) throws IOException {

//        URL url = ReadFile.class.getClassLoader().getResource("/Users/caoyang/IdeaProjects/SBTest/src/test/java/bishi/file.txt");
        File file = new File("/Users/caoyang/IdeaProjects/SBTest/src/test/java/bishi/file.txt");
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        File file1 = new File("/Users/caoyang/IdeaProjects/SBTest/src/test/java/bishi/file1.txt");
        if(!file1.exists()){
            file1.createNewFile();
        }

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file1));

        byte[] b = new byte[1];

        while (inputStream.read(b) > 0) {
//            System.out.println(1);
//            String tt = new String(b);
//            System.out.println(tt);
            outputStream.write(b);
            outputStream.flush();
        }






    }
}
