/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class File {

    public static void fileWriter(String line) {
        try {
            FileWriter fw = new FileWriter("vehicles.txt", true);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write(line);
            bf.newLine();

            bf.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<String> fileReader() {
        List<String> listLine = new ArrayList<>();
        try {
            FileReader fr = new FileReader("vehicles.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                listLine.add(line);
            }

            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listLine;
    }

}
