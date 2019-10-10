package com.platform.rentalhome.base;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author rainly
 * @email 610232785@qq.com
 * @time 2017年11月9日 上午11:51:48
 */
public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

	/**
	 * 得到参数值
	 * @return
	 */
	public Map<String, String> getParamMap() {
		HttpServletRequest request = getRequest();
		Enumeration<String> paramNames = request.getParameterNames();

		Map<String, String> returnMap = new HashMap<String, String>();

		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] values = request.getParameterValues(paramName);
			String value = null;
			
			for (int i = 0; i < values.length; i++) {
				value = values[i] + ",";
			}
			value = value.substring(0, value.length() - 1);
			
			returnMap.put(paramName, value);
		}
		return returnMap;
	}
}
