package com.ecin520.answer.service;

import com.ecin520.api.entity.Type;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 9:56
 */
public interface TypeService {

    /**
     * 插入题目类型
     * @param type 类型信息
     * @return Booelan
     * */
    List<Type> insertType(Type type);

    /**
     * 更新类型
     * @param type 类型信息
     * @return Booelan
     * */
    List<Type> updateType(Type type);

    /**
     * 获取所有的类型
     * @return List<Type>
     * */
    List<Type> listAllType();

    /**
     * 通过类型名获取类型对象
     * @param typeName 类型名
     * @return Type
     * */
    Type getTypeByTypeName(String typeName);

}
