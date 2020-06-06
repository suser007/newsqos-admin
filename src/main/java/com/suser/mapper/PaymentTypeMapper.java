package com.suser.mapper;

import com.suser.entity.PaymentType;

import java.util.List;

public interface PaymentTypeMapper {
    List<PaymentType> getList(PaymentType info);
    int setValue(PaymentType info);
    void addOnePaymentType(PaymentType info);
}
