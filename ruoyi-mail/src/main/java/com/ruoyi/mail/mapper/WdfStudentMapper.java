package com.ruoyi.mail.mapper;

import java.util.List;
import com.ruoyi.mail.domain.WdfStudent;

/**
 * 学生列表Mapper接口
 * 
 * @author wendanfeng
 * @date 2020-09-25
 */
public interface WdfStudentMapper 
{
    /**
     * 查询学生列表
     * 
     * @param studentId 学生列表ID
     * @return 学生列表
     */
    public WdfStudent selectWdfStudentById(Long studentId);

    /**
     * 查询学生列表列表
     * 
     * @param wdfStudent 学生列表
     * @return 学生列表集合
     */
    public List<WdfStudent> selectWdfStudentList(WdfStudent wdfStudent);

    /**
     * 新增学生列表
     * 
     * @param wdfStudent 学生列表
     * @return 结果
     */
    public int insertWdfStudent(WdfStudent wdfStudent);

    /**
     * 修改学生列表
     * 
     * @param wdfStudent 学生列表
     * @return 结果
     */
    public int updateWdfStudent(WdfStudent wdfStudent);

    /**
     * 删除学生列表
     * 
     * @param studentId 学生列表ID
     * @return 结果
     */
    public int deleteWdfStudentById(Long studentId);

    /**
     * 批量删除学生列表
     * 
     * @param studentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteWdfStudentByIds(String[] studentIds);
}
