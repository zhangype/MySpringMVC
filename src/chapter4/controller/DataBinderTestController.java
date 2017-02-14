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
        setCommandClass(DataBinderTestModel.class);	//设置命令对象
        setCommandName("dataBinderTest");			//设置命令对象的名字
    } 
	
    @Override
    protected ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object command, BindException errors) throws Exception {
        //输出command对象看看是否绑定正确
        System.out.println(command);
        return new ModelAndView("bindAndValidate/success").addObject("dataBinderTest", command);
    }
    
    /**
     * 流程：
		1、首先创建数据绑定器，在此此会创建ServletRequestDataBinder类的对象，并设置messageCodesResolver（错误码解析器）
		2、提供第一个扩展点，初始化数据绑定器，在此处我们可以覆盖该方法注册自定义的PropertyEditor（请求参数——>命令对象属性的转换）
		3、进行数据绑定，即请求参数——>命令对象的绑定
		4、提供第二个扩展点，数据绑定完成后的扩展点，此处可以实现一些自定义的绑定动作
		5、验证器对象的验证，验证器通过validators注入，如果验证失败，需要把错误信息放入Errors（此处使用BindException实现）
		6、提供第三个扩展点，此处可以实现自定义的绑定/验证逻辑
		7、将errors传入功能处理方法进行处理，功能方法应该判断该错误对象是否有错误进行相应的处理
     */
//    @Override
//    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {  
//        
//    	super.initBinder(request, binder);
//        //注册自定义的属性编辑器
//        //1、日期
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
//        //表示如果命令对象有Date类型的属性，将使用该属性编辑器进行类型转换
//        binder.registerCustomEditor(Date.class, dateEditor);
//        
//        //自定义的电话号码编辑器
//        //表示如果命令对象是PhoneNumberModel类型，则使用PhoneNumberEditor进行类型转换
//        binder.registerCustomEditor(PhoneNumberModel.class, new PhoneNumberEditor());
//    }
}
