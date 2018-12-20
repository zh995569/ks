package com.ruoyi.web.controller.kashen;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.kashen.domain.ALARM_RECORD;
import com.ruoyi.kashen.domain.CAR_REGISTER;
import com.ruoyi.kashen.service.IAlarm_recordService;
import com.ruoyi.kashen.service.ICar_registerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 报警记录
 * @ClassName Alarm_recordController
 * @Author Chansey
 * @Date 2018/12/6 15:19
 * Version 1.0
 */
@Controller
@RequestMapping("/kashen/alarm_record")
public class Alarm_recordController extends BaseController{
    private String prefix = "kashen/alarm_record";

    @Autowired
    private IAlarm_recordService alarm_recordService;

    @RequiresPermissions("kashen:alarm_record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/alarm_record";
    }

    /**
     * 查询报警记录列表
     */
    @RequiresPermissions("kashen:alarm_record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ALARM_RECORD alarm_record)
    {
        startPage();
        List<ALARM_RECORD> list = alarm_recordService.selectList(alarm_record);
        return getDataTable(list);
    }


    /**
     * 导出报警记录列表
     */
    @RequiresPermissions("kashen:alarm_record:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ALARM_RECORD alarm_record)
    {
        List<ALARM_RECORD> list = alarm_recordService.selectList(alarm_record);
        ExcelUtil<ALARM_RECORD> util = new ExcelUtil<ALARM_RECORD>(ALARM_RECORD.class);
        return util.exportExcel(list, "ALARM_RECORD");
    }

    /**
     * 新增报警记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报警记录
     */
    @RequiresPermissions("kashen:alarm_record:add")
    @Log(title = "报警记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ALARM_RECORD alarm_record)
    {
        alarm_record.setGUID(this.get32UUID());
        return toAjax(alarm_recordService.insert(alarm_record));
    }

    /**
     * 修改报警记录
     */
    @GetMapping("/edit/{guid}")
    public String edit(@PathVariable("guid") String guid, ModelMap mmap)
    {
        ALARM_RECORD alarm_record = alarm_recordService.selectById(guid);
        mmap.put("alarm_record", alarm_record);
        return prefix + "/edit";
    }

    /**
     * 修改保存报警记录
     */
    @RequiresPermissions("kashen:alarm_record:edit")
    @Log(title = "报警记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ALARM_RECORD alarm_record)
    {
        return toAjax(alarm_recordService.update(alarm_record));
    }

    /**
     * 删除报警记录
     */
    @RequiresPermissions("kashen:alarm_record:remove")
    @Log(title = "报警记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(alarm_recordService.deleteByIds(ids));
    }

}
