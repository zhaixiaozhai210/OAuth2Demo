package com.example.resource.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * `id` bigint(20) NOT NULL AUTO_INCREMENT,
 * `category_id` bigint(20) NOT NULL COMMENT '内容类目ID',
 * `title` varchar(200) DEFAULT NULL COMMENT '内容标题',
 * `sub_title` varchar(100) DEFAULT NULL COMMENT '子标题',
 * `title_desc` varchar(500) DEFAULT NULL COMMENT '标题描述',
 * `url` varchar(500) DEFAULT NULL COMMENT '链接',
 * `pic` varchar(300) DEFAULT NULL COMMENT '图片绝对路径',
 * `pic2` varchar(300) DEFAULT NULL COMMENT '图片2',
 * `content` text COMMENT '内容',
 * `created` datetime DEFAULT NULL,
 * `updated` datetime DEFAULT NULL,
 */
@Entity
@Table(name = "tb_content")
public class Content implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32, name = "id")
    private String id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private ContentCategory contentCategory;

    @Column(length = 200, name = "title")
    private String title;

    @Column(length = 100, name = "sub_title")
    private String subTitle;

    @Column(length = 500, name = "title_desc")
    private String titleDesc;

    @Column(length = 500, name = "url")
    private String url;

    @Column(length = 500, name = "pic")
    private String pic;

    @Column(length = 500, name = "pic2")
    private String pic2;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitleDesc() {
        return titleDesc;
    }

    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public ContentCategory getContentCategory() {
        return contentCategory;
    }

    public void setContentCategory(ContentCategory contentCategory) {
        this.contentCategory = contentCategory;
    }

    public Content(ContentCategory contentCategory, String title, String subTitle, String titleDesc,
                   String url, String pic, String pic2, String content, Date createTime, Date updateTime) {
        this.contentCategory = contentCategory;
        this.title = title;
        this.subTitle = subTitle;
        this.titleDesc = titleDesc;
        this.url = url;
        this.pic = pic;
        this.pic2 = pic2;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Content() {
    }
}
