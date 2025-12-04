package data_Drivern;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.devtools.v138.network.model.TrustTokenOperationType;

public class Reading_Multiple_Data {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Create the java representation of physical file
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Mohit\\Desktop\\AdvanceSelenium\\AdvanceSelenium\\src\\test\\resources\\MultipleData.xlsx");

		// Open File in read mode
		Workbook wb = WorkbookFactory.create(file);

		// open sheet
		Sheet sheet = wb.getSheet("Sheet1");

		int totalRow = sheet.getLastRowNum();

		System.out.println(totalRow);

		for (int index = 1; index <=totalRow; index++) {

			String productcat = sheet.getRow(index).getCell(0).getStringCellValue();
			String productname = sheet.getRow(index).getCell(1).getStringCellValue();
			System.out.println(productcat);
			System.out.println(productname);

		}

		wb.close();

	}

}
