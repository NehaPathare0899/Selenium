package com.ShoppersStack_GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class Listerners_Utility  {
	private static final TakesScreenshot driver = null;
	java_Utility javaUtility = new java_Utility();
 //@override
 
 public void OnTestFailure() throws IOException
 {
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File temp = ts.getScreenshotAs(OutputType.FILE);
	 File dest = new File("");
	 FileHandler.copy(temp, dest);
	 
 }
}
