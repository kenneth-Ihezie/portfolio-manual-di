package com.example.myportfolio.view

import android.content.Context
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myportfolio.R
import com.example.myportfolio.model.Portfolio
import kotlinx.android.synthetic.main.recycler_portfolio.view.*

class PortfolioAdapter internal constructor(context: Context, private val listener: PortfolioAdapterListener) : RecyclerView.Adapter<PortfolioAdapter.PortfolioViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var portfolios = emptyList<Portfolio>()

    inner class PortfolioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnLongClickListener {
        val portfolioView: TextView = itemView.itemPortfolio
        val portfolioCostView: TextView = itemView.costPortfolio
        val portfolioTimeView: TextView = itemView.timePortfolio
        val portfolioDateView: TextView = itemView.datePortfolio


        init {
            itemView.setOnLongClickListener(this)
        }

        override fun onLongClick(view: View): Boolean {
            listener.onRowLongClicked(adapterPosition)
            view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        val itemView = inflater.inflate(R.layout.recycler_portfolio, parent, false)
        return PortfolioViewHolder(itemView)
    }

    override fun getItemCount() = portfolios.size

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        val current = portfolios[position]
        holder.portfolioView.text = current.portfolioItem
        holder.portfolioCostView.text = current.portfolioCost
        holder.portfolioTimeView.text = current.portfolioTime
        holder.portfolioDateView.text = current.portfolioDate

       // applyClickEvents(holder, position)

    }

  /*  private fun applyClickEvents(holder: PortfolioViewHolder, position: Int){
        holder.linearLayout.setOnLongClickListener{ view ->
            listener.onRowLongClicked(position)
            view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
            val a = portfolioClass()
            a.viewholder = PortfolioViewHolder(view)
            true

        }
    }*/


    internal fun setPortfolio(portfolios: List<Portfolio>){
        this.portfolios = portfolios
        notifyDataSetChanged()
    }
    interface PortfolioAdapterListener {
        fun onRowLongClicked(position: Int)
    }

    fun getPortfolioAtPosition(position: Int): Portfolio{
        return portfolios[position]
    }
}