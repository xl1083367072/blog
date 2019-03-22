package com.xl.utils;

//封装分页信息
public class PageBean {

//    当前页
    private Integer currPage;
//    每页显示记录数
    private Integer pageSize;
//    该页起始记录
    private Integer start;

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        return (currPage-1)*pageSize;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}
