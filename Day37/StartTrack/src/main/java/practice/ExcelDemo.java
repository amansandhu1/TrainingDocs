package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class ExcelDemo {
	@Test
	public void demo() throws IOException {
		File filename = new File(".//Resources//TestData.xlsx");
		FileInputStream fis = new FileInputStream(filename);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				System.out.println(sheet.getRow(i).getCell(j));
			}
		}
		wb.close();
	}
	
	@Test
	public void demo2() {
		
	}
}
