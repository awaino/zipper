package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.zip.*;

public class Main {


    public static void main(String[] args) throws IOException {
        StringBuilder textToCompress = new StringBuilder();

        boolean compressed = isCompressed(args[0]);
        String filePath = args[1];
        System.out.println("File path is: " + filePath);
        System.out.println("Compression status is: " + compressed);
        try {
            getFileContent(filePath, textToCompress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        compress(textToCompress);

    }
    private static boolean isCompressed(String compressing){
        if (compressing.equals("compress"))
            return true;

        return false;
    }

    private static String compress(StringBuilder textToCompress){


        System.out.println("Text to compress is: " + textToCompress);
        return "Compress working";
    }


    private static String decompress(String textToDecompress){
        return "Decompress working.";
    }

    private static void getFileContent (String filePath, StringBuilder textToCompress) throws IOException {
        FileInputStream input= new FileInputStream(filePath);
        int f = 0;

        System.out.println("Total characters available: " + input.available());
            while ((f=input.read())> 0) {
                //System.out.println("Character read: Byte = " + f + " Character = " + ((char)f));
                textToCompress.append((char)f);
                //System.out.println("Text to compress is: " + textToCompress);
            }
            input.close();
    }

}
