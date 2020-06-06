package com.suser.mapper;

import com.suser.entity.ResourceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceInfoMapper {
    /**生源信息只提供查询接口**/
    List<ResourceInfo> getList(ResourceInfo info);

    /**根據信息 學部信息 獲取學生*/
    List<ResourceInfo> getListByDivision(
            @Param("ksh") String a,
            @Param("name") String b,
            @Param("idcard") String c,
            @Param("sex") String d,
            @Param("zzmm") String e,
            @Param("byzx") String f,
            @Param("bylb") String g,
            @Param("zcmc") String h,
            @Param("jg") String i,
            @Param("homeaddress") String j,
            @Param("code") String k,
            @Param("rewards") String l,
            @Param("results") String m,
            @Param("admissioncode") String n,
            @Param("schoolisfirst") String o,
            @Param("professionalisfirst") String p,
            @Param("schooling") String q,
            @Param("grade") String r,
            @Param("divisioncode") String divisioncode);

    void updateAdmission(
            @Param("ksh") String ksh,
            @Param("admission") String admission);

    /***测试用的接口**/
    void addOneResource(ResourceInfo info);

    List<String> getAllKsh();
}
