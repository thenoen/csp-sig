package nl.ohpen.sig.frontend.csp.cspserver.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Example1ResponseInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (request.getRequestURI().contains("example1")) {
			response.addHeader("Content-Security-Policy", "script-src 'none';");
			response.addHeader("Content-Security-Policy", "script-src-attr 'unsafe-inline';");
		}
		return true;
	}
}