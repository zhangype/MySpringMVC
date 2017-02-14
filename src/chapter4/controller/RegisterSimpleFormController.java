package chapter4.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.SimpleFormController;

import chapter4.model.UserModel;

/**
 * @Description: ��ע��
 * @author zhangype@yonyou.com	
 * @date 2016-12-05
 * @version V1.0 
 *
 */
public class RegisterSimpleFormController extends SimpleFormController {
	
    public RegisterSimpleFormController() {  
        setCommandClass(UserModel.class);	//�����������ʵ����  
        setCommandName("user");				//����������������  
    }
    
    //form object �������ṩչʾ��ʱ�ı����ݣ�ʹ��commandName��������  
    protected Object formBackingObject(HttpServletRequest request) throws Exception {  
        UserModel user = new UserModel();  
        user.setUsername("�������û���");  
        return user;  
    }
    
    //�ṩչʾ��ʱ��Ҫ��һЩ��������    
    protected Map<String, List<String>> referenceData(HttpServletRequest request) throws Exception {  
        Map<String, List<String>> map = new HashMap<String, List<String>>();  
        map.put("cityList", Arrays.asList("ɽ��", "����", "�Ϻ�"));  
        return map;  
    }
    
    protected void doSubmitAction(Object command) throws Exception {  
        UserModel user = (UserModel) command;  
        System.out.println(user);  
    }
}
