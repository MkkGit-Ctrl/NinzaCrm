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

public class Xl_File {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		// Create the java representation of physical file

		FileInputStream file = new FileInputStream("C:\\Users\\Mohit\\Desktop\\xcelfile.xlsx");

		// Open File in read mode
		Workbook wb = WorkbookFactory.create(file);

		// open sheet
		Sheet sheet = wb.getSheet("Sheet1");
		
		int last = sheet.getLastRowNum();

		Row row = sheet.getRow(1);

		Cell cell = row.createCell(2);

		cell.setCellValue("3ogfhio34hgog5p49");

		FileOutputStream fil = new FileOutputStream("C:\\\\Users\\\\Mohit\\\\Desktop\\\\xcelfile.xlsx");

		wb.write(fil);

		wb.close();

	}
}
