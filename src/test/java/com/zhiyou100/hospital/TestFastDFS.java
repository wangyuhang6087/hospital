package com.zhiyou100.hospital;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

/**
* @author Rain
* @des:
* 创建时间：2019年9月23日 下午2:43:07
* 	上传:
* 	下载:
* 	删除:
*/
public class TestFastDFS {
	/*
	 * 1. 依赖架包  jar
	 * 2. FastDFS 配置文件	
	 * 3.javaAPI
	 * 	加载配置文件
	 * 	创建Tracker客户端
	 * 	通过Tracker客户端得到tracker对象  
	 * 	通过Tracker得到Storage客户端
	 * 	创建文件属性存储对象
	 * 	通过客户端执行上传
	 */
	
	@Test   // 上传
	public void upload() throws IOException, MyException {
		
		//	加载配置文件
		ClientGlobal.init("D:\\eclipse\\work-oxygn_2\\hospital\\src\\main\\resources\\fastdfs-client.properties");
		// 创建Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		//	通过Tracker客户端得到tracker对象  
		TrackerServer connection = trackerClient.getConnection();
		//	通过Tracker得到Storage客户端
		StorageClient1 storageClient1 = new StorageClient1(connection,null);
		//	创建文件属性存储对象
		NameValuePair[] list = new NameValuePair[1];
		list[0] = new NameValuePair("fileName","drug.jpg");
		//	通过客户端执行上传
		//  参数1,文件的地址: 绝对路径
		//  参数2,文件类型:
		//  参数3,文件对应的属性数组
		String fid = storageClient1.upload_file1("C:\\Users\\Administrator\\Desktop\\drug.jpg","jpg",list);
		System.out.println("上传路径为: " + fid);
	}
	
	
	@Test  // 下载
	public void download() throws IOException, MyException {
			String fid = "group1/M00/00/00/wKiOgF2IdVSANjbZAACFS2nTckY009.jpg";
			//	加载配置文件
			ClientGlobal.init("D:\\eclipse\\work-oxygn_2\\hospital\\src\\main\\resources\\fastdfs-client.properties");
			// 创建Tracker客户端
			TrackerClient trackerClient = new TrackerClient();
			//	通过Tracker客户端得到tracker对象  
			TrackerServer connection = trackerClient.getConnection();
			//	通过Tracker得到Storage客户端
			StorageClient1 storageClient1 = new StorageClient1(connection,null);
			byte[] bytes = storageClient1.download_file1(fid);
			
			OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\drug1.jpg");
			System.out.println("下载成功");
			out.write(bytes);
			out.close();
			
	}
	
	@Test  // 删除
	public void delete() throws IOException, MyException {
		String fid = "group1/M00/00/00/wKiOgF2IQ_CAApCCAAAqwM7vcew025.jpg";
		//	加载配置文件
		ClientGlobal.init("D:\\eclipse\\work-oxygn_2\\hospital\\src\\main\\resources\\fastdfs-client.properties");
		// 创建Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		//	通过Tracker客户端得到tracker对象  
		TrackerServer connection = trackerClient.getConnection();
		//	通过Tracker得到Storage客户端
		StorageClient1 storageClient1 = new StorageClient1(connection,null);
		storageClient1.delete_file1(fid);
		System.out.println("删除成功");
		
	}
	
/*	public void update() throws IOException, MyException{
		ClientGlobal.init("D:\\eclipse\\work-oxygn_2\\hospital\\src\\main\\resources\\fastdfs-client.properties");
		// 创建Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		//	通过Tracker客户端得到tracker对象  
		TrackerServer connection = trackerClient.getConnection();
		//	通过Tracker得到Storage客户端
		StorageClient1 storageClient1 = new StorageClient1(connection,null);
	
	}
	*/
}
