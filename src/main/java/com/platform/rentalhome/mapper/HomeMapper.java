package com.platform.rentalhome.mapper;

import com.platform.rentalhome.base.BaseMapper;
import com.platform.rentalhome.bean.TbHome;

import java.util.List;

public interface HomeMapper extends BaseMapper<TbHome> {

    List<TbHome> listHome();

}
