package simpleTest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * Created by caoyang on 2017/6/29.
 */
public class UUIDTest {
    public static void main(String[] args) {
        String tempHostName = UUID.randomUUID().toString().substring(0, 6);
        try {
            tempHostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println(tempHostName);
    }
}
