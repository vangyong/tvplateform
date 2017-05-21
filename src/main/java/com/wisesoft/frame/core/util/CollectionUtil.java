package com.wisesoft.frame.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * @ClassName: CollectionUtil
 * @description: 集合工具类
 * @author: wangyong
 * @date: 2016年4月8日 下午5:19:31
 */
public class CollectionUtil {
	/**
	 * 判断对象是否为空
	 * @param object
	 * @return
	 */
	public static boolean isEmpty(Object object) {
		if (String.class.isInstance(object)) {
			String string = (String) object;
			return string == null ? true : string.trim().length() == 0;
		}
		if (Collection.class.isInstance(object)) {
			Collection col = (Collection) object;
			return col == null ? true : col.isEmpty();
		}
		if (Map.class.isInstance(object)) {
			Map map = (Map) object;
			return map == null ? true : map.isEmpty();
		}
		if (Vector.class.isInstance(object)) {
			Vector vector = (Vector) object;
			return vector == null ? true : vector.size() == 0;
		}
		if (Object[].class.isInstance(object)) {
			Object[] obj = (Object[]) object;
			return obj == null ? true : obj.length == 0;
		}
		return object == null;
	}
	public static boolean isNotEmpty(Object object) {
		return !isEmpty(object);
	}
	/**
	 * @title: getCount
	 * @description: 算整型数组中元素和
	 * @return: int
	 */
	public static int getCount(int[] c) {
		int count = 0;
		if (c != null) {
			for (int i = 0; i < c.length; i++) {
				count += c[i];
			}
		}
		return count;
	}
	/**
	 * @title: removeDuplication
	 * @description: 去掉list集合中的重复对象
	 * @return: List
	 */
	public static List removeDuplication(List list) {
		Set set = new HashSet();
		set.addAll(list);
		list.clear();
		return new ArrayList(set);
	}
	/**
	 * @title: sortByValue
	 * @description: 对map按照值进行排序
	 * @return: Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map sortByValue(Map map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) o1).getValue()).compareTo(((Map.Entry) o2).getValue());
			}
		});
		Map result = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	/**
	 * @title: sortByValue
	 * @description: 对map按照值进行排序
	 * @return: Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map sortByValue(Map map, final boolean reverse) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				if (reverse) {
					return -((Comparable) ((Map.Entry) o1).getValue()).compareTo(((Map.Entry) o2).getValue());
				}
				return ((Comparable) ((Map.Entry) o1).getValue()).compareTo(((Map.Entry) o2).getValue());
			}
		});
		Map result = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	/**
	 * @title: sortByValue
	 * @description: 对map进行排序,传入Comparator,规定map的key按照何种规则排序
	 * @return: Map<K,V>
	 */
	public static <K, V> Map<K, V> sortByValue(Map<K, V> map, Comparator<K> comparator) {
		List<K> list = new LinkedList<K>(map.keySet());
		Collections.sort(list, comparator);
		Map<K, V> result = new LinkedHashMap<K, V>();
		for (int i = 0, len = list.size(); i < len; i++) {
			K key = list.get(i);
			V value = map.get(key);
			result.put(key, value);
		}
		return result;
	}
}
