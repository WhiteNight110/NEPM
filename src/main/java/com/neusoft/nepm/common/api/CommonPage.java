package com.neusoft.nepm.common.api;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 通用的分页工具类
 * @param <T> T对象
 */
public class CommonPage<T> {
    private Integer pageNum;//当前页
    private Integer pageSize;//每页显示的记录数
    private Integer totalPage;//总页数
    private Long total;//总行数
    private List<T> list;//分页查询的部分数据

    /**
     * 封装分页的信息 PageHelper中提供的PageInfo对象
     * 将查询到的list集合转为PageInfo分页的信息
     * @param <T>
     * @return
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> commonPage = new CommonPage<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        //要将PageInfo得到的分页的信息赋值给以上属性
        commonPage.setTotalPage(pageInfo.getPages());
        commonPage.setPageNum(pageInfo.getPageNum());
        commonPage.setPageSize(pageInfo.getPageSize());
        commonPage.setTotal(pageInfo.getTotal());
        commonPage.setList(pageInfo.getList());
        return commonPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
