package com.platform.rentalhome.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * describe:
 *
 * @author Administrator
 * @date 2019/09/05
 * @Time 21:30
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {

    @RequestMapping(value = "/data",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object data(){
        return "1";
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping(value = "/toIndex",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView toIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "123123");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 租房列表
     * @return
     */
    @RequestMapping(value = "/homeList",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Object homeList(){
        return "home_list";
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
}
