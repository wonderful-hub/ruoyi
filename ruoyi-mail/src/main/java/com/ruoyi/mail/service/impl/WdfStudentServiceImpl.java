package com.ruoyi.mail.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mail.mapper.WdfStudentMapper;
import com.ruoyi.mail.domain.WdfStudent;
import com.ruoyi.mail.service.IWdfStudentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生列表Service业务层处理
 * 
 * @author wendanfeng
 * @date 2020-09-25
 */
@Service
public class WdfStudentServiceImpl implements IWdfStudentService 
{
    @Autowired
    private WdfStudentMapper wdfStudentMapper;

    /**
     * 查询学生列表
     * 
     * @param studentId 学生列表ID
     * @return 学生列表
     */
    @Override
    public WdfStudent selectWdfStudentById(Long studentId)
    {
        return wdfStudentMapper.selectWdfStudentById(studentId);
    }

    /**
     * 查询学生列表列表
     * 
     * @param wdfStudent 学生列表
     * @return 学生列表
     */
    @Override
    public List<WdfStudent> selectWdfStudentList(WdfStudent wdfStudent)
    {
        return wdfStudentMapper.selectWdfStudentList(wdfStudent);
    }

    /**
     * 新增学生列表
     * 
     * @param wdfStudent 学生列表
     * @return 结果
     */
    @Override
    public int insertWdfStudent(WdfStudent wdfStudent)
    {
        return wdfStudentMapper.insertWdfStudent(wdfStudent);
    }

    /**
     * 修改学生列表
     * 
     * @param wdfStudent 学生列表
     * @return 结果
     */
    @Override
    public int updateWdfStudent(WdfStudent wdfStudent)
    {
        return wdfStudentMapper.updateWdfStudent(wdfStudent);
    }

    /**
     * 删除学生列表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWdfStudentByIds(String ids)
    {
        return wdfStudentMapper.deleteWdfStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生列表信息
     * 
     * @param studentId 学生列表ID
     * @return 结果
     */
    @Override
    public int deleteWdfStudentById(Long studentId)
    {
        return wdfStudentMapper.deleteWdfStudentById(studentId);
    }
}
