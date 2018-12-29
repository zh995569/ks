package com.ruoyi.web.controller.kashen;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.kashen.domain.DRIVER_REGISTER;
import com.ruoyi.kashen.service.IDriver_registerService;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import org.apache.commons.codec.binary.Base64;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Driver_register
 * @Author Chansey
 * @Date 2018/12/6 17:01
 * Version 1.0
 */
@Controller
@RequestMapping("/kashen/driver_register")
public class Driver_registerController extends BaseController{
    private String prefix = "kashen/driver_register";

    @Autowired
    private IDriver_registerService driver_registerService;

    @RequiresPermissions("kashen:driver_register:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/driver_register";
    }

    /**
     * 查询列表
     */
    @RequiresPermissions("kashen:driver_register:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DRIVER_REGISTER driver_register)
    {
        startPage();
        SysUser user = this.getSysUser();
        List<SysRole> roleList = user.getRoles();
        for(SysRole sysRole:roleList){
            if ("125".equals(sysRole.getRoleId().toString())){
                driver_register.setDRIVER_SCZT(0);
            }
        }
        List<DRIVER_REGISTER> list = driver_registerService.selectList(driver_register);
        return getDataTable(list);
    }


    /**
     * 导出列表
     */
    @RequiresPermissions("kashen:driver_register:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DRIVER_REGISTER driver_register)
    {
        List<DRIVER_REGISTER> list = driver_registerService.selectList(driver_register);
        ExcelUtil<DRIVER_REGISTER> util = new ExcelUtil<DRIVER_REGISTER>(DRIVER_REGISTER.class);
        return util.exportExcel(list, "DRIVER_REGISTER");
    }

    /**
     * 新增页面
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存
     */
    @RequiresPermissions("kashen:car_register:add")
    @Log(title = "车辆登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("xcz") String  xcz, DRIVER_REGISTER driver_register)
    {

        driver_register.setGUID(this.get32UUID());
        if(xcz!=null && xcz!="")
            xcz = xcz.substring(22);//去掉前缀一段data:image/png;base64,
        driver_register.setDRIVER_XCZ(xcz.getBytes());

        //car_register.setCAR_DJSJ(car_register.getCAR_DJSJ());

        //car_register.setCAR_DJSJ(new SimpleDateFormat(car_register.getCAR_DJSJ()));
        return toAjax(driver_registerService.insert(driver_register));
    }

    /**
     * 修改页面
     */
    @GetMapping("/edit/{guid}")
    public String edit(@PathVariable("guid") String guid, ModelMap mmap)
    {
        DRIVER_REGISTER driver_register = driver_registerService.selectById(guid);
        String xcz = null;
        if(driver_register.getDRIVER_XCZ()!=null)
            xcz = new String(driver_register.getDRIVER_XCZ());
        mmap.put("xcz","data:image/jpg;base64,"+xcz);
        mmap.put("driver_register", driver_register);
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    @RequiresPermissions("kashen:driver_register:edit")
    @Log(title = "驾驶员信息登记", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DRIVER_REGISTER driver_register)
    {
        return toAjax(driver_registerService.update(driver_register));
    }

    /**
     * 删除车辆登记
     */
    @RequiresPermissions("kashen:driver_register:remove")
    @Log(title = "驾驶员信息登记", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(driver_registerService.deleteByIds(ids));
    }

    /**
     * 查询总数量
     */
    @RequestMapping("/total")
    @ResponseBody
    public Map<String, Object> total(DRIVER_REGISTER driver_register)
    {
        Map<String,Object> map = new HashMap<>();
        int total = driver_registerService.total(driver_register);
        map.put("total",total);
        return map;
    }
}
