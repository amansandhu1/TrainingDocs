package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private String filePath;
	private int sheetIndex;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	ExcelUtility(String filePath, int sheetIndex) {
		this.filePath = filePath;
		this.sheetIndex = sheetIndex;
	}

	private XSSFSheet getSheet() throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(sheetIndex);
		return sheet;
	}

	public HashMap<String, Map<String, String>> getExcelAsMap() throws IOException {
		XSSFSheet sheet = getSheet();
		HashMap<String, Map<String, String>> completeSheetData = new HashMap<String, Map<String, String>>();
		List<String> columnHeader = new ArrayList<String>();
		Row row = sheet.getRow(0);
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			columnHeader.add(cellIterator.next().getStringCellValue());
		}
		int rowCount = row.getLastCellNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		for (int i = 1; i <= rowCount; i++) {
			Map<String, String> singleRowData = new HashMap<String, String>();
			Row row1 = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				Cell cell = row1.getCell(j);
				singleRowData.put(columnHeader.get(j), getCellValueAsString(cell));
			}
			completeSheetData.put(String.valueOf(i), singleRowData);
		}
		workbook.close();
		return completeSheetData;
	}

	public String getCellValueAsString(Cell cell) {
		String cellValue = null;
		switch (cell.getCellType()) {
		case NUMERIC:
			cellValue = String.valueOf((int)cell.getNumericCellValue());
			break;
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case FORMULA:
			cellValue = cell.getCellFormula();
		case BLANK:
			cellValue = "BLANK";
		default:
			cellValue = "DEFAULT";
		}
		return cellValue;
	}
	public static void main(String[] args) throws IOException {
		ExcelUtility ex = new ExcelUtility(".//Resources//TestData.xlsx", 0);
        HashMap<String, Map<String, String>> excelData =ex.getExcelAsMap();
        System.out.println("Excel Data for 2nd row and column- AccountNo : "+excelData.get("2").get("Bank Name"));
        System.out.println("excelData as Map: "+excelData);
    }
}
