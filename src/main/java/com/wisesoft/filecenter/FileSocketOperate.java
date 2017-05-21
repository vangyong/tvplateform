package com.wisesoft.filecenter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FileSocketOperate extends Thread {
	private Socket socket;

	public FileSocketOperate(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			System.out.println("开始监听...");
			receiveFileContent(socket);
		} catch (Exception e) {
			System.out.println("FileSynchSocketOperate 服务器异常");
			e.printStackTrace();
		}
	}
	/**
	 * 接收文件方法
	 * @param socket
	 * @throws IOException
	 */
	public static void receiveFileContent(Socket socket) throws IOException {
		try {
			BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
			byte[] info = new byte[256];
			bis.read(info);
			String file_name = new String(info).trim();
			File file = new File(file_name);
			if (!file.exists()) {
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				file.createNewFile();
			}
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = bis.read(buf)) != -1) {
				bos.write(buf, 0, len);
			}
			bos.close();
			bis.close();
			socket.close();
			System.out.println(file_name + "  文件传输成功");
		} finally {
			if (socket != null)
				socket.close();
		}
	}
}
