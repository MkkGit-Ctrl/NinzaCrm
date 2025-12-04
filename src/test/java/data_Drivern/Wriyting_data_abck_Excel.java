package data_Drivern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Wriyting_data_abck_Excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		// Create java phy file
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Mohit\\Desktop\\AdvanceSelenium\\AdvanceSelenium\\src\\test\\resources\\UpdatedExcel.xlsx");

		// Open the file in read mode
		Workbook wb = WorkbookFactory.create(file);

		// Capture the sheet
		Sheet sheet = wb.getSheet("Sheet1");

		// Create the row
		Row row = sheet.createRow(0);

		// Create the cell
		Cell cell = row.createCell(0);

		// Creating the data
		cell.setCellValue("Selenium");

		// Opening file in write mode
		FileOutputStream fileOutput = new FileOutputStream(
				"C:\\Users\\Mohit\\Desktop\\AdvanceSelenium\\AdvanceSelenium\\src\\test\\resources\\UpdatedExcel.xlsx");

		// Store data
		wb.write(fileOutput);

		// save the file
		wb.close();

	}

}
