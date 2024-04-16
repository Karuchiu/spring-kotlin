package kd.com.interceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception

class RequestInterceptor : HandlerInterceptor {

    companion object {
        val log: Logger = LoggerFactory.getLogger(RequestInterceptor::class.java)
    }

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        log.debug("preHandle method called, handler = {}", handler)
        log.debug("request URL = {}", request.requestURL)
        return true
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
        log.debug("postHandle method called, handler = {}", handler)
        log.debug("request URL = {}", request.requestURL)
        log.debug("Model = {}", modelAndView?.model)
        log.debug("View = {}", modelAndView?.viewName)
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        log.debug("afterCompletion method called, handler = {}", handler)
        log.debug("request URL = {}", request.requestURL)
    }
}