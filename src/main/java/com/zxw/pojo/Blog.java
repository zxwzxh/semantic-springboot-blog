package com.zxw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 博客实体类
 * @author zxw
 * @create 2020-12-24 15:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_blog")
public class Blog {
    /**
     * 博客ID
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 博客标题
     */
    private String title;
    /**
     * 博客内容
     */
    private String content;
    /**
     * 首图地址
     */
    private String firstPicture;
    /**
     * 博客标记：原创、转载等
     */
    private String flag;
    /**
     * 博客浏览次数
     */
    private Integer visitCount;
    /**
     * 博客是否开启赞赏功能
     */
    private Boolean appreciate;
    /**
     * 博客是否可以转载
     */
    private Boolean shareStatus;
    /**
     * 博客是否开启评论功能
     */
    private Boolean commentable;
    /**
     * 博客是否发布
     */
    private Boolean published;
    /**
     * 是否推荐
     */
    private Boolean recommend;
    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

}
