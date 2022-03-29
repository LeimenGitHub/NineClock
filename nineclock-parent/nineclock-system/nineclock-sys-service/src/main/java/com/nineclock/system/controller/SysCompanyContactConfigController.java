package com.nineclock.system.controller;


import com.nineclock.common.entity.Result;
import com.nineclock.system.dto.SysCompanyContactConfigDTO;
import com.nineclock.system.service.SysCompanyContactConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companyContact")
@Api(value = "企业通讯录字段配置管理", tags = "企业通讯录", description = "企业通讯录字段配置管理")
public class SysCompanyContactConfigController {


    @Autowired
    private SysCompanyContactConfigService sysCompanyContactConfigService;

    @PostMapping("/config")
    @ApiOperation("添加字段")
    public Result addCompanyContactConfig(@RequestBody SysCompanyContactConfigDTO sysCompanyContactConfigDTO){
         sysCompanyContactConfigService.addCompanyContactConfig(sysCompanyContactConfigDTO);
         return Result.success();
    }

    @GetMapping("/config")
    @ApiOperation("查询并初始化企业通讯录字段")
    public Result<List<SysCompanyContactConfigDTO>> queryCompanyContactConfig(){
        List<SysCompanyContactConfigDTO> configDTOS =  sysCompanyContactConfigService.queryCompanyContactConfig();
        return Result.success(configDTOS);
    }

    @PutMapping("/config/{id}/{status}")
    @ApiOperation("企业通讯录修改字段")
    public Result updateCompanyContactConfig(@PathVariable("id") Long id ,@PathVariable("status") Short status ){
        sysCompanyContactConfigService.updateCompanyContactConfig(id,status);
        return Result.success();
    }

    @DeleteMapping("/config/{id}")
    public Result deleteCompanyContactConfig(@PathVariable("id") Long id){
        sysCompanyContactConfigService.deleteCompanyContactConfig(id);
        return Result.success();
    }

}
