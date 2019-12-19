package com.ecin520.answer.service.impl;

import com.ecin520.answer.dao.TypeDao;
import com.ecin520.answer.service.TypeService;
import com.ecin520.api.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ecin520
 * @date: 2019/12/2 9:58
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public Boolean insertType(Type type) {
        return typeDao.insertType(type);
    }

    @Override
    public Boolean updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Override
    public List<Type> listAllType() {
        return typeDao.listAllType();
    }

    @Override
    public Type getTypeByTypeName(String typeName) {
        return typeDao.getTypeByTypeName(typeName);
    }
}
