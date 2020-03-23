package bs;

import java.io.*;
import java.util.Scanner;

/**
 * @author C.A.O
 * @date 2020/3/4
 */
public class FileRead {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("/Users/caoyang/Desktop/num.txt"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));


        String str = null;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }


        Scanner scan = new Scanner(new File("/Users/caoyang/Desktop/num.txt"));
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
    }
}
