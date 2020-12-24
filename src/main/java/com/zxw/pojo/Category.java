package com.zxw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 分类实体类
 * @author zxw
 * @create 2020-12-24 15:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_category")
public class Category {

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
