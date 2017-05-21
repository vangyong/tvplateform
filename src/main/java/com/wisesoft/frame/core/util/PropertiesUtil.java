package com.wisesoft.frame.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	/**
	 * 如果Key不存在返回defaultValue反之返回Key的对应value
	 * 
	 * @param props
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getString(Properties props, String key,
			String defaultValue) {
		String value = props.getProperty(key);
		if (StringUtil.isEmpty(value)) {
			return defaultValue;
		}
		return value;
	}

	/**
	 *采用Properties类取得属性文件对应值
	 * 
	 * @param propertiesFileName
	 *            全路径
	 *@param propertyName
	 *            属性名
	 *@return 根据属性名得到的属性值，如没有返回""
	 * @throws FileNotFoundException 
	 */
	public static String getValueByPropertyName(String propertiesFileName,
			String propertyName) throws FileNotFoundException {
		
		return getValueByPropertyName(new FileInputStream(propertiesFileName), propertyName);
	}
	
	/**
	 * 获得属性文件key对应的
	 * @param is 
	 * @param propertyName 
	 * @return
	 */
	public static String getValueByPropertyName(InputStream is, String propertyName) {
		return getValueByPropertyName(is, propertyName, true);
	}
	
	/**
	 * 获得属性文件key对应的
	 * @param is
	 * @param propertyName
	 * @param closeStream 读取之后是否关闭流
	 * @return
	 */
	public static String getValueByPropertyName(InputStream is, String propertyName, boolean closeStream) {
		String s = "";
		Properties p = new Properties();
		try {
			p.load(is);
			if(closeStream){
				is.close();
			}
			s = p.getProperty(propertyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 调用getValueByResource方法读取 取propertiesFileName文件中名为propertyName的value
	 * 
	 * @param propertiesFileName
	 * @param propertyName
	 * @return
	 */
	public static String getValueByResource(String propertiesFileName,
			String propertyName) {
		return getValueByResource(propertiesFileName, propertyName, "");
	}

	/**
	 * 通过ResourceUtil.getResourceAsStream读
	 * 取propertiesFileName文件中名为propertyName的value
	 * 
	 * @param propertiesFileName
	 * @param propertyName
	 * @param defaultValue
	 * @return
	 */
	public static String getValueByResource(String propertiesFileName,
			String propertyName, String defaultValue) {
		String s = defaultValue;
		Properties p = new Properties();
		try {
			InputStream in = ResourceUtil
					.getResourceAsStream(propertiesFileName);
			p.load(in);
			in.close();
			s = p.getProperty(propertyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 通过FileInputStream读 取propertiesFileName文件中名为propertyName的value
	 * 
	 * @param propertiesFileName
	 * @param propertyName
	 * @param defaultValue
	 * @return
	 */
	public static String getValueByPropertyName(String propertiesFileName,
			String propertyName, String defaultValue) {
		String s = defaultValue;
		Properties p = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream(propertiesFileName);
			p.load(in);
			in.close();
			s = p.getProperty(propertyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 *  Description: 获取属性文件Properties对象
	 *  @author zhang.wen 2014-7-17 下午6:01:35
	 */
	public static Properties getProperties(InputStream is) {
		Properties p = new Properties();
		try {
			p.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 *更改属性文件的值，如果对应的属性不存在，则自动增加该属性
	 * 
	 * @param propertiesFileDir
	 *            目录路径
	 *@param propertiesFileName
	 *            文件名
	 *@param propertyName属性名
	 *@param propertyValue将属性名更改成该属性值
	 *@return 是否操作成功
	 */
	public static boolean changeValueByPropertyName(String propertiesFileDir,
			String propertiesFileName, String propertyName, String propertyValue) {
		boolean writeOK = true;
		Properties p = new Properties();
		File file = new File(propertiesFileDir, propertiesFileName);
		if (!file.exists()) {
			try {
				FileUtil.createNewFile(file);
			} catch (IOException e) {
				writeOK = false;
				e.printStackTrace();
			}
		}
		FileInputStream in;
		try {
			in = new FileInputStream(file);
			p.load(in);
			in.close();
			p.setProperty(propertyName, propertyValue);
			FileOutputStream out = new FileOutputStream(file);
			p.store(out, "");// 设置属性头
			out.flush();
			out.close();
		} catch (Exception e) {
			writeOK = false;
			e.printStackTrace();
		}
		return writeOK;
	}

	// /**
	// * Take an array Strings and split each element based on the given
	// delimiter.
	// * A <code>Properties</code> instance is then generated, with the left of
	// the
	// * delimiter providing the key, and the right of the delimiter providing
	// the value.
	// * <p>Will trim both the key and value before adding them to the
	// * <code>Properties</code> instance.
	// * @param array the array to process
	// * @param delimiter to split each element using (typically the equals
	// symbol)
	// * @return a <code>Properties</code> instance representing the array
	// contents,
	// * or <code>null</code> if the array to process was null or empty
	// */
	// public static Properties splitArrayElementsIntoProperties(String[] array,
	// String delimiter) {
	// return splitArrayElementsIntoProperties(array, delimiter, null);
	// }
	//
	// /**
	// * Take an array Strings and split each element based on the given
	// delimiter.
	// * A <code>Properties</code> instance is then generated, with the left of
	// the
	// * delimiter providing the key, and the right of the delimiter providing
	// the value.
	// * <p>Will trim both the key and value before adding them to the
	// * <code>Properties</code> instance.
	// * @param array the array to process
	// * @param delimiter to split each element using (typically the equals
	// symbol)
	// * @param charsToDelete one or more characters to remove from each element
	// * prior to attempting the split operation (typically the quotation mark
	// * symbol), or <code>null</code> if no removal should occur
	// * @return a <code>Properties</code> instance representing the array
	// contents,
	// * or <code>null</code> if the array to process was <code>null</code> or
	// empty
	// */
	// public static Properties splitArrayElementsIntoProperties(
	// String[] array, String delimiter, String charsToDelete) {
	//
	// if (CollectionUtil.isEmpty(array)) {
	// return null;
	// }
	// Properties result = new Properties();
	// for (int i = 0; i < array.length; i++) {
	// String element = array[i];
	// if (charsToDelete != null) {
	// element = deleteAny(array[i], charsToDelete);
	// }
	// String[] splittedElement = split(element, delimiter);
	// if (splittedElement == null) {
	// continue;
	// }
	// result.setProperty(splittedElement[0].trim(), splittedElement[1].trim());
	// }
	// return result;
	// }

	public static void main(String[] args) {
		changeValueByPropertyName("c:\\test", "test.properties", "DBLocation",
				"2222222");
	}

}
