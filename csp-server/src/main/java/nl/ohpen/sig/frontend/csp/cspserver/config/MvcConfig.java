package nl.ohpen.sig.frontend.csp.cspserver.config;

import nl.ohpen.sig.frontend.csp.cspserver.interceptor.CspResponseInterceptor;
import nl.ohpen.sig.frontend.csp.cspserver.interceptor.Example1ResponseInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private final CspResponseInterceptor productServiceInterceptor;
    private final Example1ResponseInterceptor example1ResponseInterceptor;

    public MvcConfig(CspResponseInterceptor productServiceInterceptor,
					 Example1ResponseInterceptor example1ResponseInterceptor) {
        this.productServiceInterceptor = productServiceInterceptor;
		this.example1ResponseInterceptor = example1ResponseInterceptor;
	}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(productServiceInterceptor);
        registry.addInterceptor(example1ResponseInterceptor);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(cspReportHttpMessageConverter());
    }

    public HttpMessageConverter<Object> cspReportHttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter() {
            @Override
            public List<MediaType> getSupportedMediaTypes() {
                return Collections.singletonList(new MediaType("application", "csp-report"));
            }
        };
    }

}
