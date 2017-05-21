package com.wisesoft.filecenter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.wisesoft.frame.core.util.PropertiesUtil;

public class FileSocketThread extends Thread {
	public static final String FILE_UD_CONFIG = "fileud/file_ud_config.properties";
	public static int FILE_SOCKET_PORT = Integer.valueOf(PropertiesUtil.getValueByResource(FILE_UD_CONFIG, "fileSocketPort"));
	
	private ServerSocket serverSocket = null;

	public FileSocketThread(ServerSocket serverScoket) {
		try {
			if (null == serverSocket) {
				this.serverSocket = new ServerSocket(FILE_SOCKET_PORT);
				System.out.println("FileSynchSocketThread socket start");
			}
		} catch (Exception e) {
			System.out.println("FileSynchSocketThread创建socket服务出错");
			e.printStackTrace();
		}
	}
	public void run() {
		while (!this.isInterrupted()) {
			try {
				Socket socket = serverSocket.accept();
				if (null != socket && !socket.isClosed()) {
					// 处理接受的数据
					new FileSocketOperate(socket).start();
				}
				socket.setSoTimeout(30000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void closeSocketServer() {
		try {
			if (null != serverSocket && !serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
