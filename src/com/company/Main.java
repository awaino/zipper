package com.company;
import java.io.*;
import java.util.Arrays;

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

            byte[] bytes = new byte[1000];
            int f = 0;
            System.out.println("Total characters available: " + input.available());
            while ((f=input.read())!=-1) {
                int bytesread = input.read(bytes);
                System.out.println("Characters read = " + bytesread);
                System.out.println(Arrays.toString(bytes));
            }
            input.close();


    }

}
