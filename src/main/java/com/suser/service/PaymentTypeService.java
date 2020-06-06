package com.suser.service;

import com.suser.entity.PaymentType;
import com.suser.mapper.PaymentTypeMapper;
import com.suser.mapper.ResourceInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeService {
    @Autowired
    private PaymentTypeMapper paymentTypeMapper;
    @Autowired
    private ResourceInfoMapper resourceInfoMapper;
    public void updateResource(){
        List<String> news = resourceInfoMapper.getAllKsh();
        PaymentType paymentType = null;
        for (int i = 0; i < news.size(); i++) {
            paymentType.setKsh(news.get(i));
            paymentType.setType("7");
            paymentType.setIssignup("3");
            paymentTypeMapper.addOnePaymentType(paymentType);
        }
    }
}
