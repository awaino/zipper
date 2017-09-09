package com.company;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {



    public static void main(String[] args) {
        //System.out.println("Hello World");

        boolean compressed = isCompressed(args[0]);
        String filePath = args[1];
        System.out.println("File path is: " + filePath);
        System.out.println("Compression status is: " + compressed);

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

    private static void getFileContent (String filePath) {
        try {

            InputStream input = new FileInputStream(filePath);
        }catch (Exception E){
            System.out.println("File not found");
        }
    }

}
