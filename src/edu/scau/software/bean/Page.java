package edu.scau.software.bean;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE = 5;

    private Integer pageNo=1;

    private Integer pageTotal = 1;

    private Integer pageSize = PAGE_SIZE;

    private Integer totalCount=0;

    private List<T> items;

    private String url;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1)
            pageNo = 1;
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        if (pageNo > pageTotal)
            pageNo = pageTotal;
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
