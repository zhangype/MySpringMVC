package chapter4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorldController extends AbstractController {
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1���ռ�����
		//2���󶨲������������
		//3������ҵ�����
		//4��ѡ����һ��ҳ��
		ModelAndView mv = new ModelAndView();
		//���ģ������ �����������POJO����
		mv.addObject("message", "Hello World!");
		//�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��
		mv.setViewName("hello");
		return mv;
	}
}
