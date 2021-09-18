package dev.aleixmorgadas.pocspringreactivetimescale.monthlyaccountbalances

import org.springframework.data.repository.CrudRepository
import java.util.*

interface MonthlyAccountBalanceRepository: CrudRepository<MonthlyAccountBalance, MonthlyAccountBalanceID> {
    fun findByAccountId(accountId: UUID): List<MonthlyAccountBalance>
}