package com.platform.rentalhome.service;

import com.platform.rentalhome.base.BaseService;
import com.platform.rentalhome.bean.TbHome;
import com.platform.rentalhome.mapper.HomeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeService extends BaseService<TbHome> {

    @Resource
    private HomeMapper homeMapper;

    /**
     * 查询全部数据
     * @return
     */
    public List<TbHome> selectData() {
        return homeMapper.listHome();
    }


}
