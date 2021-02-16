package nl.ohpen.sig.frontend.csp.cspserver.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Example4ResponseInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (request.getRequestURI().contains("example4")) {
			response.addHeader("Content-Security-Policy","script-src 'nonce-allowed' 'report-sample'; report-to group1");
//			response.addHeader("Content-Security-Policy","script-src 'nonce-allowed' 'nonce-abc-to-g2' 'report-sample'; report-to group2");
			response.addHeader("Report-to", "{\"group\":\"group1\",\"max_age\":30,\"endpoints\":[{\"url\":\"http://localhost:8080/csp-report/report-to-group-1\"}],\"include_subdomains\":true}");
//			response.addHeader("Report-to", """
//     												{
//														"group":"group1",
//														"max_age":1800,
//														"endpoints":[{"url":"https://localhost:8080/csp-report/report-to-group-1"}]
//														,"include_subdomains":true
//     												},
//     												{
//														"group":"group2",
//														"max_age":1800,
//														"endpoints":[{"url":"http://localhost:8080/csp-report/report-to-group-2-e1"},
//																	 {"url":"http://localhost:8080/csp-report/report-to-group-2-e2"}]
//														,"include_subdomains":true
//     												}
//					""");
		}
		return true;
	}
}