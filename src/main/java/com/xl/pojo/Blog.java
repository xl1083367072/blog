package com.xl.pojo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Blog {
    private Integer id;

    private String title;

    private String summary;

    private Date release_date;

    private Integer click_hit;

    private Integer reply_hit;

    private Integer type_id;

    private String key_word;

    private Date create_time;

    private Date update_time;

    private String content;

    //博客类型
    private BlogType blogType;

    //博客数量 非博客实际属性，主要是 根据发布日期归档查询博客数量用
    private Integer blogCount;

    //发布日期字符串 只取年和月
    private String releaseDateStr;

    //博客里存在的图片 主要用于前端列表展示显示缩略图
    private List<String> imagesList=new LinkedList<String>();

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    public String getReleaseDateStr() {
        return releaseDateStr;
    }

    public void setReleaseDateStr(String releaseDateStr) {
        this.releaseDateStr = releaseDateStr;
    }

    public List<String> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Integer getClick_hit() {
        return click_hit;
    }

    public void setClick_hit(Integer click_hit) {
        this.click_hit = click_hit;
    }

    public Integer getReply_hit() {
        return reply_hit;
    }

    public void setReply_hit(Integer reply_hit) {
        this.reply_hit = reply_hit;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getKey_word() {
        return key_word;
    }

    public void setKey_word(String key_word) {
        this.key_word = key_word == null ? null : key_word.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}