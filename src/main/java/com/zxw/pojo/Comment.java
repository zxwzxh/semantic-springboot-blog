package com.zxw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 评论实体类
 * @author zxw
 * @create 2020-12-24 15:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_comment")
public class Comment {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
}
