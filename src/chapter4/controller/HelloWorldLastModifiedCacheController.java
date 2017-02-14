package chapter4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;

/**
 * @Description: ʹ��Spring��Last-Modified����ǿ��ˢ��
 * @author zhangype@yonyou.com	
 * @date 2016-12-05
 * @version V1.0 
 *
 */
public class HelloWorldLastModifiedCacheController extends AbstractController implements LastModified {
	private long lastModified;
	
	@Override
	public long getLastModified(HttpServletRequest request) {
		if(lastModified == 0L) {
			//TODO �˴����µ���������������и��£�Ӧ�����·������������޸ĵ�ʱ���
			lastModified = System.currentTimeMillis();
		}
		return lastModified;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//������ٴ�����ǰҳ��
		response.getWriter().write("<a href=''>this</a>");
		return null;
	}

}
