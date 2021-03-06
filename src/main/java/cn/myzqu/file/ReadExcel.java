package cn.myzqu.file;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 的川 on 2018/5/18.
 */

public class ReadExcel {

    public static List start(String path) throws  IOException {
        InputStream in = new FileInputStream(new File(path));

        Workbook book = getWorkBook(in, path);// 获取文件
        List<Sheet> sheets = getSheets(book);// 获取所有工作表
        List list=sheetIterator(sheets);// 对工作表操作

        for(int i=0;i<list.size();i++){
            List row  = (List)list.get(i);
            for (int j=0;j<row.size();j++){
                System.out.println(i+":"+j+":" +row.get(j));
            }
        }

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
                List<String> rowList = new ArrayList();
                //遍历每行的单元格
                for (int j = 1; j <= cellNum; j++) {
                    Cell cell = row.getCell(j - 1);
                    if(cell != null){
                        //将格式统一设置为字符串
                        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                        System.out.println("第" + j + "列：" + cell.getStringCellValue());
                        rowList.add(cell.getStringCellValue());
                    }else{
                        rowList.add("");
                    }

                }
                list.add(rowList);
            }
        }
        return list;
    }

}
