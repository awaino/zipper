package com.company;
import java.io.*;

public class Main {



    public static void main(String[] args) throws IOException {
        //System.out.println("Hello World");

        boolean compressed = isCompressed(args[0]);
        String filePath = args[1];
        System.out.println("File path is: " + filePath);
        System.out.println("Compression status is: " + compressed);
        try {
            getFileContent(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static boolean isCompressed(String compressing){
        if (compressing.equals("compress"))
            return true;

        return false;
    }

    private static String compress(String textToCompress){
        return "Compress working";
    }

    private static String decompress(String textToDecompress){
        return "Decompress working.";
    }

    private static void getFileContent (String filePath) throws IOException {
        FileInputStream input= new FileInputStream(filePath);

            int f = 0;
            while ((f=input.read())!=-1) {
                System.out.println((char) f);
            }
            input.close();


    }

}
