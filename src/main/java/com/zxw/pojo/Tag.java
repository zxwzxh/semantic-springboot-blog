package com.zxw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 标签实体类
 * @author zxw
 * @create 2020-12-24 15:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_tag")
public class Tag {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 名称
     */
    private String name;

}
