package org.backend.config;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Configuration
public class ErrorAttributesConfig {

    @Bean
    public ErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes() {
            @Override
            public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
            	 // Use the super class's getErrorAttributes method to get the default error attributes
                // and customize the options to include additional attributes
                return super.getErrorAttributes(webRequest, options.including(Include.EXCEPTION, Include.MESSAGE, Include.BINDING_ERRORS));
                
                // The options.including(...) method configures the attributes to be included in the error response.
                // In this case, it includes the following attributes:
                // 1. EXCEPTION: The exception that occurred during the request handling.
                // 2. MESSAGE: The error message associated with the exception.
                // 3. BINDING_ERRORS: Any errors that occurred during data binding/validation.
                
            }
        };
    }
}
