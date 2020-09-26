package com.ruoyi;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.mail.domain.WdfStudent;
import com.ruoyi.mail.service.IWdfStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生列表Controller
 * 
 * @author wendanfeng
 * @date 2020-09-25
 */
@Controller
@RequestMapping("/mail/stu")
public class WdfStudentController extends BaseController
{
    private String prefix = "mail/stu";

    @Autowired
    private IWdfStudentService wdfStudentService;

    @RequiresPermissions("mail:stu:view")
    @GetMapping()
    public String stu()
    {
        return prefix + "/stu";
    }

    /**
     * 查询学生列表列表
     */
    @RequiresPermissions("mail:stu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WdfStudent wdfStudent)
    {
        startPage();
        List<WdfStudent> list = wdfStudentService.selectWdfStudentList(wdfStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生列表列表
     */
    @RequiresPermissions("mail:stu:export")
    @Log(title = "学生列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WdfStudent wdfStudent)
    {
        List<WdfStudent> list = wdfStudentService.selectWdfStudentList(wdfStudent);
        ExcelUtil<WdfStudent> util = new ExcelUtil<WdfStudent>(WdfStudent.class);
        return util.exportExcel(list, "stu");
    }

    /**
     * 新增学生列表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生列表
     */
    @RequiresPermissions("mail:stu:add")
    @Log(title = "学生列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WdfStudent wdfStudent)
    {
        return toAjax(wdfStudentService.insertWdfStudent(wdfStudent));
    }

    /**
     * 修改学生列表
     */
    @GetMapping("/edit/{studentId}")
    public String edit(@PathVariable("studentId") Long studentId, ModelMap mmap)
    {
        WdfStudent wdfStudent = wdfStudentService.selectWdfStudentById(studentId);
        mmap.put("wdfStudent", wdfStudent);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生列表
     */
    @RequiresPermissions("mail:stu:edit")
    @Log(title = "学生列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WdfStudent wdfStudent)
    {
        return toAjax(wdfStudentService.updateWdfStudent(wdfStudent));
    }

    /**
     * 删除学生列表
     */
    @RequiresPermissions("mail:stu:remove")
    @Log(title = "学生列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wdfStudentService.deleteWdfStudentByIds(ids));
    }
}
