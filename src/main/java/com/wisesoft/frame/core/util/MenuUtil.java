package com.wisesoft.frame.core.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.wisesoft.system.domain.vo.MenuVo;

public class MenuUtil {

	/**
	 * 根据父节点的ID获取所有子节点
	 * @param list 分类表
	 * @param typeId 传入的父节点ID
	 * @return String
	 */
	public List<MenuVo> getChildMenuVos(List<MenuVo> list, String parentId) {
		List<MenuVo> returnList = new ArrayList<MenuVo>();
		for (Iterator<MenuVo> iterator = list.iterator(); iterator.hasNext();) {
			MenuVo t = (MenuVo) iterator.next();
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
	private void recursionFn(List<MenuVo> list, MenuVo t) {
		List<MenuVo> childList = getChildList(list, t);// 得到子节点列表
		t.setChildren(childList);
		for (MenuVo tChild : childList) {
			if (hasChild(list, tChild)) {// 判断是否有子节点
				Iterator<MenuVo> it = childList.iterator();
				while (it.hasNext()) {
					MenuVo n = (MenuVo) it.next();
					recursionFn(list, n);
				}
			}
		}
	}
	// 得到子节点列表
	private List<MenuVo> getChildList(List<MenuVo> list, MenuVo t) {
		List<MenuVo> tlist = new ArrayList<MenuVo>();
		Iterator<MenuVo> it = list.iterator();
		while (it.hasNext()) {
			MenuVo n = (MenuVo) it.next();
			if (n.getParentId().equals(t.getId())) {
				tlist.add(n);
			}
		}
		return tlist;
	}
	// 判断是否有子节点
	private boolean hasChild(List<MenuVo> list, MenuVo t) {
		return getChildList(list, t).size() > 0 ? true : false;
	}
}
