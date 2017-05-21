package com.wisesoft.filecenter;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;

public class FileSocketClient {
	/**
	 * 文件同步
	 * @param fullFileName 文件全名 
	 * @param destIP
	 * @param destPort
	 */
	public static void synchFile(String fullFileName, String destIP, int destPort) {
		Socket socket = null;
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(destIP, destPort));
			File file = new File(fullFileName);
			FileInputStream fs = new FileInputStream(file);
			// 定义一个256字节的区域来保存文件信息。
			byte[] b = file.getAbsolutePath().getBytes();
			byte[] info = Arrays.copyOf(b, 256);
			ByteArrayInputStream bais = new ByteArrayInputStream(info);
			// 合并流
			SequenceInputStream sis = new SequenceInputStream(bais, fs);
			BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = sis.read(buf)) != -1) {
				bos.write(buf, 0, len);
			}
			bos.close();
			sis.close();
			fs.close();
			bais.close();
		} catch (Exception e) {
			System.out.println("客户端文件传输异常");
			e.printStackTrace();
		} finally {
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
}
