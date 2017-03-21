package ru.konstantinov.base;

import ru.konstantinov.Main;
import ru.konstantinov.zoo.Zoo;

import java.io.*;
import java.util.*;

/**
 * Created by Asus on 21.03.2017.
 */
public class BaseAction {

    public Map<Integer, Zoo> getAll() {
        Base base = new Base();
        base.getDataFromBase();

        return base.getZooList();
    }

    public boolean remove(int zoo_id) {
        Base base = new Base();
        return base.removZoo(zoo_id);
    }

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

        private boolean removZoo(int zoo_id) {
            boolean result = false;
            List<String[]> baseRowList = readLinesFromBase(Main.BASE_FILE);
            Iterator<String[]> baseRowIterator = baseRowList.iterator();
            while (baseRowIterator.hasNext()) {
                String[] baseRow = baseRowIterator.next();
                if (Integer.parseInt(baseRow[0]) == zoo_id) {
                    result = removeRow(baseRow[1]);
                    baseRowIterator.remove();
                    break;
                }
            }
            if (result) rewriteBase(Main.BASE_FILE, baseRowList);
            return result;
        }

        private boolean removeRow(String fileName) {
            File file = new File(Main.BASE_DIR, fileName);
            return file.delete();
        }

        private void rewriteBase(File base, List<String[]> baseRowList) {
            PrintWriter writer = null;
            try {
                try {
                    writer = new PrintWriter(base);
                    for (String[] baseRow : baseRowList) writer.println(baseRow[0] + " " + baseRow[1]);
                } finally {
                    if (writer != null) {
                        writer.flush();
                        writer.close();
                    }
                }
            } catch (IOException e) {
            }
        }
    }
}
