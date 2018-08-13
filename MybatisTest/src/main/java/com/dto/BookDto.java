package com.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by C.A.O on 2018/8/10.
 * 图书实体
 */
public class BookDto {
    /**
     * 编号
     */
    private int id;
    /**
     * 书名
     */
    private String title;
    /**
     * 价格
     */
    private double price;
    /**
     * 出版日期
     */
    private Date publishDate;

    private List<Integer> idList;

    public BookDto(int id, String title, double price, Date publishDate,List<Integer> idList) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.publishDate = publishDate;
        this.idList = idList;
    }

    public BookDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}
