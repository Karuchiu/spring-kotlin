package kd.com.config

import kd.com.interceptor.RequestInterceptor
import kd.com.util.ViewNames
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import org.springframework.web.servlet.i18n.SessionLocaleResolver

@Configuration
class WebConfig : WebMvcConfigurer {

    @Bean
    fun localeResolver(): LocaleResolver {
        return SessionLocaleResolver()
    }

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/").setViewName(ViewNames.HOME)
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(RequestInterceptor())

        registry.addInterceptor(LocaleChangeInterceptor().apply {
            paramName = "lang"
        })
    }
}