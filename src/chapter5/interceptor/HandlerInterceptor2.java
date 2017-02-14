package chapter5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HandlerInterceptor2 extends HandlerInterceptorAdapter {
	
	/**
	 * Ԥ����ص�������ʵ�ִ�������Ԥ�������¼��飩������������Ϊ��Ӧ�Ĵ���������Controllerʵ�֣�
	 * ����ֵ��true��ʾ�������̣��������һ����������������
	 * 		 false��ʾ�����жϣ����¼���ʧ�ܣ������������������������������������ʱ������Ҫͨ��response��������Ӧ
	 */
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===========HandlerInterceptor2 preHandle");
        return true;
    }
	
	/**
	 * ����ص�������ʵ�ִ������ĺ���������Ⱦ��ͼ֮ǰ������ʱ���ǿ���ͨ��modelAndView��ģ�ͺ���ͼ���󣩶�ģ�����ݽ��д�������ͼ���д���modelAndViewҲ����Ϊnull
	 */
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===========HandlerInterceptor2 postHandle");
    }
	
	/**
	 * ������������ϻص�������������ͼ��Ⱦ���ʱ�ص��������ܼ�������ǿ����ڴ˼�¼����ʱ�䲢�������ʱ�䣬�����Խ���һЩ��Դ����������try-catch-finally�е�finally���������ô�����ִ������preHandle����true����������afterCompletion
	 */
	@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===========HandlerInterceptor2 afterCompletion");
    }
	
}
