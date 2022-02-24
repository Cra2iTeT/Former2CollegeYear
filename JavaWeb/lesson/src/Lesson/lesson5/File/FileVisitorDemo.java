package com.lesson5.File;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;


public class FileVisitorDemo extends SimpleFileVisitor<Path> {

	
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		System.out.println("Just visited "+dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		System.out.println("Aoout to visit "+dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		if(attrs.isRegularFile()){
			System.out.println("Regular File:");
		}
		System.out.println(file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		System.err.println(exc.getMessage());
		return FileVisitResult.CONTINUE;
	}

	public static void main(String[] args) {
		Path fileDirPath=Paths.get("D:\\test");
		FileVisitorDemo visitor=new FileVisitorDemo();
		try {
			Files.walkFileTree(fileDirPath, visitor);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
