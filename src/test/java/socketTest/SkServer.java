package socketTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by caoyang on 2017/5/2.
 */
public class SkServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9898);
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String info =null;
            while(null != (info=bufferedReader.readLine())){
                System.out.println("Hello,我是服务器，客户端说："+info);
            }

            socket.shutdownInput();//关闭输入流
            //4、获取输出流，响应客户端的请求
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("Hello World！");
            pw.flush();


            //5、关闭资源
            pw.close();
            os.close();
            bufferedReader.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
