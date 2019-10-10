package com.platform.rentalhome.controller;

import com.platform.rentalhome.base.BaseController;
import com.platform.rentalhome.bean.TbHome;
import com.platform.rentalhome.service.HomeService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * describe:
 *
 * @author Administrator
 * @date 2019/09/05
 * @Time 21:30
 */
@Controller
@RequestMapping(value = "/web")
public class WebController extends BaseController {

    @Resource
    private HomeService homeService;

    Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping(value = "/data",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object data(){
        List<TbHome> homes = homeService.selectData();
        return homes;
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping(value = "/toIndex",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView toIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "123123");
        modelAndView.setViewName("index2");
        return modelAndView;
    }

    /**
     * 租房列表
     * @return
     */
    @RequestMapping(value = "/homeList",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Object homeList(){
        return "home_list2";
    }

    /**
     * 房间明细
     * @return
     */
    @RequestMapping(value = "/toHome",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Object toHome(){

        return "home";
    }

    /**
     * 反馈
     * @return
     */
    @RequestMapping(value = "/toFeedback",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Object toFeedback(){
        return "feedback";
    }

    /**
     * 联系我们
     * @return
     */
    @RequestMapping(value = "/toContact",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Object toContact(){
        return "contact";
    }
}
