package com.nineclock.system.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nineclock.common.constant.NcConstant;
import com.nineclock.common.enums.ResponseEnum;
import com.nineclock.common.utils.BeanHelper;
import com.nineclock.system.dto.SysCompanyContactConfigDTO;
import com.nineclock.system.mapper.SysCompanyContactConfigMapper;
import com.nineclock.system.pojo.SysCompanyContactConfig;
import com.nineclock.system.service.SysCompanyContactConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class SysCompanyContactConfigServiceImpl implements SysCompanyContactConfigService {

    @Autowired
    private SysCompanyContactConfigMapper sysCompanyContactConfigMapper;

    /**
     * 添加通讯录字段
     * @param sysCompanyContactConfigDTO
     */
    @Override
    public void addCompanyContactConfig(SysCompanyContactConfigDTO sysCompanyContactConfigDTO) {
        //1. 参数校验
        if (sysCompanyContactConfigDTO==null || StringUtils.isEmpty(sysCompanyContactConfigDTO.getName())){
            throw new RuntimeException(ResponseEnum.INVALID_PARAM_ERROR.getMessage());
        }
        //2. 添加字段
        SysCompanyContactConfig config = new SysCompanyContactConfig();
        Long companyId = 3L; // todo:先写定值，后续更改
        config.setName(sysCompanyContactConfigDTO.getName());
        config.setType(sysCompanyContactConfigDTO.getType());
        config.setFieldType(sysCompanyContactConfigDTO.getFieldType());
        config.setStatus((short)1);
        config.setCompanyId(companyId);
        sysCompanyContactConfigMapper.insert(config);
    }

    /**
     * 查询并初始化字段
     * @return
     */
    @Override
    public List<SysCompanyContactConfigDTO> queryCompanyContactConfig() {
        //通过公司id查询是否存在通讯录字段
        Long companyId = 1L; //todo:先写定值，后续更改
        LambdaQueryWrapper<SysCompanyContactConfig> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysCompanyContactConfig::getCompanyId,companyId);
        List<SysCompanyContactConfig> configList = sysCompanyContactConfigMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(configList)){
            configList = new ArrayList<>();
            for (String fieldName : NcConstant.COMPANY_CONFIG_CONTACT_LIST) {
                SysCompanyContactConfig config = new SysCompanyContactConfig();
                config.setName(fieldName);
                config.setType("fixed");
                config.setFieldType("string");
                config.setStatus((short)1);
                config.setCompanyId(companyId);
                sysCompanyContactConfigMapper.insert(config);
                configList.add(config);
            }
        }
        List<SysCompanyContactConfigDTO> configDTOS = BeanHelper.copyWithCollection(configList, SysCompanyContactConfigDTO.class);
        return configDTOS;
    }

    /**
     * 修改企业通讯录字段
     * @param id
     * @param status
     */
    @Override
    public void updateCompanyContactConfig(Long id, Short status) {

        if(id == null || status == null){
            throw new RuntimeException(ResponseEnum.INVALID_PARAM_ERROR.getMessage());
        }

        SysCompanyContactConfig contactConfig = sysCompanyContactConfigMapper.selectById(id);
        if (contactConfig!=null){
            contactConfig.setStatus(status);
            sysCompanyContactConfigMapper.updateById(contactConfig);
        }
    }

    /**
     * 删除企业通讯录字段
     * @param id
     */
    @Override
    public void deleteCompanyContactConfig(Long id) {
        if (id==null){
            throw new RuntimeException(ResponseEnum.INVALID_PARAM_ERROR.getMessage());
        }
        sysCompanyContactConfigMapper.deleteById(id);
    }
}
