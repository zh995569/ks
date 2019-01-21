package com.ruoyi.web.controller.kashen;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.kashen.domain.CAR_REGISTER;
import com.ruoyi.kashen.service.ICar_recordService;
import com.ruoyi.kashen.service.ICar_registerService;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆
 * @ClassName Car_registerController
 * @Author Chansey
 * @Date 2018/12/3 16:48
 * Version 1.0
 */
@Controller
@RequestMapping("/kashen/car_register")
public class Car_registerController extends BaseController{
    private String prefix = "kashen/car_register";

    @Autowired
    private ICar_registerService car_registerService;

    @RequiresPermissions("kashen:car_register:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/car_register";
    }

    /**
     * 查询车辆登记列表
     */
    @RequiresPermissions("kashen:car_register:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CAR_REGISTER car_register)
    {
        startPage();
        SysUser user = this.getSysUser();
        List<SysRole> roleList = user.getRoles();
        for(SysRole sysRole:roleList){
            if ("125".equals(sysRole.getRoleId().toString())){
                car_register.setCAR_SFSC(0);
            }
        }
        List<CAR_REGISTER> list = car_registerService.selectList(car_register);
        return getDataTable(list);
    }

    /**
     * 查询总数量
     */
    @RequestMapping("/total")
    @ResponseBody
    public Map<String, Object> total(CAR_REGISTER car_register)
    {
        Map<String,Object> map = new HashMap<>();
        int total = car_registerService.total();
        car_register.setCAR_CLZT("1");
        int totalCAR_CLZT = car_registerService.totalCAR_CLZT(car_register);
        map.put("total",total);
        map.put("totalCAR_CLZT",totalCAR_CLZT);
        return map;
    }


    /**
     * 导出车辆登记列表
     */
    @RequiresPermissions("kashen:car_register:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CAR_REGISTER car_register)
    {
        List<CAR_REGISTER> list = car_registerService.selectList(car_register);
        ExcelUtil<CAR_REGISTER> util = new ExcelUtil<CAR_REGISTER>(CAR_REGISTER.class);
        return util.exportExcel(list, "CAR_REGISTER");
    }

    /**
     * 新增车辆登记
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆登记
     */
    @RequiresPermissions("kashen:car_register:add")
    @Log(title = "车辆登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CAR_REGISTER car_register)
    {   car_register.setGUID(this.get32UUID());
         //car_register.setCAR_DJSJ(car_register.getCAR_DJSJ());

        //car_register.setCAR_DJSJ(new SimpleDateFormat(car_register.getCAR_DJSJ()));
        return toAjax(car_registerService.insert(car_register));
    }

    /**
     * 修改车辆登记
     */
    @GetMapping("/edit/{guid}")
    public String edit(@PathVariable("guid") String guid, ModelMap mmap)
    {
        CAR_REGISTER car_register = car_registerService.selectById(guid);
        mmap.put("car_register", car_register);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆登记
     */
    @RequiresPermissions("kashen:car_register:edit")
    @Log(title = "车辆登记", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CAR_REGISTER car_register)
    {
        return toAjax(car_registerService.update(car_register));
    }

    /**
     * 删除车辆登记
     */
    @RequiresPermissions("kashen:car_register:remove")
    @Log(title = "车辆登记", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(car_registerService.deleteByIds(ids));
    }


    @PostMapping("/downPic")
    @ResponseBody
    public Object downPic(String guid)
    {
        return null;
    }


    /**
     * 确认审批
     */
    @RequiresPermissions("kashen:car_record:edit")
    @PostMapping("/examine")
    @ResponseBody
    public AjaxResult examine(CAR_REGISTER car_register)
    {
        if (car_registerService.selectById(car_register.getGUID())==null)
        {
            return error(1, "不存在");
        }
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(car_registerService.examine(car_register));
    }

}
