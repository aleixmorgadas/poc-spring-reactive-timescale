package dev.aleixmorgadas.pocspringreactivetimescale.transactions

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "transactions")
class Transaction (
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID,
    val time: Date,
    val name: String,
    val accountId: UUID,
    val asset: String,
    val value: Double,
    val concept: String
    )