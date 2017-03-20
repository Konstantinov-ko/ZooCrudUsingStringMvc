package ru.konstantinov.base;

import ru.konstantinov.Main;
import ru.konstantinov.zoo.Zoo;

import java.io.*;
import java.util.*;

/**
 * Created by Asus on 20.03.2017.
 */
public enum BaseAction {
    GET_ALL {
        public Map<Integer, Zoo> action() {
            Base base = new Base();
            base.getDataFromBase();

            return base.getZooList();
        }
    };

    private class Base {
        private Map<Integer, Zoo> zooList = new TreeMap<Integer, Zoo>();

        private Map<Integer, Zoo> getZooList() {
            return zooList;
        }

        private void getDataFromBase() {
            List<String[]> baseRowList = readLinesFromBase(Main.BASE_FILE);
            for (String[] row : baseRowList) {
                try {
                    addZoo(row);
                } catch (Exception e) {

                }
            }
        }

        private List<String[]> readLinesFromBase(File path) {
            List<String[]> baseRowList = new LinkedList<String[]>();
            FileReader reader = null;
            BufferedReader bufferedReader = null;

            try {
                try {
                    reader = new FileReader(path);
                    bufferedReader = new BufferedReader(reader);
                    String str;
                    while ((str = bufferedReader.readLine()) != null) baseRowList.add(str.split(" "));
                } finally {
                    if (reader != null) reader.close();
                    if (reader != null) bufferedReader.close();
                }
            } catch (IOException e) {
            }

            return baseRowList;
        }

        private void addZoo(String[] row) throws IOException, ClassNotFoundException {
            File file = new File(Main.BASE_DIR, row[1]);
            if (file.exists()) {
                FileInputStream fileInputStream = null;
                ObjectInputStream object = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    object = new ObjectInputStream(fileInputStream);
                    zooList.put(Integer.valueOf(row[0]), (Zoo) object.readObject());
                } finally {
                    if (fileInputStream != null) object.close();
                    if (fileInputStream != null) fileInputStream.close();
                }
            }
        }
    }

    public abstract Map<Integer, Zoo> action();
}
