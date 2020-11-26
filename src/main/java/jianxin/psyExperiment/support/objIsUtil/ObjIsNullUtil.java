package jianxin.psyExperiment.support.objIsUtil;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjIsNullUtil {
    //返回该对象第一个为空的属性（除了id)名称:
    public static String firstNullName(Object obj) throws IllegalAccessException {
        Class<?> aClass = obj.getClass();
        Field[] fs = aClass.getDeclaredFields();
        boolean flag=true;
        String name = null;
        for (Field f : fs) {
            if(!f.getName().equals("id")) {
                f.setAccessible(true);
                Object o = f.get(obj);
                if (o == null) {
                    flag = false;
                    name = f.getName();
                    break;
                }
            }
        }
        if(flag){
            return null;
        }else{
            return name;
        }

    }
    //返回是否全为空
    public static boolean isAllFieldNull(Object obj) throws IllegalAccessException {
        Class<?> aClass = obj.getClass();
        Field[] fs = aClass.getDeclaredFields();
        boolean flag=true;
        for (Field f : fs) {
            if(!f.getName().equals("id")) {
                f.setAccessible(true);
                Object o = f.get(obj);
                if (o != null) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;

    }

}
