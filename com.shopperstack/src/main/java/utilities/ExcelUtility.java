package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String readDataFromExcel(String sheetname,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		// step 1-->get the object of excel file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/testdata/shopperstack.xlsx");
		// step 2-->open the excel in read mode
		Workbook workbook = WorkbookFactory.create(fis1);
		// step 3-->get sheet control
		Sheet sheet = workbook.getSheet(sheetname);
		// step 4-->get the row control
		Row row = sheet.getRow(rowNo);
		// step 5-->get the cell control
		Cell cell = row.getCell(cellNo);
		// step 6-->fetch the data
		String data = cell.getStringCellValue();
		
		return data;
	}

}
