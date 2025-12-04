package data_Drivern;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Xl_file_Read {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		// Create the java representation of physical file
		FileInputStream file = new FileInputStream("C:\\Users\\Mohit\\Desktop\\xcelfile.xlsx");

		// Open File in read mode
		Workbook wb = WorkbookFactory.create(file);

		// open sheet
		Sheet sheet = wb.getSheet("Sheet1");

		int totalRow = sheet.getLastRowNum();

		for (int i = 0; i <= totalRow; i++) {

			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			Cell cell2 = row.getCell(1);
			System.out.println(cell.toString());
			System.out.println(cell2.toString());
		}

	}

}
