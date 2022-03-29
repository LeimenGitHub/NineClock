package com.nineclock.system.service;

import com.nineclock.system.dto.SysCompanyContactConfigDTO;

import java.util.List;

public interface SysCompanyContactConfigService {

    //添加通讯录字段
    void addCompanyContactConfig(SysCompanyContactConfigDTO sysCompanyContactConfigDTO);

    //查询并初始化通讯录
    List<SysCompanyContactConfigDTO> queryCompanyContactConfig();

    //修改企业通讯录字段
    void updateCompanyContactConfig(Long id, Short status);

    //删除企业通讯录字段
    void deleteCompanyContactConfig(Long id);
}
