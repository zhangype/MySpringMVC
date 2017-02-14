package chapter4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import chapter4.model.UserModel;

/**
 * @Description: ���������֮һ
 * @author zhangype@yonyou.com	
 * @date 2016-12-05
 * @version V1.0 
 *
 */
public class MyAbstractCommandController extends AbstractCommandController {
    public MyAbstractCommandController() {  
        //�����������ʵ����  
        setCommandClass(UserModel.class);  
    }  
    
    @Override  
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {  
        //���������ת��Ϊʵ������  
        UserModel user = (UserModel) command;  
        ModelAndView mv = new ModelAndView();  
        mv.setViewName("abstractCommand");  
        mv.addObject("user", user);  
        return mv;  
    }  
}
