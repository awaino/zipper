package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.zip.*;

import static jdk.nashorn.internal.objects.NativeString.substring;

public class Main {

    public static void main(String[] args) throws IOException {

        boolean compressed = isCompressed(args[0]);
        String filePath = args[1];
        System.out.println("File path is: " + filePath);
        System.out.println("Compression status is: " + compressed);

        if(compressed == true) {
            try {
                compress(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(compressed == false){
            try{
                decompress(filePath);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static boolean isCompressed(String compressing){
        if (compressing.equals("compress"))
            return true;

        return false;
    }

    private static void compress(String filePath) throws IOException {

        FileInputStream in = new FileInputStream(filePath);

        FileOutputStream out = new FileOutputStream(filePath + ".gz");
        GZIPOutputStream GZout = new GZIPOutputStream(out);

        int a = 0;
        while ((a = in.read())  > 0){
           GZout.write(a);
        }

        GZout.close();
        out.close();
        in.close();
    }

    private static void decompress(String filepath) throws IOException{
        FileInputStream in = new FileInputStream(filepath);
        GZIPInputStream GZin = new GZIPInputStream(in);

        String newfilepath = filepath.substring(0,filepath.length() -3);

        FileOutputStream out = new FileOutputStream(newfilepath + ".txt");

        int ch = 0;
        while ((ch = GZin.read()) > 0){
            out.write(ch);
        }

        out.close();
        in.close();
        GZin.close();

        System.out.println("Filepath is: " + newfilepath + ".txt");
    }
}
