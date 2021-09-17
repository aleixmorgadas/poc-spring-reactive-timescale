package dev.aleixmorgadas.pocspringreactivetimescale

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import java.lang.reflect.Type
import javax.persistence.EntityManager


@SpringBootApplication
class PocSpringReactiveTimescaleApplication

fun main(args: Array<String>) {
	runApplication<PocSpringReactiveTimescaleApplication>(*args)
}
