package utility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseClass.BaseClass;

public class ListnerImplementaion extends BaseClass implements ISuiteListener,ITestListener
{
   @Override
   public void onTestFailure(ITestResult result)
   {
	   String method=result.getMethod().getMethodName();
	   String time = new Date().toString().replace(" ","_").replace(":","_");
	   TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
	   File src = ts.getScreenshotAs(OutputType.FILE);
	   File dest=new File("failedTest "+method+time);
	   try
	   {
		   FileUtils.copyFile(src, dest);
	   }
	   catch(Exception e)
	   {
          e.printStackTrace();
	   }
	
   }
}
