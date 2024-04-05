package kd.com.util.thymeleaf

import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver

@Component
class DecoupledLogicEnabled(
    val templateResolver: SpringResourceTemplateResolver
) {

    companion object {
        private val log = LoggerFactory.getLogger(DecoupledLogicEnabled::class.java)
    }

    @PostConstruct
    fun init(){
        templateResolver.useDecoupledLogic = true
        log.info("Decoupled Template Logic enabled.")
    }

}