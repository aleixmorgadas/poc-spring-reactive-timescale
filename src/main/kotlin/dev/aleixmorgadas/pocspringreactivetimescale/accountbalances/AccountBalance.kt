package dev.aleixmorgadas.pocspringreactivetimescale.monthlyaccountbalances

import org.hibernate.annotations.Immutable
import java.io.Serializable
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass

class AccountBalanceId(
    val accountId: UUID = UUID.randomUUID(),
    val name: String = "",
    val asset: String = "",
): Serializable

@Entity
@IdClass(AccountBalanceId::class)
@Immutable
class AccountBalance(
    @Id
    val accountId: UUID,
    @Id
    val name: String,
    @Id
    val asset: String,
    val balance: Double
    )