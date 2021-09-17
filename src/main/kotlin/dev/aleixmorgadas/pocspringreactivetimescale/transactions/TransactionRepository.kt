package dev.aleixmorgadas.pocspringreactivetimescale.transactions

import org.springframework.data.repository.CrudRepository
import java.util.*

interface TransactionRepository: CrudRepository<Transaction, UUID>