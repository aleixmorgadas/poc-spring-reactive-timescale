package dev.aleixmorgadas.pocspringreactivetimescale.accountbalances

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository
import java.util.*

interface AccountBalanceRepository: CrudRepository<AccountBalance, AccountBalanceId> {
    fun findByAccountId(accountId: UUID): List<AccountBalance>
}