package com.cryzastaylo.talentomobileprueba

import android.content.ContextWrapper
import androidx.lifecycle.ViewModel
import com.cryzastaylo.talentomobileprueba.model.Account
import com.cryzastaylo.talentomobileprueba.model.Impl

class ViewModel() : ViewModel() {
    var listOfVisible: List<Account>? = null
    var completeList: List<Account>? = null

    fun getData(contextWrapper: ContextWrapper) {
        val impl = Impl()
        completeList =
            impl.getCompleteList(impl.loadData("Accounts.json", contextWrapper))
        listOfVisible = impl.getVisibleList()
    }
}