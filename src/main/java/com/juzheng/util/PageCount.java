package com.juzheng.util;

import com.juzheng.entity.code.Page;

public class PageCount {
	/**
	 * 数据分页
	 * 
	 * @param startIndex
	 * @param pageSize
	 * @param orgList
	 * @return
	 */
	public Page<Object> getPage(Integer startIndex, Integer pageSize,Integer count, Object list) {
		Page<Object> page = new Page<Object>(count);
		
		page.setList(list);
		page.setStart(startIndex);
		page.setPageSize(pageSize);
		if (count % pageSize == 0) {
			page.setTotalPages(count / pageSize);
		} else {
			page.setTotalPages(count / pageSize + 1);
		}
		if ((startIndex + 1) % pageSize == 0) {
			page.setPageNo((startIndex + 1) / pageSize);
		} else {
			page.setPageNo((startIndex + 1) / pageSize + 1);
		}
		return page;
	}
}
