package nl.ohpen.sig.frontend.csp.cspserver.config;

import nl.ohpen.sig.frontend.csp.cspserver.interceptor.CspViolationReportOnlyInterceptor;
import nl.ohpen.sig.frontend.csp.cspserver.interceptor.Example1ResponseInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private final CspViolationReportOnlyInterceptor productServiceInterceptor;
    private final Example1ResponseInterceptor example1ResponseInterceptor;

    private final List<HandlerInterceptor> handlerInterceptors;

    public MvcConfig(CspViolationReportOnlyInterceptor productServiceInterceptor,
					 Example1ResponseInterceptor example1ResponseInterceptor,
					 List<HandlerInterceptor> handlerInterceptors) {
        this.productServiceInterceptor = productServiceInterceptor;
		this.example1ResponseInterceptor = example1ResponseInterceptor;
		this.handlerInterceptors = handlerInterceptors;
	}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        handlerInterceptors.forEach(registry::addInterceptor);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(cspReportHttpMessageConverter());
    }

    public HttpMessageConverter<Object> cspReportHttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter() {
            @Override
            public List<MediaType> getSupportedMediaTypes() {
                return Arrays.asList(new MediaType("application", "csp-report"), new MediaType("application", "reports+json"));
            }
        };
    }

}
