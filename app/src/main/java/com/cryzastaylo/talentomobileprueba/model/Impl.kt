package com.cryzastaylo.talentomobileprueba.model

import android.content.ContextWrapper
import android.util.Log
import com.google.gson.Gson

class Impl {
    private var data = Map()

    fun loadData(file: String, context: ContextWrapper): String {
        var content = ""

        try {
            val stream = context.assets.open(file)
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            content = String(buffer)
        } catch (e: Exception) {
            Log.d("DATA", "Algo ha fallado")
        }
        Log.d("DATA", content)
        return content
    }

    fun getCompleteList(content: String): List<Account>? {
        val gson = Gson()
        data = gson.fromJson(content, Map::class.java)

        Log.d("DATA", "LA LISTA DE VISIBLES: " + data.accounts.toString())

        return data.accounts
    }

    fun getVisibleList(): List<Account>? {
        val visibleList = data.accounts?.filter { it.isVisible == true }
        Log.d("DATA", "LA LISTA DE LOS QUE NO ESTÁN VISIBLES: " + visibleList.toString())
        return visibleList
    }
}