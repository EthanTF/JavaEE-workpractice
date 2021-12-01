package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

	
	@Controller
	public class firstcontroller{
		//@GetMapping等同于@RequestMapping(value="/first/{id}",method=RequestMethod.GET)
		@RequestMapping(value="/first")
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			// 创建modelandview对象
			ModelAndView mav=new ModelAndView();
			mav.addObject("msg", "用玄学卡bug实现spring mvc入门!!");
			//设置逻辑视图名
			mav.setViewName("/first");
			return mav;
		}
		

	}