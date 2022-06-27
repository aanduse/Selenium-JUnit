package com.myfirstproject;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Day09_ReadExcel {
    //workbook > worksheet > row > cell
    @Test
    public void readExcel() throws IOException {
        String path = "./src/test/java/resources/Capitals.xlsx";
//        String path = ".\\src\\test\\java\\resources\\Capitals.xlsx";
//        Open the file
        FileInputStream fileInputStream = new FileInputStream(path);
//        Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Open the first worksheet
        /*getSheetAt(0); accepts an integer and is used to get the specific sheet
         * to go to 1st sheet use index of 0. */
        Sheet sheet1=workbook.getSheetAt(0);
//        Go to first row
        /*getRow(0); accepts an integer and is used to get the specific row
         * to go to 1st row use index of 0*/
        Row row1=sheet1.getRow(0);
//        Go to first cell on that first row and print
        /*getCell(0) accepts an integer and is used to get the specific cell
         * to go to 1st cell use index of 0*/
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);
        /*Cell objects can be converted to a string easily
         * We may need to convert to a string if we need to manipulate the data
         * such as lowercase, charAt, length,..*/
        System.out.println(cell1.toString().toLowerCase());
//        Go to second cell on that first row and print
        Cell cell2 = row1.getCell(1);
        System.out.println(cell2);
//        Go to 2nd row first cell  and assert if the data equal to USA
//                  sheet1    row2      cell1        convert to string
        String r2c1=sheet1.getRow(1).getCell(0).toString();
        Assert.assertEquals("USA",r2c1);
//        Go to 3rd row 2nd cell-chain the row and cell
        String r3c2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println(r3c2);
//        Find the number of row
        /*getLastRowNum() index starts at 0
         * Checks the last row that is used*/
        int numberOfRow = sheet1.getLastRowNum()+1;
        System.out.println(numberOfRow);
//        Find the number of used row
        /*getPhysicalNumberOfRows() index starts at 1
         * checks the total rows that is used*/
        int numberOfRowUsed = sheet1.getPhysicalNumberOfRows();
        System.out.println(numberOfRowUsed);
//        Print country, capitol key value pairs as map object
//        {USA=D.C,France=Paris,England=London,...}
        Map<String,String> countryCapitals = new HashMap<>();
        for (int rowNumber = 1;rowNumber<numberOfRow; rowNumber++) {
            String countries = sheet1.getRow(rowNumber).getCell(0).toString();
//            System.out.println(countries);
            String capitals= sheet1.getRow(rowNumber).getCell(1).toString();
//            System.out.println(capitals);
            countryCapitals.put(countries,capitals);
        }
        System.out.println(countryCapitals);
    }
}