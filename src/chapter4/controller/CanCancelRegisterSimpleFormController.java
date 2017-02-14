package chapter4.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.CancellableFormController;

import chapter4.model.UserModel;

/**
 * @Description: 可取消的表单控制器，继承SimpleFormController，额外提供取消表单功能
 * @author zhangype@yonyou.com	
 * @date 2016-12-05
 * @version V1.0 
 *
 */
public class CanCancelRegisterSimpleFormController extends CancellableFormController	 {
	public CanCancelRegisterSimpleFormController() {
		setCommandClass(UserModel.class); // 设置命令对象实现类
		setCommandName("user"); // 设置命令对象的名字
	}
	    
    //form object 表单对象，提供展示表单时的表单数据（使用commandName放入请求）  
    protected Object formBackingObject(HttpServletRequest request) throws Exception {  
        UserModel user = new UserModel();  
        user.setUsername("请输入用户名");  
        return user;  
    }
    
    //提供展示表单时需要的一些其他数据    
    protected Map<String, List<String>> referenceData(HttpServletRequest request) throws Exception {  
        Map<String, List<String>> map = new HashMap<String, List<String>>();  
        map.put("cityList", Arrays.asList("山东", "北京", "上海"));  
        return map;  
    }
    
    protected void doSubmitAction(Object command) throws Exception {  
        UserModel user = (UserModel) command;  
        System.out.println(user);  
    }
    
    protected ModelAndView onCancle(Object command) throws Exception {
        UserModel user = (UserModel) command;  
        //TODO 调用业务对象处理  
        System.out.println(user);  
        return super.onCancel(command);  
    }
}
