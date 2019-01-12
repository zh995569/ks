package com.ruoyi.web.controller.kashen;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.util.ZUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.kashen.domain.CAR_RECORD;
import com.ruoyi.kashen.domain.CAR_REGISTER;
import com.ruoyi.kashen.domain.DRIVER_REGISTER;
import com.ruoyi.kashen.service.ICar_recordService;
import com.ruoyi.kashen.service.ICar_registerService;
import com.ruoyi.kashen.service.IDriver_registerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆外出审批登记
 * @ClassName Car_recordController
 * @Author Chansey
 * @Date 2018/12/6 11:08
 * Version 1.0
 */
@Controller
@RequestMapping("/kashen/car_record")
public class Car_recordController extends BaseController{
    private String prefix = "kashen/car_record";

    @Autowired
    private ICar_recordService car_recordService;
    @Autowired
    private IDriver_registerService driver_registerService;
    @Autowired
    private ICar_registerService car_registerService;

    @RequiresPermissions("kashen:car_record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/car_record";
    }

    /**
     * 查询车辆外出审批登记列表
     */
    @RequiresPermissions("kashen:car_record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CAR_RECORD car_record)
    {
        startPage();
        List<CAR_RECORD> list = car_recordService.selectList(car_record);
        return getDataTable(list);
    }


    /**
     * 导出车辆外出审批登记列表
     */
    @RequiresPermissions("kashen:car_record:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CAR_RECORD car_record)
    {
        List<CAR_RECORD> list = car_recordService.selectList(car_record);
        ExcelUtil<CAR_RECORD> util = new ExcelUtil<CAR_RECORD>(CAR_RECORD.class);
        return util.exportExcel(list, "CAR_RECORD");
    }

    /**
     * 新增车辆外出审批登记
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("driver_registers",driver_registerService.selectList(new DRIVER_REGISTER()));
        mmap.put("car_registers",car_registerService.selectList(new CAR_REGISTER()));
        return prefix + "/add";
    }

    /**
     * 新增保存车辆外出审批登记
     */
    @RequiresPermissions("kashen:car_record:add")
    @Log(title = "车辆外出审批登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CAR_RECORD car_record)
    {
        System.out.println("save.............");
        car_record.setGUID(this.get32UUID());
        return toAjax(car_recordService.insert(car_record));
    }

    /**
     * 修改车辆外出审批登记
     */
    @GetMapping("/edit/{guid}")
    public String edit(@PathVariable("guid") String guid, ModelMap mmap)
    {
        CAR_RECORD car_record = car_recordService.selectById(guid);
        System.out.println(car_record.toString());
        mmap.put("car_record", car_record);
        //下面这个搞什么你是根据什么查询的//下拉选择的传集合到页面中
        mmap.put("driver_registers",driver_registerService.selectList(new DRIVER_REGISTER()));
        mmap.put("car_registers",car_registerService.selectList(new CAR_REGISTER()));
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆外出审批登记
     */
    @RequiresPermissions("kashen:car_record:edit")
    @Log(title = "车辆外出审批登记", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CAR_RECORD car_record)
    {
        return toAjax(car_recordService.update(car_record));
    }

    /**
     * 删除车辆外出审批登记
     */
    @RequiresPermissions("kashen:car_record:remove")
    @Log(title = "车辆外出审批登记", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(car_recordService.deleteByIds(ids));
    }

    /**
     * 查询总数量
     */
    @RequestMapping("/total")
    @ResponseBody
    public Map<String, Object> total()
    {
        Map<String,Object> map = new HashMap<>();
        Date startTime = ZUtil.calendarDate(-12);
        Date endTime = ZUtil.calendarDate(12);
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("startTime",s.format(startTime));
        map.put("endTime",s.format(endTime));

        int total = car_recordService.total();
        int todayTotal = car_recordService.todayTotal(map);
        map.put("total",total);
        map.put("todayTotal",todayTotal==0?0:todayTotal);
        return map;
    }

    /**
     * 确认审批
     */
    @RequiresPermissions("kashen:car_record:edit")
    @PostMapping("/approval/{guid}")
    @ResponseBody
    public AjaxResult approval(@PathVariable("guid") String guid)
    {
        if (car_recordService.selectById(guid)==null)
        {
            return error(1, "不存在");
        }
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(car_recordService.approval(guid));
    }
}
