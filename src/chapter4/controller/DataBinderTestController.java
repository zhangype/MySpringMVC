package chapter4.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import chapter4.controller.support.editor.PhoneNumberEditor;
import chapter4.model.DataBinderTestModel;
import chapter4.model.PhoneNumberModel;

public class DataBinderTestController extends AbstractCommandController {
	
	public DataBinderTestController() {
        setCommandClass(DataBinderTestModel.class);	//�����������
        setCommandName("dataBinderTest");			//����������������
    } 
	
    @Override
    protected ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object command, BindException errors) throws Exception {
        //���command���󿴿��Ƿ����ȷ
        System.out.println(command);
        return new ModelAndView("bindAndValidate/success").addObject("dataBinderTest", command);
    }
    
    /**
     * ���̣�
		1�����ȴ������ݰ������ڴ˴˻ᴴ��ServletRequestDataBinder��Ķ��󣬲�����messageCodesResolver���������������
		2���ṩ��һ����չ�㣬��ʼ�����ݰ������ڴ˴����ǿ��Ը��Ǹ÷���ע���Զ����PropertyEditor�������������>����������Ե�ת����
		3���������ݰ󶨣��������������>�������İ�
		4���ṩ�ڶ�����չ�㣬���ݰ���ɺ����չ�㣬�˴�����ʵ��һЩ�Զ���İ󶨶���
		5����֤���������֤����֤��ͨ��validatorsע�룬�����֤ʧ�ܣ���Ҫ�Ѵ�����Ϣ����Errors���˴�ʹ��BindExceptionʵ�֣�
		6���ṩ��������չ�㣬�˴�����ʵ���Զ���İ�/��֤�߼�
		7����errors���빦�ܴ��������д������ܷ���Ӧ���жϸô�������Ƿ��д��������Ӧ�Ĵ���
     */
//    @Override
//    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {  
//        
//    	super.initBinder(request, binder);
//        //ע���Զ�������Ա༭��
//        //1������
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
//        //��ʾ������������Date���͵����ԣ���ʹ�ø����Ա༭����������ת��
//        binder.registerCustomEditor(Date.class, dateEditor);
//        
//        //�Զ���ĵ绰����༭��
//        //��ʾ������������PhoneNumberModel���ͣ���ʹ��PhoneNumberEditor��������ת��
//        binder.registerCustomEditor(PhoneNumberModel.class, new PhoneNumberEditor());
//    }
}
