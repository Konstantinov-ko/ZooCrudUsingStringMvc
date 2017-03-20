package ru.konstantinov;

import ru.konstantinov.zoo.ZooService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

/**
 * Created by Asus on 16.03.2017.
 */
public class Main {
    public static final String BASE_FILE_DIR = "D:\\JAVA\\com\\ZooCrudUsingStringMvc\\src\\main\\base\\";
    public static final File BASE_FILE;
    public static final File BASE_DIR;

    static {
        BASE_FILE = new File(BASE_FILE_DIR + "base.txt");
        BASE_DIR = new File(BASE_FILE_DIR + "files");
    }

    public static int getBaseSize() {
        int size = 0;

        if (isBaseFile()) {
            try {
                FileReader reader = null;
                BufferedReader bufferedReader = null;
                try {
                    reader = new FileReader(BASE_FILE);
                    bufferedReader = new BufferedReader(reader);

                    while (bufferedReader.readLine() != null) size++;
                } finally {
                    if (reader != null) reader.close();
                    if (bufferedReader != null) bufferedReader.close();
                }
            } catch (IOException e) {
            }

        }
        return size;
    }

    private static boolean isBaseFile() {
        return BASE_FILE.exists();
    }

    public static String checkBase() {
        return (isBaseFile()) ? "OK!" : "FALSE";
    }
}
