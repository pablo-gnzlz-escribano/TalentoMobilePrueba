package com.cryzastaylo.talentomobileprueba.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cryzastaylo.talentomobileprueba.R

class Adapter(private val list: List<com.cryzastaylo.talentomobileprueba.model.Account>) :
    RecyclerView.Adapter<Adapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val account: com.cryzastaylo.talentomobileprueba.model.Account = list[position]
        holder.bind(account)
    }

    override fun getItemCount(): Int = list.size

    class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.card_view, parent, false)) {
        private var firstTextView: TextView? = null
        private var secondTextView: TextView? = null
        private var thirdTextView: TextView? = null


        init {
            firstTextView = itemView.findViewById(R.id.firstFieldCardView)
            secondTextView = itemView.findViewById(R.id.secondFieldCardView)
            thirdTextView = itemView.findViewById(R.id.thirdTextView)
        }

        fun bind(account: com.cryzastaylo.talentomobileprueba.model.Account) {
            firstTextView?.text = account.accountNumber
            secondTextView?.text = account.accountId.toString()
            thirdTextView?.text = account.accountBalanceInCents.toString()
        }
    }
}