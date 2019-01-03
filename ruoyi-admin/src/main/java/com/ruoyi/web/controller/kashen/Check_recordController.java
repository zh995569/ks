package com.ruoyi.web.controller.kashen;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.kashen.domain.CAR_RECORD;
import com.ruoyi.kashen.domain.CAR_REGISTER;
import com.ruoyi.kashen.domain.CHECK_RECORD;
import com.ruoyi.kashen.domain.DRIVER_REGISTER;
import com.ruoyi.kashen.service.ICar_recordService;
import com.ruoyi.kashen.service.ICar_registerService;
import com.ruoyi.kashen.service.ICheck_recordService;
import com.ruoyi.kashen.service.IDriver_registerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import java.util.Base64;
import java.util.List;

/**
 * 车辆外出审批登记
 * @ClassName Check_recordController
 * @Author Chansey
 * @Date 2018/12/6 11:08
 * Version 1.0
 */
@Controller
@RequestMapping("/kashen/check_record")
public class Check_recordController extends BaseController{
    private String prefix = "kashen/check_record";

    @Autowired
    private ICheck_recordService check_recordService;
    @Autowired
    private ICar_registerService car_registerService;
    @Autowired
    private IDriver_registerService driver_registerService;

    @RequiresPermissions("kashen:check_record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/check_record";
    }

    /**
     * 查询车列表
     */
    @RequiresPermissions("kashen:check_record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CHECK_RECORD check_record)
    {
        startPage();
        List<CHECK_RECORD> list = check_recordService.selectList(check_record);
        return getDataTable(list);
    }


    /**
     * 导出列表
     */
    @RequiresPermissions("kashen:check_record:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CHECK_RECORD check_record)
    {
        List<CHECK_RECORD> list = check_recordService.selectList(check_record);
        ExcelUtil<CHECK_RECORD> util = new ExcelUtil<CHECK_RECORD>(CHECK_RECORD.class);
        return util.exportExcel(list, "CHECK_RECORD");
    }

    /**
     * 新增
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("driver_registers",driver_registerService.selectList(new DRIVER_REGISTER()));
        mmap.put("car_registers",car_registerService.selectList(new CAR_REGISTER()));
        return prefix + "/add";
    }

    /**
     * 新增保存
     */
    @RequiresPermissions("kashen:check_record:add")
    @Log(title = "打开记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CHECK_RECORD check_record)
    {
        System.out.println("save.............");
        check_record.setGUID(this.get32UUID());
        return toAjax(check_recordService.insert(check_record));
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{guid}")
    public String edit(@PathVariable("guid") String guid, ModelMap mmap)
    {
        CHECK_RECORD check_record = check_recordService.selectById(guid);

        String xcz = null;
        String driver_xcz = null;
        if(check_record.getXCZ() != null) {
            xcz = new String(check_record.getXCZ());
        }
        if(check_record.getDriver_register().getDRIVER_XCZ() != null) {
            driver_xcz = new String(check_record.getDriver_register().getDRIVER_XCZ());
        }

        mmap.put("xcz","data:image/jpg;base64,"+xcz);
        mmap.put("driver_xcz","data:image/jpg;base64,"+driver_xcz);
        mmap.put("check_record", check_record);
        mmap.put("driver_registers",driver_registerService.selectList(new DRIVER_REGISTER()));
        mmap.put("car_registers",car_registerService.selectList(new CAR_REGISTER()));
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    @RequiresPermissions("kashen:check_record:edit")
    @Log(title = "打卡记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CHECK_RECORD check_record)
    {
        return toAjax(check_recordService.update(check_record));
    }

    /**
     * 删除车辆外出审批登记
     */
    @RequiresPermissions("kashen:check_record:remove")
    @Log(title = "打卡记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(check_recordService.deleteByIds(ids));
    }
}
