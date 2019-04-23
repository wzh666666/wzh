package com.juzheng.entity.code;

import java.util.List;



/**
 * 分页
 * @author tonglu
 * @date 2018-01-09
 */
public class Page<T> {
	
    private int pageSize =10; //每页显示条数
    
    private int totalCount; //总条数
    
    private int start; //开始条数
    
    private int pageNo;//当前页
    
    private int totalPages; //总页数
    
    private Object list;//数据
    
    
      
    public Page(int totalCount){
        this.totalCount = totalCount;
    }
      
    /**
     * 获取下一条记录的编号
     */
    public int getCurrentPageNo(){
        return start / pageSize + 1;
    }
    /**       
     * 判断是否有吓一跳
     * @return
     */
    public boolean getHasNextPage(){
        return getCurrentPageNo() < totalPages;
    }
    /**
     * �Ƿ�����当前页是否大于1
     * @return
     */
    public boolean getHasPavPage(){
        return getCurrentPageNo() > 1;
    }
    /**
     * ��ȡ��获取中页数��
     * @return
     */
    public int getTotalPages() {
        totalPages = totalCount / pageSize;
          
        if(totalCount % pageSize != 0){
            totalPages++;
        }
          
        return totalPages;
    }
    /**
     * ��õ�设置当前页����ʼ��的开始条数
     * @param pageNo ��ǰ页数��
     * @return
     */
    public int getStart(int pageNo){
          
        if(pageNo < 1){
            pageNo = 1;
        }
        else if(getTotalPages()>0&&pageNo > getTotalPages()){
            pageNo = getTotalPages();
        }
          
        start = (pageNo-1) * pageSize;
        return start;
    }
      
    //get and set
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public void setStart(int start) {
        this.start = start;
    }
   
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
 
    public int getPageNo() {
        return pageNo;
    }
 
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

	

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getStart() {
		return start;
	}

     
    
}