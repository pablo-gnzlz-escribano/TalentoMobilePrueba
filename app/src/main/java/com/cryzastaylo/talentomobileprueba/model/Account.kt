package com.cryzastaylo.talentomobileprueba.model

data class Account(
    var accountBalanceInCents: Long? = null,
    var accountCurrency: String? = "",
    var accountId: Long? = null,
    var accountName: String? = "",
    var accountNumber: String? = null,
    var accountType: String? = "",
    var alias: String? = "",
    var isVisible: Boolean? = null,
    var iban: String? = "",
    var linkedAccountId: Long? = null,
    var valproductName: String? = "",
    var productType: Long? = null,
    var savingsTargetReached: Long? = null,
    var targetAmountInCents: Long? = null
)