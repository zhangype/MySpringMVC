package chapter5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class StopWatchHandlerInterceptor extends HandlerInterceptorAdapter {
	private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		long beginTime = System.currentTimeMillis();// 1����ʼʱ��
		startTimeThreadLocal.set(beginTime);		// �̰߳󶨱�����������ֻ�е�ǰ������߳̿ɼ���
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		long endTime = System.currentTimeMillis();	// 2������ʱ��
		long beginTime = startTimeThreadLocal.get();// �õ��̰߳󶨵ľֲ���������ʼʱ�䣩
		long consumeTime = endTime - beginTime;		// 3�����ĵ�ʱ��
		if (consumeTime > 500) {// �˴���Ϊ����ʱ�䳬��500���������Ϊ������
			// TODO ��¼����־�ļ�
			System.out.println(String.format("%s consume %d millis", request.getRequestURI(), consumeTime));
		}
		
		// ʹ����ThreadLocal�������������[org.springframework.core.NamedThreadLocal] ���µ� memory leak
		startTimeThreadLocal.remove();
	}
}
