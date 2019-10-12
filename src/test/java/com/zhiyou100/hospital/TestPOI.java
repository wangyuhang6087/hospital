package com.zhiyou100.hospital;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

/**
* @author Rain
* @des:
* 创建时间：2019年9月19日 上午11:54:11
*/

public class TestPOI {
	
	@Test
	public void export() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("用户信息");
		HSSFRow row = sheet.createRow(0);
		
		HSSFCell r0c0 = row.createCell(0);
		r0c0.setCellValue("编号");
		HSSFCell r0c1 = row.createCell(1);
		r0c1.setCellValue("姓名");
		HSSFCell r0c2 = row.createCell(2);
		r0c2.setCellValue("密码");
		HSSFCell r0c3 = row.createCell(3);
		r0c3.setCellValue("邮箱");
		
		OutputStream os = new FileOutputStream("D:\\2.xls");
		wb.write(os);
		os.close();
	}
}
