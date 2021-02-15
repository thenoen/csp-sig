package nl.ohpen.sig.frontend.csp.cspserver.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Example2ResponseInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (request.getRequestURI().contains("example2")) {
//			response.addHeader("Content-Security-Policy","script-src 'sha256-7BqxfWa3J2m58DlEtHcXwrzw7nUpbPnMoZVDb2KHGW0='; report-uri /csp-report/"); //for src attribute - does not work


//			response.addHeader("Content-Security-Policy","script-src 'sha256-34Ucx9oAc+cuTPFeeVBRMpwPSxnIJxAqP/iFk9mWEC8='; report-uri /csp-report/");//script3
//			response.addHeader("Content-Security-Policy","script-src 'nonce-abc'; report-uri /csp-report/");

			response.addHeader("Content-Security-Policy","script-src sha256-34Ucx9oAc+cuTPFeeVBRMpwPSxnIJxAqP/iFk9mWEC8=' 'nonce-abc';");
		}
		return true;
	}

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
								Object handler, Exception exception) throws Exception {
	}
}