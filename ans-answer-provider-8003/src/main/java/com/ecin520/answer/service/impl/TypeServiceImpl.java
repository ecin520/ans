package com.ecin520.answer.service.impl;

import com.ecin520.answer.dao.TypeDao;
import com.ecin520.answer.service.TypeService;
import com.ecin520.api.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 9:58
 */
@Service
public class TypeServiceImpl implements TypeService {

    private final TypeDao typeDao;

    @Autowired
    public TypeServiceImpl(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    @CachePut(value = "type", key = "'list-all-types'")
    public List<Type> insertType(Type type) {
        typeDao.insertType(type);
        return typeDao.listAllType();
    }

    @Override
    @CachePut(value = "type", key = "'list-all-types'")
    public List<Type> updateType(Type type) {
        typeDao.updateType(type);
        return typeDao.listAllType();
    }

    @Override
    @Cacheable(value = "type", key = "'list-all-types'")
    public List<Type> listAllType() {
        return typeDao.listAllType();
    }

    @Override
    public Type getTypeByTypeName(String typeName) {
        return typeDao.getTypeByTypeName(typeName);
    }
}
