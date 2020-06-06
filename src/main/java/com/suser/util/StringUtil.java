package com.suser.util;

public class StringUtil {
    public static String getClassesNum(String num){
        int length = num.length();
        switch (length){
            case 1: return "0"+num;
            case 2: return num;
        }
        return "";
    }
    public static String getStudentNum(String num){
        int length = num.length();
        switch (length){
            case 1: return "000"+num;
            case 2: return "00"+num;
            case 3: return "0"+num;
            case 4: return num;
        }
        return "";
    }
}
