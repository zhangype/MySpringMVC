package chapter4.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.SimpleFormController;

import chapter4.model.UserModel;

/**
 * @Description: 简单注册
 * @author zhangype@yonyou.com	
 * @date 2016-12-05
 * @version V1.0 
 *
 */
public class RegisterSimpleFormController extends SimpleFormController {
	
    public RegisterSimpleFormController() {  
        setCommandClass(UserModel.class);	//设置命令对象实现类  
        setCommandName("user");				//设置命令对象的名字  
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
}
