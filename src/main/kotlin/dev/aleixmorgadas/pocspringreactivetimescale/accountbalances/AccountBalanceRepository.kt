package dev.aleixmorgadas.pocspringreactivetimescale.monthlyaccountbalances

import org.springframework.data.repository.CrudRepository
import java.util.*

interface AccountBalanceRepository: CrudRepository<AccountBalance, AccountBalanceId> {
    fun findByAccountId(accountId: UUID): List<AccountBalance>
}