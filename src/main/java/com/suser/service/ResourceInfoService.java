package com.suser.service;

import com.suser.entity.ResourceInfo;
import com.suser.mapper.AdmissionMapper;
import com.suser.mapper.DivisionMapper;
import com.suser.mapper.ResourceInfoMapper;
import com.suser.pojo.ResourceInfoPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ResourceInfoService {
    @Autowired
    private ResourceInfoMapper resourceInfoMapper;
    @Autowired
    private AdmissionMapper admissionMapper;
    @Autowired
    private DivisionMapper divisionMapper;

    /***
     * 1.解析专业代码
     * 2.添加 ‘学部’ 字段值
     * */
    public List<ResourceInfoPojo> getList(ResourceInfoPojo pojo){
        /*** entity <= pojo **/
        String divisionCodeFromNameInPojo = divisionMapper.getDivisionCode(pojo.getDivision());
        String admissionCodeFromNameInPojo = admissionMapper.getCode(pojo.getAdmission());
        ResourceInfo info = new ResourceInfo(pojo,admissionCodeFromNameInPojo);
        /*********************/

        /**獲取值！！！**/
        List<ResourceInfo> list = new ArrayList<>();
        if(divisionCodeFromNameInPojo == "" || divisionCodeFromNameInPojo == null){
            list = resourceInfoMapper.getList(info);
        }else {
            list = resourceInfoMapper.getListByDivision(
                    info.getKsh(),
                    info.getName(),
                    info.getIdcard(),
                    info.getSex(),
                    info.getZzmm(),
                    info.getByzx(),
                    info.getBylb(),
                    info.getZcmc(),
                    info.getJg(),
                    info.getHomeaddress(),
                    info.getCode(),
                    info.getRewards(),
                    info.getResults(),
                    info.getAdmissioncode(),
                    info.getSchoolisfirst(),
                    info.getProfessionalisfirst(),
                    info.getSchooling(),
                    info.getGrade(),
                    divisionCodeFromNameInPojo);
        }


        /*** entity => pojo **/
        List<ResourceInfoPojo> listPojo = new ArrayList<ResourceInfoPojo>();
        Iterator tor = list.iterator();
        while (tor.hasNext()){
            ResourceInfo _this = (ResourceInfo) tor.next();
            String admissionNameFromDb = admissionMapper.getAdmission(_this.getAdmissioncode());
            String divisionNameFromDb = divisionMapper.getDivisionName(_this.getAdmissioncode());
            listPojo.add(new ResourceInfoPojo(_this,admissionNameFromDb,divisionNameFromDb));
        }
        return listPojo;
    }

    public void updateAdmission(String ksh,String admission){
        String code = admissionMapper.getCode(admission);
        resourceInfoMapper.updateAdmission(ksh, code);
    }

    private void addOneResource(ResourceInfo info){
        resourceInfoMapper.addOneResource(info);
    }
}
