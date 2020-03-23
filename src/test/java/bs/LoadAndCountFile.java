package bs;

/**
 * @author C.A.O
 * @date 2020/1/6
 */
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoadAndCountFile {

    public static void main(String[] args) {

        try {

            URL url = LoadAndCountFile.class.getClassLoader().getResource("file.txt");

            if (url != null) {

                RandomAccessFile file = new RandomAccessFile(url.getFile(), "rw");
                FileChannel channel = file.getChannel();

                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int readBytes = channel.read(byteBuffer);

                StringBuilder stringBuilder = new StringBuilder();

                System.out.println("begin read");

                while (readBytes != -1) {
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()) {
                        stringBuilder.append((char) byteBuffer.get());
                    }
                    byteBuffer.clear();
                    readBytes = channel.read(byteBuffer);
                }
                file.close();

                String[] strArray = stringBuilder.toString().split(System.getProperty("line.separator"));
                Map<String, Integer> stringIntegerMap = Arrays.stream(strArray).collect(Collectors.groupingBy((x -> x), Collectors.summingInt(t -> 1)));

                List<Map.Entry<String, Integer>> entryList = stringIntegerMap.entrySet().stream()
                        .sorted((a, b) -> b.getValue().compareTo(a.getValue())).collect(Collectors.toList());

                byteBuffer.clear();

                RandomAccessFile outPutFile = new RandomAccessFile("D:\\outPutFile.txt", "rw");
                FileChannel writeChannel = outPutFile.getChannel();

                entryList.forEach(entry -> {
                    byteBuffer.put(entry.getKey().getBytes());
                    byteBuffer.put(System.getProperty("line.separator").getBytes());
                    byteBuffer.put(String.valueOf(entry.getValue()).getBytes());
                    byteBuffer.put(System.getProperty("line.separator").getBytes());
                });

                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    writeChannel.write(byteBuffer);
                }

                writeChannel.close();
                System.out.println("write over");

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

