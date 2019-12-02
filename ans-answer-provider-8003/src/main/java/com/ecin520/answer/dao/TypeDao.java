package com.ecin520.answer.dao;

import com.ecin520.api.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 9:53
 */
@Mapper
public interface TypeDao {
    /**
     * 插入题目类型
     * @param type 类型信息
     * @return Booelan
     * */
    Boolean insertType(Type type);

    /**
     * 更新类型
     * @param type 类型信息
     * @return Booelan
     * */
    Boolean updateType(Type type);

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
