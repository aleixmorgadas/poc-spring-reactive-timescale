package dev.aleixmorgadas.pocspringreactivetimescale.config

import dev.aleixmorgadas.pocspringreactivetimescale.accountbalances.AccountBalance
import dev.aleixmorgadas.pocspringreactivetimescale.transactions.Transaction
import org.springframework.data.rest.core.config.RepositoryRestConfiguration

import javax.persistence.EntityManager

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry


@Configuration
class RestRepositoryConfig : RepositoryRestConfigurer {

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration, cors: CorsRegistry?) {
        config.exposeIdsFor(AccountBalance::class.java)
        config.exposeIdsFor(Transaction::class.java)
    }
}