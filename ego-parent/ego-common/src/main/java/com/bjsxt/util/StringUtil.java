package com.bjsxt.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	/**
	 * 将字符转化为list
	 * @param ids
	 * @return
	 */
	public static List<Integer> Str2List(String ids){
		List<Integer> values = new ArrayList<Integer>();
		if(ids != null && ids.trim().length()!=0) {
			String[] idsStr =  ids.split(",");
			if(idsStr!=null && idsStr.length!=0) {
				for (String idstr : idsStr) {
					Integer id = Integer.parseInt(idstr.trim());
					values.add(id);
				}
			}
		}
		return values;
	}
	/**
	 * 将逗号形式的字符串转换为List
	 */
	public static List<Long> str2ListLong(String ids){
		List<Long> idList=new ArrayList<>();
		if(ids!=null && ids.trim().length()>0) {
			String idArray[] = ids.split(",");
			if(idArray!=null && idArray.length>0) {
				for(String idStr:idArray) {
					Long id = Long.parseLong(idStr.trim());
					idList.add(id);
				}
			}
		}
		return idList;
	}
	
}
