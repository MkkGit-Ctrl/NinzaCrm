package data_Drivern;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Practice2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		FileInputStream file = new FileInputStream("C:\\Users\\Mohit\\Desktop\\Practise.xlsx");

		// Opening in read mode
		Workbook Wb = WorkbookFactory.create(file);

		Wb.getSheet("Sheet1").getRow(1).createCell(1).setCellValue("NewCamp1");

		FileOutputStream fis = new FileOutputStream("C:\\Users\\Mohit\\Desktop\\Practise.xlsx");

		Wb.write(fis);

		Wb.close();

	}

	@Test
	public void add() {
//	//Create the date
//		LocalDateTime dateTime= LocalDateTime.now();
//		
//		System.out.println(dateTime);
//		
//		//Formate
//		DateTimeFormatter formateDateTimeFormatter= DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
//		
//		 String date= dateTime.format(formateDateTimeFormatter);
//		
//		 System.out.println(date);
//		 
//		 String[] arr= date.split("1");
//		 String dateonly = arr[0];
//		 String time = arr[1];
//		 
//		 
//		 System.out.println(dateonly);
//		 System.out.println(time);
//		 System.out.println(arr[2]);
//		 System.out.println(arr[3]);

		Date date = new Date();

		System.out.println(date);

		String datenewString = date.toString().replace(" ", "_").replace(":", "_");
		System.out.println(datenewString);

	}

}
