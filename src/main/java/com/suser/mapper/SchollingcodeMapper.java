package com.suser.mapper;

import com.suser.entity.Schollingcode;

import java.util.List;

public interface SchollingcodeMapper {
    List<Schollingcode> getList(Schollingcode info);
    void addOneSchollingcode(Schollingcode info);
}
