package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.zip.*;

public class Main {

    public static byte[] bytes;


    public static void main(String[] args) throws IOException {

        StringBuilder textToCompress = new StringBuilder();
        boolean compressed = isCompressed(args[0]);
        String filePath = args[1];
        System.out.println("File path is: " + filePath);
        System.out.println("Compression status is: " + compressed);

        if(compressed == true) {

            try {
                getFileContent(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Data array size: " + bytes.length);
            compress(filePath);
        }
        if(compressed == false){
            System.out.println("Decompressing " + filePath);
            decompress(filePath);
        }
    }
    private static boolean isCompressed(String compressing){
        if (compressing.equals("compress"))
            return true;

        return false;
    }

    private static String compress(String filePath) throws IOException {

        FileOutputStream out= new FileOutputStream(filePath+".GZ");
        GZIPOutputStream GZout = new GZIPOutputStream(out);
        int a = bytes.length;
        GZout.write(bytes,0,a);


        GZout.close();
    return "compress working.";
    }

    private static String decompress(String filepath) throws IOException {
        FileInputStream in = new FileInputStream(filepath);
        GZIPInputStream GZin = new GZIPInputStream(in);
        System.out.println("Filepath is: " + filepath);
        int a = 0;
        int ch = 0;
        bytes = new byte[1024];
        System.out.println("bytes size is: " + bytes.length);

        for (a = 0; a < bytes.length; a++){
            ch = (char) GZin.read();
            bytes[a] = (byte) ch;
            System.out.println("Decompressed char is: " + ((char)bytes[a]));
            a++;
            }
        GZin.close();
        StringBuilder newString = new StringBuilder();
        for (a = 0; a < 36; a++){
            newString.append((char)bytes[a]);
        }
        System.out.println("Uncompressed file contains: " + newString);
        return "Decompress working.";
    }

    private static void getFileContent (String filePath) throws IOException {
        FileInputStream input= new FileInputStream(filePath);
        int f = 0;
        char ch = 0;
        System.out.println("Total characters available: " + input.available());
        bytes = new byte[input.available()];
        System.out.println("Size of array is " + (bytes.length));
        for (f = 0; f < bytes.length; f++){
            ch = (char) input.read();
            //System.out.println("Character read: " + f);
            //System.out.println("Array position is: " + f);
            bytes[f] = (byte) ch;
            //System.out.println("Text to compress is: " + bytes[f]);
            //if (f < input.available()) {
            //    System.out.println("Next array position to load is: " + f);
            //}
        }
        System.out.println("\nTotal characters available: " + input.available());
        System.out.println("Size of array is " + (bytes.length));
        System.out.println("Array contains: " + Arrays.toString(bytes));

        input.close();
    }

}
