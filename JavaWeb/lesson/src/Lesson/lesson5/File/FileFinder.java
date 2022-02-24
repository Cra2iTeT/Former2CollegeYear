package com.lesson5.File;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;


public class FileFinder extends SimpleFileVisitor<Path> {



	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		Path name=file.getFileName();
		System.out.println("Examining "+name);
		if(matcher.matches(name)){
			foundPaths.add(file);
		}
		return FileVisitResult.CONTINUE;
	}

	private PathMatcher matcher;
	
	public ArrayList<Path> foundPaths=new ArrayList<>();
	
	public FileFinder(String pattern){
	    matcher=FileSystems.getDefault().getPathMatcher("glob:"+pattern);	
	}
	
	public static void main(String[] args) {
		Path fileDir=Paths.get("D:\\test");
		FileFinder finder=new FileFinder("*.java");
		try {
			Files.walkFileTree(fileDir, finder);
			ArrayList<Path> foundFiles=finder.foundPaths;
			if(foundFiles.size()>0){
				for (Path path : foundFiles) {
				System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
				}
			}
			else {
				System.out.println("No files were found!");
			}
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}

}
