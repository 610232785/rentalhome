package com.platform.rentalhome.base;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public abstract class BaseService<T> {

    @Autowired
    private Mapper<T> mapper;

    /**
     * 返回列表
     * @param t
     * @return
     */
    public List<T> queryList(T t) {
        return this.mapper.select(t);
    }

    public Integer queryCount(T t) {
        return this.mapper.selectCount(t);
    }

    public T queryById(Object id) {
        if (id instanceof String) {
            id = ((String) id).trim();
        }
        return this.mapper.selectByPrimaryKey(id);
    }
}
