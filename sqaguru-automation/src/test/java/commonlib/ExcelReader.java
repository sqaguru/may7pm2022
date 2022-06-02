package commonlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.Reporter;

public class ExcelReader {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		readExcelData();
	}

	public static Object[] readExcelData() throws FileNotFoundException, IOException {
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\testdata\\TestNGDataProvideUsingExcelTest.xls"));

		HSSFSheet sheet = workbook.getSheet("testdata");

		int rowsCount = sheet.getPhysicalNumberOfRows();

		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Reporter.log("rowsCount: " + rowsCount, true);
		Reporter.log("ColumnCount: " + columnCount, true);
		Object[] object = new Object[rowsCount - 1];
		for (int rowCounter = 1; rowCounter < rowsCount; rowCounter++) {
			Map<String, String> keyValues = new HashMap<String, String>();
			HSSFRow headerRow = sheet.getRow(0);
			HSSFRow row = sheet.getRow(rowCounter);
			for (int columnCounter = 0; columnCounter < columnCount; columnCounter++) {
				String cellColumn = headerRow.getCell(columnCounter).getStringCellValue();
				String cellData = row.getCell(columnCounter).getStringCellValue();
				System.out.println(cellColumn + " cellData: " + cellData);
				keyValues.put(cellColumn, cellData);
			}
			object[rowCounter - 1] = keyValues;
		}
		return object;
	}
}
