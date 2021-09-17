package dev.aleixmorgadas.pocspringreactivetimescale.accountbalances

import org.hibernate.annotations.Immutable
import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.IdClass

class AccountBalanceId(
    val bucket: String = "",
    val accountId: UUID = UUID.randomUUID(),
    val name: String = "",
    val asset: String = "",
): Serializable

@Entity
@IdClass(AccountBalanceId::class)
@Immutable
class AccountBalance(
    @Id
    val bucket: String,
    @Id
    val accountId: UUID,
    @Id
    val name: String,
    @Id
    val asset: String,
    val balance: Double
    )