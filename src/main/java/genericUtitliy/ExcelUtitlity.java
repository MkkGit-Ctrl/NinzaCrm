package genericUtitliy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtitlity {
	String excelFile;

	public ExcelUtitlity(String excelFile) {

		this.excelFile = excelFile;
	}

	public String getDatafromExcelFile(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(excelFile);
		Workbook wb = WorkbookFactory.create(file);
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();

	}

}
