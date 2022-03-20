package com.lesson5.File;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) {
    	FileSystem fileSystem=FileSystems.getDefault();
    	Path examplePath=fileSystem.getPath("c:/windows");
    	System.out.println(examplePath.toString());
        Path path = Paths.get("C:/temp/pathTest.txt");
        System.out.println("path name count:" + path.getNameCount());
        System.out.println(path.getName(0));
        System.out.println(path.getName(1));
        
        System.out.println("filename: " + path.getFileName());
        System.out.println("parent: " + path.getParent());
        Path parent = path.getParent();
        System.out.println("parent: " + parent.getParent().getParent());
        
        
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Path newDir = Paths.get("C:/temp/newDir");
        try {
            if (Files.notExists(path)) {
                Files.createDirectory(newDir);
                
            }
            System.out.println("isDirectory: " + Files.isDirectory(newDir));
            System.out.println("size  : " + Files.size(newDir));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("DONE");
        
    }
    
}
