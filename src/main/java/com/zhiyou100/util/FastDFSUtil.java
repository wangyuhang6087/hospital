package com.zhiyou100.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;
import com.zhiyou100.Ajax_Test.ResponseObject;

/**
 * @author Rain
 * @des: FastDFS .. 上传文件 创建时间：2019年9月23日 下午7:10:20
 */
public class FastDFSUtil {
	/*
	 * 从jsp页面传来的 图片 img conf_filename : 例如,000000
	 * D:\\eclipse\\work-oxygn_2\\hospital\\src\\main\\resources\\fastdfs-client.
	 * properties
	 */
	public static ResponseObject upload(MultipartFile img) throws IOException, MyException {

		String path = "";
		// 获得文件名
		String fileName = img.getOriginalFilename();
		// 获得后缀
		String[] split = fileName.split("\\.");
		String suffix = split[1];
		// 加载配置文件
		
		ClientGlobal.init("D:\\eclipse\\work-oxygn_2\\hospital\\src\\main\\resources\\fastdfs-client.properties");
		// 创建 Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		// 通过Tracker客户端得到Tracker对象
		TrackerServer connection = trackerClient.getConnection();
		// 通过Tracker得到Storage客户端
		StorageClient1 storageClient1 = new StorageClient1(connection, null);
		// 创建文件属性 存储对象
		NameValuePair[] list = new NameValuePair[1];
		list[0] = new NameValuePair("fileName", fileName);

		String fid = storageClient1.upload_file1(img.getBytes(), suffix, list);
		// 拼接访问路径
		path = "http://java21:80/" + fid;
		Map<String,String> map = new HashMap<>();
		map.put("path", path);
		map.put("fid", fid);
		
		System.err.println(path);
	
		// /group1/M00/00/00/wKiOgF2IcCqADJGHAAAqwM7vcew299.jpg
		return new ResponseObject("200", "成功",map);
	}

	// 下载
	public static  byte[] downLoad(String fid) throws IOException, MyException {

		
		ClientGlobal.init("D:\\eclipse\\work-oxygn_2\\hospital\\src\\main\\resources\\fastdfs-client.properties");
		// 创建 Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		// 通过Tracker客户端得到Tracker对象
		TrackerServer connection = trackerClient.getConnection();
		// 通过Tracker得到Storage客户端
		StorageClient1 storageClient1 = new StorageClient1(connection, null);
		byte[] bytes = storageClient1.download_file1(fid);
		
		return bytes;
		
	}
}