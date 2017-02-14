package chapter4.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import chapter4.model.UserModel;

/**
 * @Description: �ṩ�ಽ�裨�򵼣�����֧��
 * @author zhangype@yonyou.com	
 * @date 2016-12-05
 * @version V1.0 
 *
 */
public class InfoFillWizardFormController extends AbstractWizardFormController {

	public InfoFillWizardFormController() {
        setCommandClass(UserModel.class);
        setCommandName("user");
    }
	
    protected Map<String, List<String>> referenceData(HttpServletRequest request, int page) throws Exception {  
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		if (page == 1) { // �������дѧУ��Ϣҳ ��ҪѧУ������Ϣ
			map.put("schoolTypeList", Arrays.asList("����", "��ר", "��ѧ"));
		}
		if (page == 2) {// �������д������Ϣҳ ��Ҫ����������Ϣ
            map.put("cityList", Arrays.asList("����", "����", "�Ϻ�"));  
        }
        return map;
    }
    
    protected void validatePage(Object command, Errors errors, int page) {  
        //�ṩÿһҳ���ݵ���֤������  
    }
    
    protected void postProcessPage(HttpServletRequest request, Object command, Errors errors, int page) throws Exception {  
        //�ṩ��ÿһҳ���ʱ�ĺ�����  
    }

    protected ModelAndView processFinish(HttpServletRequest req, HttpServletResponse resp, Object command, BindException errors) throws Exception {  
        //�ɹ���Ĵ�����  
        System.out.println(command);  
        return new ModelAndView("redirect:/success");  
    }

    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {  
        //ȡ����Ĵ�����  
        System.out.println(command);  
        return new ModelAndView("redirect:/cancel");  
    }

}
