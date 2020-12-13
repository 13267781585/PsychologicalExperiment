package jianxin.psyExperiment.support.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
	private static final String XLS = "xls";
    private static final String XLSX = "xlsx";
	
    /**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param values 内容
     * @param wb HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String []title, List<List<String>> values, HSSFWorkbook wb){

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //创建内容
        for(int i=0;i<values.size();i++){
            row = sheet.createRow(i + 1);
            for(int j=0;j<values.get(i).size();j++){
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values.get(i).get(j));
            }
        }
        return wb;
    }
    
    
    public static void main(String[] args) throws Exception{
    	
    	String[] title = {"名称","性别","年龄","学校","班级"};
    	
    	String fileName = "学生信息表"+System.currentTimeMillis()+".xls";
    	
    	String sheetName = "学生信息表";
    	
    	List<List<String>> values = new ArrayList<>();
    	
    	for(int i = 0;i<30;i++){
    		List<String> value = new ArrayList<>();
    	    
    		value.add("stuName");
    		value.add("stuSex");
    		value.add("stuAge");
    		value.add("stuSchoolName");
    		value.add("stuClassName");
    		values.add(value);
    	}

    	HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, values, null);
    	File tempFile = new File("D:/桌面/见心/test.xls");;
    	OutputStream tempout = new FileOutputStream(tempFile);;
    	wb.write(tempout);
    }
    
 
    

}
