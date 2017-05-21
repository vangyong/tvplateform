package com.wisesoft.frame.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/*
 * 
 * @ClassName: FileUtil 
 * @description: 文件处理类
 * @author: wangyong
 * @date: 2016年4月8日 下午5:24:18
 */
public final class FileUtil {
	public static final String FILE_SEPARATER = "\\";
	public static final String OFFICE_SUFFIX = ".doc,.xls,.ppt,.docx,.xlsx,.pptx";
	public static final String PIC_SUFFIX = ".bmp,.jpg,.jpeg,.png,.gif";
	public static final String VIDIO_SUFFIX = ".avi,.mkv,.mp4,.m4v,.flv";
	public static final String RADIO_SUFFIX = ".wav,.mp1,.mp2,.mp3,.mp4,.wma";
	public static final int TYPE_OFFICE = 0;
	public static final int TYPE_PIC = 1;
	public static final int TYPE_VIDIO = 2;
	public static final int TYPE_RADIO = 3;

	/**
	 * @title: exists
	 * @description: 根据路径判断是否是目录
	 * @return: boolean
	 */
	public static boolean exists(String path) {
		if (StringUtil.isEmpty(path))
			return false;
		File file = new File(path);
		return file.exists();
	}
	/**
	 * 返回一个文件的不带路径及扩展名的名称
	 * @param file
	 * @return 注：如果传入的file为null或是目录，则返回null
	 */
	public static String getFileNameOfNoExtention(File file) {
		if (file == null || file.isDirectory()) {
			return null;
		}
		String name = file.getName();
		int indexOfDot = name.lastIndexOf(".");
		if (indexOfDot == -1) {
			return name;
		}
		return name.substring(0, indexOfDot);
	}
	/**
	 * 判断filename是否是目录
	 * @param dir
	 * @param filename
	 * @return
	 */
	public static boolean exists(String dir, String filename) {
		if (StringUtil.isEmpty(dir) || StringUtil.isEmpty(filename))
			return false;
		File file = new File(dir, filename);
		return file.exists();
	}
	/**
	 * 通过File得到文件大小
	 * @param file
	 * @return
	 */
	public static long getFileSize(File file) {
		long len = 0;
		if (!file.exists())
			return len;
		if (file.isFile())
			len = file.length();
		else {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				len += getFileSize(files[i]);
			}
		}
		return len;
	}
	/**
	 * 通过目录和文件名称得到文件大小
	 * @param dir
	 * @param filename
	 * @return
	 */
	public static long getFileSize(String dir, String filename) {
		File file = new File(dir, filename);
		long len = 0;
		if (!file.exists())
			return len;
		if (file.isFile())
			len = file.length();
		else {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				len += getFileSize(files[i]);
			}
		}
		return len;
	}
	/**
	 * 文件路径得到上级文件目录名称
	 * @param filePath
	 * @return
	 */
	public static String getFolderName(String filePath) {
		String fileName = getBaseFileName(filePath);
		if (!StringUtil.isEmpty(fileName)) {
			return filePath.substring(0, filePath.lastIndexOf(fileName) - 1);
		}
		return null;
	}
	/**
	 * 根据文件得到当前文件或目录名称
	 * @param filePath
	 * @return
	 */
	public static String getBaseFileName(String filePath) {
		String fileName = (new File(filePath)).getName();
		int colonIndex = fileName.indexOf(":");
		if (colonIndex == -1)
			colonIndex = fileName.indexOf("\\\\");
		int backslashIndex = fileName.lastIndexOf("\\");
		if (colonIndex > -1 && backslashIndex > -1)
			fileName = fileName.substring(backslashIndex + 1);
		return fileName;
	}
	/**
	 * 复制文件 指定文件到目标文件夹下
	 * @param sourceDir 源文件目录
	 * @param targetDir 目标文件目录
	 * @param suffix 要复制文件类型数组
	 * @throws IOException
	 */
	public static void copyDirectiory(String sourceDir, String targetDir, String[] suffix) throws IOException {
		// deleteDirectiory(targetDir);
		// 新建目标目录
		File targetDirectiory = new File(targetDir);
		if (!targetDirectiory.exists()) {
			(new File(targetDir)).mkdirs();
		}
		// 获取源文件夹当前下的文件或目录
		File[] file = (new File(sourceDir)).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				// 源文件
				File sourceFile = file[i];
				if (suffix != null) {
					boolean isSuffix = false;
					String str = "";
					try {
						str = sourceFile.getAbsolutePath().substring(sourceFile.getAbsolutePath().lastIndexOf(".") + 1,
								sourceFile.getAbsolutePath().length());
					} catch (Exception e) {
						str = "";
					}
					for (int j = 0; j < suffix.length; j++) {
						if (suffix[j].equals(str)) {
							isSuffix = true;
							break;
						}
					}
					if (!isSuffix) {
						continue;
					}
				}
				// 目标文件
				File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
				copyFile(sourceFile, targetFile);
			}
			if (file[i].isDirectory()) {
				// 准备复制的源文件夹
				String dir1 = sourceDir + "/" + file[i].getName();
				// 准备复制的目标文件夹
				String dir2 = targetDir + "/" + file[i].getName();
				copyDirectiory(dir1, dir2);
			}
		}
	}
	/**
	 * 复制文件夹,如果targetDir存在,会先删除targetDir
	 * @param sourceDir 源文件
	 * @param targetDir 目标文件
	 * @throws IOException
	 */
	public static void copyDirectiory(String sourceDir, String targetDir) throws IOException {
		copyDirectiory(sourceDir, targetDir, null);
	}
	/**
	 * 复制文件
	 * @param sourceFile 源文件
	 * @param targetFile 目标文件
	 * @throws IOException
	 */
	public static void copyFile(File sourceFile, File targetFile) throws IOException {
		// 新建文件输入流并对它进行缓冲
		FileInputStream input = new FileInputStream(sourceFile);
		BufferedInputStream inBuff = new BufferedInputStream(input);
		// 如果父目录不存在则创建
		File parentFile = targetFile.getParentFile();
		if (parentFile != null && !parentFile.exists()) {
			parentFile.mkdirs();
		}
		// 新建文件输出流并对它进行缓冲
		FileOutputStream output = new FileOutputStream(targetFile);
		BufferedOutputStream outBuff = new BufferedOutputStream(output);
		// 缓冲数组
		byte[] b = new byte[1024 * 5];
		int len;
		while ((len = inBuff.read(b)) != -1) {
			outBuff.write(b, 0, len);
		}
		// 刷新此缓冲的输出流
		outBuff.flush();
		// 关闭流
		inBuff.close();
		outBuff.close();
		output.close();
		input.close();
	}
	/**
	 * 将输入流写入指定文件
	 * @param inputStream
	 * @param path
	 * @throws Exception
	 */
	public static void createNewFile(InputStream inputStream, String path) throws Exception {
		File file = new File(path);
		if (!file.exists())
			createNewFile(file);
		BufferedInputStream inBuff = new BufferedInputStream(inputStream);
		// 新建文件输出流并对它进行缓冲
		FileOutputStream output = new FileOutputStream(path);
		BufferedOutputStream outBuff = new BufferedOutputStream(output);
		// 缓冲数组
		byte[] b = new byte[1024 * 5];
		int len;
		while ((len = inBuff.read(b)) != -1) {
			outBuff.write(b, 0, len);
		}
		// 刷新此缓冲的输出流
		outBuff.flush();
		// 关闭流
		inBuff.close();
		outBuff.close();
		output.close();
	}
	/**
	 * 删除文件或文件夹
	 * @param targetFile
	 */
	public static synchronized void deleteDirectiory(String targetFile) {
		File f = new File(targetFile);
		if (!f.isDirectory()) {
			f.delete();
			return;
		}
		File[] file = f.listFiles();
		if (file == null || file.length == 0) {
			f.delete();
			return;
		}
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				file[i].delete();
			}
			if (file[i].isDirectory()) {
				deleteDirectiory(file[i].getAbsolutePath());
			}
		}
		if (f.listFiles() == null || f.listFiles().length == 0) {
			f.delete();
		}
	}
	/**
	 * 删除文件或文件夹
	 * @param targetFile
	 */
	public static synchronized void deleteDirectiory(File targetFile) {
		deleteDirectiory(targetFile.getAbsolutePath());
	}
	/**
	 * 判断是否是UTF-8
	 * @param path
	 * @return
	 */
	public static boolean isUTF8(String path) {
		boolean b = false;
		try {
			if (exists(path)) {
				InputStream is;
				is = new FileInputStream(path);
				byte[] buffer = new byte[3];
				is.read(buffer);
				if (buffer[0] == -17 && buffer[1] == -69 && buffer[2] == -65) {
					b = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 根据id获得并创建hashDir
	 * @param id 编号
	 * @return 目录名
	 */
	public static String hashDir(int id) {
		return hashDir("/file/", id);
	}
	/**
	 * 根据id获得并在指定位置创建hashDir
	 * @param basedir 指定位置
	 * @param id 编号
	 * @return 目录名
	 */
	public static String hashDir(String basedir, int id) {
		int i1 = id % 100;
		int i2 = id / 100 % 100;
		String s = String.format("%02d/%02d", i1, i2);
		File dir = new File(basedir + s);
		if (!dir.isDirectory())
			dir.mkdirs();
		// System.out.println(dir.getAbsolutePath());
		return s;
	}
	/**
	 * 根据id获得并在指定位置创建hashDir
	 * @param basedir 指定位置
	 * @param id 编号
	 * @param autoCreate 是否自动创建
	 * @return 目录名
	 */
	public static String hashDirSingle(String basedir, int id, boolean autoCreate) {
		int i1 = id % 100;
		String s = String.format("%02d", i1);
		File dir = new File(basedir + s);
		if (autoCreate && !dir.isDirectory())
			dir.mkdirs();
		// System.out.println(dir.getAbsolutePath());
		return s;
	}
	/**
	 * 根据id获得hashDir
	 * @param id 编号
	 * @return 目录名
	 */
	public static String hashDirNoCreate(int id) {
		int i1 = id % 100;
		int i2 = id / 100 % 100;
		String s = String.format("%02d/%02d", i1, i2);
		return s + "/" + id;
	}
	/**
	 * 集合里所有文件名转换成小写
	 * @param l List<Map<String, Object>>
	 * @return 集合List<Map<String, Object>>
	 */
	public static List<Map<String, Object>> nameToLowerCase(List<Map<String, Object>> l) {
		List<Map<String, Object>> tempList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> m : l) {
			Map<String, Object> mm = new HashMap<String, Object>();
			for (String s : m.keySet()) {
				mm.put(s.toLowerCase(), m.get(s));
			}
			tempList.add(mm);
		}
		return tempList;
	}
	/**
	 * 返回文件的扩展名的小写形式,如(txt exe)
	 * @param fileName
	 * @return
	 */
	public static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		if (pos == -1)
			return "";
		return fileName.substring(pos + 1).toLowerCase();
	}
	public static File createNewFile(String fileName) throws IOException {
		File file = new File(fileName);
		if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
		}
		return file;
	}
	public static File createNewFile(File file) throws IOException {
		if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
		}
		return file;
	}
	/**
	 * 返回一个文件夹下指定扩展名的所有文件
	 * @param directory
	 * @param extensionName 可以指定扩展名
	 * @return
	 */
	public static List<File> getAllFiles(String directory, String extensionName) {
		List<File> files = getAllFiles(directory);
		List<File> result = new ArrayList<File>();
		for (int i = 0, len = files.size(); i < len; i++) {
			File f = files.get(i);
			String name = getExtention(f.getName());
			if (!StringUtil.isEmpty(name) && name.equals(extensionName.toLowerCase())) {
				result.add(f);
			}
		}
		return result;
	}
	/**
	 * 返回一个文件夹下的所有文件
	 * @param directory
	 * @return
	 */
	public static synchronized List<File> getAllFiles(String directory) {
		List<File> result = new ArrayList<File>();
		File f = new File(directory);
		File[] files = f.listFiles();
		if (!CollectionUtil.isEmpty(files)) {
			for (int i = 0; i < files.length; i++) {
				File f1 = files[i];
				if (f1.isDirectory()) {
					result.addAll(getAllFiles(f1.getAbsolutePath()));
				} else {
					result.add(f1);
				}
			}
		}
		return result;
	}
	/**
	 * 得到文件内容的编码
	 * @param file
	 * @return
	 */
	public static String getCharset(File file) {
		String charset = "GBK";
		byte[] first3Bytes = new byte[3];
		try {
			boolean checked = false;
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			bis.mark(0);
			int read = bis.read(first3Bytes, 0, 3);
			if (read == -1)
				return charset;
			if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
				charset = "UTF-16LE";
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xFE && first3Bytes[1] == (byte) 0xFF) {
				charset = "UTF-16BE";
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xEF && first3Bytes[1] == (byte) 0xBB && first3Bytes[2] == (byte) 0xBF) {
				charset = "UTF-8";
				checked = true;
			}
			bis.reset();
			if (!checked) {
				// int len = 0;
				int loc = 0;
				while ((read = bis.read()) != -1) {
					loc++;
					if (read >= 0xF0)
						break;
					if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
						break;
					if (0xC0 <= read && read <= 0xDF) {
						read = bis.read();
						if (0x80 <= read && read <= 0xBF) // 双字节 (0xC0 - 0xDF) (0x80
															// - 0xBF),也可能在GB编码内
							continue;
						else
							break;
					} else if (0xE0 <= read && read <= 0xEF) {// 也有可能出错，但是几率较小
						read = bis.read();
						if (0x80 <= read && read <= 0xBF) {
							read = bis.read();
							if (0x80 <= read && read <= 0xBF) {
								charset = "UTF-8";
								break;
							} else
								break;
						} else
							break;
					}
				}
				// System.out.println( loc + " " + Integer.toHexString( read ) );
			}
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return charset;
	}
	/**
	 * 返回一个文件夹下名字包含fileName的文件和文件夹
	 * @param file
	 * @param fileName
	 * @return
	 */
	public static File getFileByName(File file, String fileName) {
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			File result = files[i];
			if (result.getName().toLowerCase().indexOf(fileName) != -1) {
				return result;
			}
		}
		return null;
	}
	/**
	 * 按行读取文件
	 */
	@SuppressWarnings("resource")
	public static List<String> readFileByLine(File file) throws IOException {
		List<String> list = new ArrayList<String>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferReader = new BufferedReader(reader);
		String str = null;
		while ((str = bufferReader.readLine()) != null) {
			list.add(str);
		}
		return list;
	}
	/**
	 * 对文件流输出下载的中文文件名进行编码 屏蔽各种浏览器版本的差异性
	 * @throws UnsupportedEncodingException
	 */
	public static String encodeChineseDownloadFileName(HttpServletRequest request, String pFileName)
			throws UnsupportedEncodingException {
		String filename = null;
		String agent = request.getHeader("USER-AGENT");
		if (null != agent) {
			if (-1 != agent.indexOf("Firefox")) {// Firefox
				filename = "=?UTF-8?B?"
						+ (new String(org.apache.commons.codec.binary.Base64.encodeBase64(pFileName.getBytes("UTF-8"))))
						+ "?=";
			} else if (-1 != agent.indexOf("Chrome")) {// Chrome
				filename = new String(pFileName.getBytes(), "ISO8859-1");
			} else {// IE7+
				filename = java.net.URLEncoder.encode(pFileName, "UTF-8");
				filename = StringUtil.replace(filename, "+", "%20");// 替换空格
			}
		} else {
			filename = pFileName;
		}
		return filename;
	}
	/**
	 * 返回附件类型
	 * @param sourceFile
	 * @return Description: Date: 2014年12月3日 Time: 下午3:48:22
	 * @author chen.qi
	 */
	public static int getFileType(File sourceFile) {
		if (sourceFile != null) {
			// 视频
			String[] vidioSuffixArray = VIDIO_SUFFIX.split(",");
			for (int i = 0; i < vidioSuffixArray.length; i++) {
				if (sourceFile.getPath().toLowerCase().endsWith(vidioSuffixArray[i])) {
					return TYPE_VIDIO;
				}
			}
			// office文件
			String[] officeSuffixArray = OFFICE_SUFFIX.split(",");
			for (int i = 0; i < officeSuffixArray.length; i++) {
				if (sourceFile.getPath().toLowerCase().endsWith(officeSuffixArray[i])) {
					return TYPE_OFFICE;
				}
			}
			// 图片
			String[] picSuffixArray = PIC_SUFFIX.split(",");
			for (int i = 0; i < picSuffixArray.length; i++) {
				if (sourceFile.getPath().toLowerCase().endsWith(picSuffixArray[i])) {
					return TYPE_PIC;
				}
			}
			// 音频
			String[] radioSuffixArray = RADIO_SUFFIX.split(",");
			for (int i = 0; i < radioSuffixArray.length; i++) {
				if (sourceFile.getPath().toLowerCase().endsWith(radioSuffixArray[i])) {
					return TYPE_RADIO;
				}
			}
		}
		return -1;
	}
}
