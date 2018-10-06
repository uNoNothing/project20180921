package com.unonothing.common.utils;

import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;

public class CompareDTOs {

    public static ArrayList compare(Object oldDTO, Object newDTO) {
        if (oldDTO.getClass() != newDTO.getClass()) {
            throw ExceptionFactory.create(ExceptionType.INTERNAL_SERVER_ERROR, "The DTOs must be from the same Class");
        }

        ArrayList changedParameterList = new ArrayList();

        final BeanWrapper oldBean = new BeanWrapperImpl(oldDTO);
        final BeanWrapper newBean = new BeanWrapperImpl(newDTO);

        PropertyDescriptor propertyDescriptor[] = oldBean.getPropertyDescriptors();

        for (PropertyDescriptor descriptor : propertyDescriptor) {

//            System.out.println("descriptionName: " + descriptor.getName());

            if (!descriptor.getName().equalsIgnoreCase("version")) {
                Object oldValue = oldBean.getPropertyValue(descriptor.getName());
                Object newValue = newBean.getPropertyValue(descriptor.getName());

                if (oldValue != newValue) {
                    if (((oldValue != null) && !oldValue.equals(newValue))
                            || ((newValue != null) && !newValue.equals(oldValue))) {
                        changedParameterList.add(descriptor.getName());
                    }
                }
            }
        }
        return changedParameterList;
    }
}