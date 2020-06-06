package com.suser.service;

import com.suser.entity.Admission;
import com.suser.entity.Classes;
import com.suser.entity.ResourceInfo;
import com.suser.mapper.AdmissionMapper;
import com.suser.mapper.ClassesMapper;
import com.suser.mapper.DivisionMapper;
import com.suser.mapper.ResourceInfoMapper;
import com.suser.pojo.ClassesPojo;
import com.suser.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private AdmissionMapper admissionMapper;
    @Autowired
    private DivisionMapper divisionMapper;
    @Autowired
    private ResourceInfoMapper resourceInfoMapper;

    public List<ClassesPojo> getClassesInfo(ClassesPojo classesPojo){
        Classes classes = new Classes(classesPojo);
        List<Classes> classesList = classesMapper.getList(classes);
        ResourceInfo resourceInfo = new ResourceInfo();
        resourceInfo.setKsh(classesPojo.getKsh());
        resourceInfo.setAdmissioncode(admissionMapper.getCode(classesPojo.getAdmission()));
        List<ResourceInfo> resourceInfoList = resourceInfoMapper.getList(resourceInfo);
        List<ClassesPojo> classesPojoList = new ArrayList<>();
        for (int i = 0; i < resourceInfoList.size(); i++) {
            String ksh = resourceInfoList.get(i).getKsh();
            String name = resourceInfoList.get(i).getName();
            String sex = resourceInfoList.get(i).getSex();
            String jg = resourceInfoList.get(i).getJg();
            String admissionCode = resourceInfoList.get(i).getAdmissioncode();
            String admissionName = admissionMapper.getAdmission(admissionCode);
            String divisionName = divisionMapper.getDivisionName(admissionCode);
            String hasReports = resourceInfoList.get(i).getHasreports();
            String homePhoto = resourceInfoList.get(i).getHomephoto();
            String studentNum = "";
            String classesNum = "";
            for (int j = 0; j < classesList.size(); j++) {
                String b = classesList.get(j).getKsh();
                if(ksh.equals(b)){
                    studentNum = classesList.get(j).getStudentNum();
                    classesNum = classesList.get(j).getClassesNum();
                }
            }
            ClassesPojo classesPojo1 = new  ClassesPojo(ksh,studentNum,name,sex,jg,admissionName,divisionName,classesNum,hasReports,homePhoto);
            classesPojoList.add(classesPojo1);
        }
        return classesPojoList;
    }
    /***一键分班*/
    public void divideClasses(){
        //清除所有分班信息
        classesMapper.delectClasses();
        List<Admission> admissionsList = admissionMapper.getList(new Admission());
        Iterator it = admissionsList.iterator();
        while (it.hasNext()){
            Admission admission = (Admission) it.next();
            ResourceInfo resourceInfo = new ResourceInfo();
            resourceInfo.setAdmissioncode(admission.getAdmissioncode());
            List<ResourceInfo> resourceInfoListAll = resourceInfoMapper.getList(resourceInfo); //某专业学生集合 成绩顺序排列
            int length = resourceInfoListAll.size();
            int num = length/9 + 1;//几个班  一个班最多9人，不够9人算一个班
            for (int i = 0; i < resourceInfoListAll.size(); i++) {
                String classes = StringUtil.getClassesNum(String.valueOf(i%num +1)); //班号 两位数
                //学号 “2020” + 6位专业代码 + 2位班级号 + 4位序号  14位数字
                String stuId = String.valueOf(resourceInfoListAll.get(i).getGrade().toCharArray()[2])+String.valueOf(resourceInfoListAll.get(i).getGrade().toCharArray()[3])+
                        resourceInfoListAll.get(i).getAdmissioncode()+
                        classes+
                        StringUtil.getStudentNum(String.valueOf(i/num+1));
                classesMapper.divisionClasses(resourceInfoListAll.get(i).getKsh(),stuId,classes);
            }
        }
    }
}
