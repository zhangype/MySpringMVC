package chapter6.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.security.Principal;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import chapter4.model.UserModel;

@Controller
@RequestMapping("/method/param")
public class MethodParamTypeController {

    //��ȡServlet API ��ص�����/��Ӧ
    @RequestMapping("/requestOrResponse")
	public String requestOrResponse(ServletRequest servletRequest,
			HttpServletRequest httpServletRequest,
			ServletResponse servletResponse,
			HttpServletResponse httpServletResponse) {
		return "success";
	}
    
    //��ȡ ����/��Ӧ�� ���������ݣ����ֽ�������ʽ��ȡ��
    @RequestMapping("/inputOrOutBody")
    public void inputOrOutBody(InputStream requestBodyIn, OutputStream responseBodyOut)
        throws IOException {
        responseBodyOut.write("success".getBytes());
    }
    
    //��ȡ ����/��Ӧ�� ���������ݣ����ַ�������ʽ��ȡ��
    @RequestMapping("/readerOrWriterBody")
    public void readerOrWriteBody(Reader reader, Writer writer)
        throws IOException {
        writer.write("hello");
    }
    
    
    @RequestMapping("/webRequest")
    public String webRequest(WebRequest webRequest, NativeWebRequest nativeWebRequest) {
        System.out.println(webRequest.getParameter("test"));//�ٵõ��������test��ֵ
        webRequest.setAttribute("name", "value", WebRequest.SCOPE_REQUEST);//��
        System.out.println(webRequest.getAttribute("name", WebRequest.SCOPE_REQUEST));
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);//��
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        return "success";
    }
    
    @RequestMapping("/session")
    public String session(HttpSession session) {
        System.out.println(session);
        return "success";
    }
    

    @RequestMapping(value = "/commandObject", method = RequestMethod.GET)
    public String toCreateUser(HttpServletRequest request, UserModel user) {
        return "customer/create";
    }
    
    @RequestMapping(value = "/commandObject", method = RequestMethod.POST)
    public String createUser(HttpServletRequest request, UserModel user) {
        System.out.println(user);
        return "success";
    }
    
    @RequestMapping(value = "/model")
    public String createUser(Model model, Map model2, ModelMap model3) {
        model.addAttribute("a", "a");
        model2.put("b", "b");
        model3.put("c", "c");
        System.out.println(model == model2);
        System.out.println(model2 == model3);
        return "success";
    }
    
    
    @RequestMapping(value = "/mergeModel")
    public ModelAndView mergeModel(Model model) {
        model.addAttribute("a", "a");//�����ģ������
        ModelAndView mv = new ModelAndView("success");
        mv.addObject("a", "update");//������ͼ��Ⱦ֮ǰ���¢۴�ͬ��ģ������
        model.addAttribute("a", "new");//���޸Ģٴ�ͬ��ģ������
        //��ͼҳ���a����ʾΪ"update" ������"new"
        return mv;
    }
    
    @RequestMapping(value = "/error1")
    public String error1(UserModel user, BindingResult result) {
        return "success";
    }
    
    @RequestMapping(value = "/error2")
    public String error2(UserModel user, BindingResult result, Model model) {
        return "success";
    }
    
    @RequestMapping(value = "/error3")
    public String error3(UserModel user, Errors errors) {
        return "success";
    }
    //���´�����spring3.1֮ǰ���׳�"Errors/BindingResult argument declared without preceding model attribute."�쳣
    //��spring3.1��ʼ���´�������������
    @RequestMapping(value = "/error4")
    public String error4(UserModel user, Model model, Errors errors) {
        return "success";
    }
    
    @RequestMapping(value = "/other")
    public String other(Locale locale, Principal principal) {
        System.out.println(locale);
        System.out.println(principal);
        return "success";
    }
}
