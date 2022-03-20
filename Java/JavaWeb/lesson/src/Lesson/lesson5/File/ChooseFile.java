package com.lesson5.File;

import javax.swing.*;
import java.io.*;

public class ChooseFile
{
	public static void main(String[] args)
	{
	
	  JFileChooser fileChooser = new JFileChooser();

      fileChooser.setFileSelectionMode(
         JFileChooser.FILES_ONLY );
         //?????????????
      int result = fileChooser.showOpenDialog( null );
 
      // user clicked Cancel button on dialog
      if ( result == JFileChooser.CANCEL_OPTION )
         return;

      File fileName = fileChooser.getSelectedFile();
      
      System.out.println("????????" + fileName.getName());
	}
}