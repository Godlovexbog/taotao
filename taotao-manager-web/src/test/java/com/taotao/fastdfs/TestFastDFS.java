package com.taotao.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.taotao.utils.FastDFSClient;

public class TestFastDFS {
	@Test
	public void uploadFile() throws Exception {
		// 1、fastdfs添加jar包
		// 2、创建一个配置文件，tracker服务器的地址
		// 3、加载配置文件
		ClientGlobal
				.init("F:\\Java\\eclipseFile\\taotao\\taotao-manager-web\\src\\main\\resources\\resource\\client.conf");
		// 4、创建一个trackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		// 5、使用trackerClient对象获得trackServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		// 6、创建一个StorageServer的引用
		StorageServer storageServer = null;
		// 7、创建一个StorgeClient
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);

		// 8、使用StorageClient对象上传文件。
		String[] strings = storageClient.upload_file("D:/Documents/Pictures/images/200811281555127886.jpg", "jpg",
				null);
		for (String string : strings) {
			System.out.println(string);

		}
	
	}
	
	
	@Test
	public void testFastDfsClient() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient("D:/workspaces-itcast/JavaEE28/taotao-manager-web/src/main/resources/resource/client.conf");
		String string = fastDFSClient.uploadFile("D:/Documents/Pictures/images/2010091809520375_S.jpg");
		System.out.println(string);
	}
}
