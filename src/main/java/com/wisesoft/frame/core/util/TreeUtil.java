package com.wisesoft.frame.core.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeUtil {

	/**
	 * 根据父节点的ID获取所有子节点
	 * @param list 分类表
	 * @param typeId 传入的父节点ID
	 * @return String
	 */
	public List<TreeObject> getChildTreeObjects(List<TreeObject> list, String parentId) {
		List<TreeObject> returnList = new ArrayList<TreeObject>();
		for (Iterator<TreeObject> iterator = list.iterator(); iterator.hasNext();) {
			TreeObject t = (TreeObject) iterator.next();
			// 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
			if (t.getParentId().equals(parentId)) {
				recursionFn(list, t);
				returnList.add(t);
			}
		}
		return returnList;
	}
	/**
	 * 递归列表
	 * @author wangyong Email: vangyong@126.com
	 * @date 2013-12-4 下午7:27:30
	 * @param list
	 * @param TreeObject
	 */
	private void recursionFn(List<TreeObject> list, TreeObject t) {
		List<TreeObject> childList = getChildList(list, t);// 得到子节点列表
		t.setChildren(childList);
		for (TreeObject tChild : childList) {
			if (hasChild(list, tChild)) {// 判断是否有子节点
				Iterator<TreeObject> it = childList.iterator();
				while (it.hasNext()) {
					TreeObject n = (TreeObject) it.next();
					recursionFn(list, n);
				}
			}
		}
	}
	// 得到子节点列表
	private List<TreeObject> getChildList(List<TreeObject> list, TreeObject t) {
		List<TreeObject> tlist = new ArrayList<TreeObject>();
		Iterator<TreeObject> it = list.iterator();
		while (it.hasNext()) {
			TreeObject n = (TreeObject) it.next();
			if (n.getParentId().equals(t.getResId())) {
				tlist.add(n);
			}
		}
		return tlist;
	}
	// 判断是否有子节点
	private boolean hasChild(List<TreeObject> list, TreeObject t) {
		return getChildList(list, t).size() > 0 ? true : false;
	}
}
