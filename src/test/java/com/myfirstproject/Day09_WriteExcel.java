package com.myfirstproject;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Day09_WriteExcel {
    @Test
    public void writeExcel() throws IOException {
//    Store the path of the file as string and open the file
        String path = "./src/test/java/resources/Capitals.xlsx";
//        String path=".\\src\\test\\java\\resources\\Capitals.xlsx";//windows
//    Open the workbook
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//    Open the first worksheet
//        Sheet sheet1 = workbook.getSheet("Sheet1");
        Sheet sheet1 = workbook.getSheetAt(0);
//    Go to the first row
        Row row1 = sheet1.getRow(0);
//    Create a cell on the 3rd column (2nd index) on the first row
        /*createCell(2); creates a cell on 3rd cell*/
        Cell r1c3 = row1.createCell(2);
//    Write “POPULATION” on that cell
        /*setCellValue("POPULATION"); is used to type in a cell*/
        r1c3.setCellValue("POPULATION");
//    Create a cell on the row2 cell3(index2), and write 150000
        sheet1.getRow(1).createCell(2).setCellValue("150000");
//    Create a cell on the row3 cell3(index2), and write 250000
        sheet1.getRow(2).createCell(2).setCellValue("250000");
//    Create a cell on the row4 cell3(index2), and write 54000
        sheet1.getRow(3).createCell(2).setCellValue("54000");
//    Write and save the workbook
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
//    Close the file
        fileInputStream.close();
        fileOutputStream.close();
//    Close the workbook
        workbook.close();
    }
}