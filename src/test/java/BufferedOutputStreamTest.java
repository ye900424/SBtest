/**
 * @author: C.A.O
 * @Description:
 * @Date: 2018/10/18
 */

import sun.net.www.http.ChunkedOutputStream;

import java.io.*;
import java.util.Scanner;

/**
 * @author liyangdan
 * @date 2018/10/18 下午3:44
 */

public class BufferedOutputStreamTest {
    /**
     * 对应英文字母“abcddefghijklmnopqrsttuvwxyz”
     */
    private static final byte[] ArrayLetters = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
    };

    public static void main(String[] args) {
        testBufferedOutputStream();
    }

    /**
     * BufferedOutputStream的API测试函数
     */
    private static void testBufferedOutputStream() {

        // 创建“文件输出流”对应的BufferedOutputStream
        // 它对应缓冲区的大小是16，即缓冲区的数据>=16时，会自动将缓冲区的内容写入到输出流。
        File file = new File("out.txt");
        BufferedOutputStream out = null;
        try {

//            out = new BufferedOutputStream(new FileOutputStream(file), 16);

            out = new BufferedOutputStream(new ChunkedOutputStream(new PrintStream(new FileOutputStream(file))), 16);

            // 将ArrayLetters数组的前10个字节写入到输出流中
            out.write(ArrayLetters, 0, 20);
            //out.flush();
            // 将“换行符\n”写入到输出流中
            out.write('\n');


            // TODO
//            out.flush();

            readUserInput();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {

            }
        }
    }

    /**
     * 读取用户输入
     */
    private static void readUserInput() {
        System.out.println("please input a text:");
        Scanner reader = new Scanner(System.in);
        // 等待一个输入
        String str = reader.next();
        System.out.printf("the input is : %s\n", str);
    }
}
