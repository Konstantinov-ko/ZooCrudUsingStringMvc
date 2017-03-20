package ru.konstantinov;

import ru.konstantinov.zoo.ZooService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
        try {
            FileInputStream base = new FileInputStream(BASE_FILE);
            size = base.available();
        } finally {
            return size;
        }
    }

    public static String checkBase() {
        return (BASE_FILE.exists()) ? "OK!" : "FALSE";
    }
}
