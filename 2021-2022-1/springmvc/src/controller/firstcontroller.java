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
		//@GetMapping��ͬ��@RequestMapping(value="/first/{id}",method=RequestMethod.GET)
		@RequestMapping(value="/first")
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			// ����modelandview����
			ModelAndView mav=new ModelAndView();
			mav.addObject("msg", "����ѧ��bugʵ��spring mvc����!!");
			//�����߼���ͼ��
			mav.setViewName("/first");
			return mav;
		}
		

	}