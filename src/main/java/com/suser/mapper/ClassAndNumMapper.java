package com.suser.mapper;

import com.suser.entity.ClassAndNum;

import java.util.List;

public interface ClassAndNumMapper {

    List<ClassAndNum> getList(ClassAndNum obj);

    void addOneClassAndNum(ClassAndNum obj);
}
