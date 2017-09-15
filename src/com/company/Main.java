package com.company;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.zip.*;

import static jdk.nashorn.internal.objects.NativeString.substring;

public class Main {

    public static void main(String[] args) throws IOException {
        int a = 1;
        String filePath = args[a];
        boolean compressed = isCompressed(args[0]);

        while (a < args.length) {
            filePath = args[a];
            System.out.println("File name is: " + filePath);

            if (compressed == true) {
                System.out.println("Compressing...");
                try {
                    compress(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (compressed == false) {
                System.out.println("Decompressing...");
                try {
                    decompress(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            a++;
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
        System.out.println("Compressed file is named: " + filePath + ".GZ");

        File file = new File(filePath);
        file.delete();
    }

    private static void decompress(String filepath) throws IOException{
        FileInputStream in = new FileInputStream(filepath);
        GZIPInputStream GZin = new GZIPInputStream(in);

        String newfilepath = filepath.substring(0,filepath.length() -3);

        FileOutputStream out = new FileOutputStream(newfilepath);

        int ch = 0;
        while ((ch = GZin.read()) > 0){
            out.write(ch);
        }

        out.close();
        in.close();
        GZin.close();

        System.out.println("Decompressed file is named: " + newfilepath);

        File file = new File(newfilepath + ".GZ");
        file.delete();
    }
}
