package data_percistence;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class FileManager {

    public static void write(String msg, File file) {

        try {
            FileWriter arquivo = new FileWriter(file);
            arquivo.write(msg);
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] breakLine(String line) {

        return line.split(";");


    }

    public static ArrayList<String> read(FileReader file){

        ArrayList<String> lines = new ArrayList<>();

        try {

            BufferedReader leitura = new BufferedReader(file);

            while (leitura.ready()) {

                Collections.addAll(lines, breakLine(leitura.readLine()));
            }

            return lines;

        } catch (IOException e) {

            e.printStackTrace();

        }

        return null;

    }
}
