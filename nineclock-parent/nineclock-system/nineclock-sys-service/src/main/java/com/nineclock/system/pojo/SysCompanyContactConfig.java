package com.nineclock.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_company_contact_config")  //数据库表名
public class SysCompanyContactConfig implements Serializable {

    @TableId(type = IdType.AUTO)  //自增
    private Long id; //主键
    private String name; //字段名称
    private String type; //字段类型 : fixed为固定字段(不可删除)，dynamic为动态字段(可删除)
    private String fieldType; //字段类型 -- Integer, String
    private Short status; //状态: 1为可用 0为不可用
    private Long companyId; //企业ID
}