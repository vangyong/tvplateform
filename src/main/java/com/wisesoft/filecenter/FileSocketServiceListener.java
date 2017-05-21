package com.wisesoft.filecenter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FileSocketServiceListener implements ServletContextListener {
	private FileSocketThread socketThread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if (null != socketThread && !socketThread.isInterrupted()) {
			socketThread.closeSocketServer();
			socketThread.interrupt();
		}
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		if (null == socketThread) {
			socketThread = new FileSocketThread(null);
			socketThread.start();
		}
	}
}
