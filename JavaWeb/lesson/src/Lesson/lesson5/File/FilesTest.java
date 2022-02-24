package com.lesson5.File;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

public class FilesTest {
    public static void main(String[] args) {
        // copy file
        Path source = Paths.get("C:/temp/line1.bmp");
        Path target = Paths.get("C:/temp/backup.bmp");
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Path source2 = Paths.get("C:/temp/backup.bmp");
        Path target2 = Paths.get("C:/123data/backup2.bmp");
        try {
            Files.move(source2, target2, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        
        // write and read to a text file
        Path textFile = Paths.get("C:/temp/speech.txt");
        Charset charset = Charset.forName("US-ASCII");
        String line1 = "Easy read and write";
        String line2 = "with java.nio.file.Files";
        List<String> lines = Arrays.asList(line1, line2);
        try {
            Files.write(textFile, lines, charset);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        List<String> linesRead = null;
        try {
            // read back
            linesRead = Files.readAllLines(textFile, charset);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        if (linesRead != null) {
            for (String line : linesRead) {
                System.out.println(line);
            }
            
        }
    }
    
}
