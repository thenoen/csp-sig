package nl.ohpen.sig.frontend.csp.cspserver.config;

import nl.ohpen.sig.frontend.csp.cspserver.interceptor.CspResponseInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

@Configuration
public class HttpInterceptorAppConfig implements WebMvcConfigurer {

    private final CspResponseInterceptor productServiceInterceptor;

    public HttpInterceptorAppConfig(CspResponseInterceptor productServiceInterceptor) {
        this.productServiceInterceptor = productServiceInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(productServiceInterceptor);
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
