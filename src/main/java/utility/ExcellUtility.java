package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtility {
	public String readDataFromExcell(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/Appium_TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
		String result = format.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		wb.close();
		return result;
	}

}
