package chapter4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;

/**
 * @Description: 使用Spring的Last-Modified机制强制刷新
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
			//TODO 此处更新的条件：如果内容有更新，应该重新返回内容最新修改的时间戳
			lastModified = System.currentTimeMillis();
		}
		return lastModified;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//点击后再次请求当前页面
		response.getWriter().write("<a href=''>this</a>");
		return null;
	}

}
