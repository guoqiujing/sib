package cn.myzqu.file;

import cn.myzqu.pojo.ChoiceQuestion;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.*;


/**
 * Created by 的川 on 2018/5/18.
 */

public class ReadExcel {


    public static List<ChoiceQuestion> start(InputStream in, String path) throws  IOException {
        Workbook book = getWorkBook(in, path);// 获取文件
        List<Sheet> sheets = getSheets(book);// 获取所有工作表
        List<ChoiceQuestion> list=sheetIterator(sheets);// 对工作表操作
        System.out.println(list);
        return list;
    }

    /**
     * 获取文件工作空间
     * @param in
     * @param path
     * @return
     * @throws IOException
     */
    public static Workbook getWorkBook(InputStream in, String path) throws  IOException {
        return path.endsWith(".xls") ? (new HSSFWorkbook(in))
                : (path.endsWith(".xlsx") ? (new XSSFWorkbook(in)) : (null));
    }

    /**
     * 从工作空间获取所有的sheets文件
     * @param book
     * @return
     */
    public static List<Sheet> getSheets(Workbook book) {
        int numberOfSheets = book.getNumberOfSheets();
        System.out.println("number" + numberOfSheets);
        List<Sheet> sheets = new ArrayList<>();
        for (int i = 0; i < numberOfSheets; i++) {
            sheets.add(book.getSheetAt(i));
        }
        return sheets;
    }

    /**
     * 获取sheets的数据
     * @param sheets
     * @return
     */
    public static List sheetIterator(List<Sheet> sheets) {
        List list = new ArrayList<>();
        //遍历工作页sheet
        for (int k = 0; k < sheets.size(); k++) {
            Sheet sheet = sheets.get(k);
            //遍历行，跳过首行
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                System.out.println("开始遍历第" + i + "行");
                Row row = sheet.getRow(i);
                //获取每行的有效单元格个数
                int cellNum = row.getLastCellNum();
                //遍历每行的单元格
                for (int j = 1; j <= cellNum; j++) {
                    Cell cell = row.getCell(j - 1);
                    //将格式统一设置为字符串
                    cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                    System.out.println("第" + j + "列：" + cell.getStringCellValue());
                }
            }
        }
        return list;
    }

}
