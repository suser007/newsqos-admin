package com.suser.mapper;

import com.suser.entity.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassesMapper {
    /**班级信息查询**/
    List<Classes> getList(Classes classes);
    /***通过ksh写入学号 班号**/
    void divisionClasses(
            @Param("ksh") String ksh,
            @Param("studentNum") String studentNum,
            @Param("classesNum") String classesNum);
    void delectClasses();
}
