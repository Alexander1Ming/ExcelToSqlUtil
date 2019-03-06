package com.github.sd4324530.fastexcel;

import com.github.sd4324530.fastexcel.entity.MyTest;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author peiyu
 */
public class ExcelTest {

    /**
     * 读取xls文件
     * @throws IOException
     */
    public static void readXls() throws IOException
    {
        FileInputStream in = new FileInputStream("/home/song/Desktop/book1.xls");
        HSSFWorkbook book = new HSSFWorkbook(in);

        HSSFSheet sheet = book.getSheetAt(0);
        HSSFRow row;
        String cell;

        for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++)
        {
            row = sheet.getRow(i);
            for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++)
            {
                cell = row.getCell(j).toString();
                System.out.print(cell + " \t");
            }
            System.out.println("");
        }
    }

    /**
     * 读取xlsx文件
     * @throws IOException
     */
    public static void readXlsx() throws IOException
    {
        XSSFWorkbook xwb = new XSSFWorkbook("/home/song/Desktop/book1.xlsx");
        XSSFSheet sheet = xwb.getSheetAt(0);
        XSSFRow row;
        String cell;
        for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++)
        {
            row = sheet.getRow(i);
            for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++)
            {
                cell = row.getCell(j).toString();
                System.out.print(cell + "\t");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws IOException
    {
        //readXls();
        readXlsx();
    }

}
