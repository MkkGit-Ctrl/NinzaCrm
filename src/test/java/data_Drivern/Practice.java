package data_Drivern;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Practice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		// Physical representation of java file
		FileInputStream file = new FileInputStream("C:\\Users\\Mohit\\Desktop\\xcelfile.xlsx");

		// Openin	g of the file in read mode
		Workbook wb = WorkbookFactory.create(file);

		// Select the Sheet
		Sheet sheet = wb.getSheet("sheet1");

		// selecting the row
		Row row = sheet.getRow(1);

		// Select the cell
		Cell cell = row.getCell(1);

		String value = cell.getStringCellValue();

		System.out.println("Data : " + value);
		
		wb.close();
		
		System.out.println("Test Script data1");
		System.out.println("Test Script data2");

	}

}
