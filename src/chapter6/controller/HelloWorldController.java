package chapter6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping
public class HelloWorldController {
	
	 @RequestMapping(value = "/hello")
	 public ModelAndView helloWorld() {  
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
