package com.zhiyou100.Ajax_Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.util.FastDFSUtil;

/**
 * @author 说明: 创建时间：2019年9月3日 下午4:31:35
 */
@Controller
public class AjaxController {
	
	@Autowired
	AJaxService as;

	@RequestMapping("/checkUser")
	public void checkUser(String usernameJsonkey,HttpServletResponse resp) throws IOException {
		System.out.println("获得ajax发送的数据为: " + usernameJsonkey);
		String code = as.checkUser(usernameJsonkey);
		resp.getWriter().write(code);
		
	}
	
	@RequestMapping("/checkUser2")
	@ResponseBody
	public ResponseObject checkUser2(String usernameJsonkey) throws IOException {
		System.out.println("获得ajax发送的数据为: " + usernameJsonkey);
		ResponseObject responseObject = as.checkUser2(usernameJsonkey);
		return responseObject;	
	}
	
	@RequestMapping("/findUserById.do")
	@ResponseBody
	public ResponseObject findUserById(String id) {
		ResponseObject obj = as.findUserById(id);
		return obj;		
	}
	
	@RequestMapping("/findDoctorBySectionId.do")
	@ResponseBody
	public ResponseObject findDoctorBySectionId(String sectionId) {
		ResponseObject obj = as.findDoctorBySectionId(sectionId);
		return obj;		
	}
	// =================================
		@RequestMapping("/toEchartsUI.do")
		public String toEchartsUI() {
		return "echarts";
		}
		@RequestMapping("/showEcharts.do")
		@ResponseBody
		public double[] showEcharts() {		
			double [] month = {100.0,90.0,80.0,70.0,60.0,50.0,40.0};
			return month;		
		}
	// =================================
		// =================================
		@RequestMapping("/toEchartsUI2.do")
		public String toEchartsUI2() {
		return "echarts2";
		}
		@RequestMapping("/toEchartsUI3.do")
		public String toEchartsUI3() {
		return "echarts3";
		}
		
		@RequestMapping("/showEcharts2.do")
		@ResponseBody
		public List<Double[]> showEcharts2() {
			List<Double[]> lists = new ArrayList<>();
			Double[] k1 = {100.0,10.0,80.0,70.0,60.0,50.0,40.0};
			Double[] k2 = {40.0,50.0,60.0,70.0,80.0,90.0,100.0};
			Double[] k3 = {80.0,90.0,10.0,70.0,55.0,66.0,77.0};
			Double[] k4 = {100.0,90.0,10.0,70.0,20.0,50.0,40.0};
			lists.add(k1);
			lists.add(k2);
			lists.add(k3);
			lists.add(k4);
			return lists;		
		}
	// =================================
	
		@RequestMapping("/showEcharts3.do")
		@ResponseBody
		public List<Double[]> showEcharts3() {
			List<Double[]> lists = new ArrayList<>();
			Double[] k1 = {100.0,10.0,80.0,70.0,60.0,50.0,40.0};
			Double[] k2 = {40.0,50.0,60.0,70.0,80.0,90.0,100.0};
			Double[] k3 = {80.0,90.0,10.0,70.0,55.0,66.0,77.0};
			Double[] k4 = {100.0,90.0,10.0,70.0,20.0,50.0,40.0};
			lists.add(k1);
			lists.add(k2);
			lists.add(k3);
			lists.add(k4);
			return lists;		
		}		
		
		
		/*
		 * ajax实现上传并回显
		 * (上传至服务器)
		 */
		@RequestMapping("/upload.do")
		@ResponseBody
		public ResponseObject ajaxUpload(MultipartFile img,HttpServletRequest request) throws IOException {
			// 1.获得上传的对象
			// 2. 获得最终上传的目的地路径(上传至服务器中当前项目下)
			String realPath = request.getServletContext().getRealPath("/upload");
			System.out.println(realPath);
			// 2.1 将最终目的文件夹创建出来
			File file = new File(realPath);
			// 判断该文件是否存在
			if(file.exists()) {
				// 不存在则创建出
				file.mkdir();
			}
			/*
			 * 文件名重复时不能重复上传文件
			 */
			String fileName = img.getOriginalFilename();
			System.out.println(fileName);
			/*
			 * 获得文件后缀名
			 */
			String[] split = fileName.split("\\.");
			System.out.println(Arrays.toString(split));
			String suffix = split[1];
			// 以当前毫秒值为文件名
			long prefix = new Date().getTime();
			// 组装文件名
			String newFileName = prefix+"."+suffix;
			System.out.println("新的文件名 : "+newFileName);
			System.out.println("文件名 : "+fileName);
			// 2.3 确定上传路径
			File newFile = new File(file,newFileName);
			// 3. 上传
			FileUtils.writeByteArrayToFile(newFile, img.getBytes());

			String path = "/upload/"+newFileName;
			
			return new ResponseObject("200","成功",path);
			
		}
		
		/*
		 * ajax上传回显,上传至FastDFS
		 */
		@RequestMapping("/uploadByFastDFS.do")
		@ResponseBody
		public ResponseObject ajaxUploadFastDFS(MultipartFile img) throws IOException, MyException {
			ResponseObject obj = FastDFSUtil.upload(img);
			return obj;		
		}
		
		/*
		 * 下载
		 */
		@RequestMapping("/downloadByFastDFS.do")
		public void downloadByFastDFS(String fid,HttpServletResponse respone) throws IOException, MyException {
			
			System.err.println("从页面接收的fid");
			byte[] bytes = FastDFSUtil.downLoad(fid);
			System.out.println("开始下载");

			// String encode = URLEncoder.encode("图片","utf-8");
			// 弹框显示的...
			respone.setHeader("Content-disposition", "attachment;filename = "+new Date().getTime()+".png");
			respone.setContentType("image/jpg");
			
			OutputStream outputStream = respone.getOutputStream();
			outputStream.write(bytes);
			outputStream.flush();
			outputStream.close();

			System.out.println("下载成功");
				
		}
				
}
