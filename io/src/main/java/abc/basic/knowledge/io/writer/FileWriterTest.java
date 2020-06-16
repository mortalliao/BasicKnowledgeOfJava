package abc.basic.knowledge.io.writer;

import java.io.*;

/**
 * @author Jim
 */
public class FileWriterTest {

    public static int CIRCLE = 100000;

    public static void main(String[] args) throws IOException {
        testFileWriter();

    }

    public static void testFileWriter() throws IOException {
        Writer writer = new FileWriter(new File("./file.txt"));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            writer.write(i);
        }
        writer.close();

        System.out.println("testFileWriter spend:" + (System.currentTimeMillis() - begin));
    }

    public static void testBufferWriter() throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(new File("file.txt")));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            writer.write(i);
        }
        writer.close();

        System.out.println("testFileWriterBuffer spend:" + (System.currentTimeMillis() - begin));
    }

}
