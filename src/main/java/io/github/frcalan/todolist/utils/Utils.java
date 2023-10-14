package io.github.frcalan.todolist.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class Utils {

    public static void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }
    public static String[] getNullPropertyNames(Object souce) {
        final BeanWrapper src = new BeanWrapperImpl(souce);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyName = new HashSet<>();

        for(PropertyDescriptor pd : pds) {
            Object srcValues = src.getPropertyValue(pd.getName());
            if(srcValues == null) {
                emptyName.add(pd.getName());
            }
        }

        String[] result = new String[emptyName.size()];
        return emptyName.toArray(result);
    }
}
