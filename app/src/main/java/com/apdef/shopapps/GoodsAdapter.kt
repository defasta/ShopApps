package com.apdef.shopapps

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_validation.view.*
import kotlinx.android.synthetic.main.item_list_goods.view.*

class GoodsAdapter (private val listGoods: ArrayList<Goods>,
    private val listener: GoodListener):RecyclerView.Adapter<GoodsAdapter.GoodsVH>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsAdapter.GoodsVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_goods, parent, false)
        return GoodsVH(view)
    }

    override fun onBindViewHolder(holder: GoodsAdapter.GoodsVH, position: Int) {
        val item = listGoods[position]
        holder.tvTitle.text = item.name
        holder.tvJumlah.text = item.jumlah
        holder.tvSuppliers.text = item.suppliers
        holder.itemView.setOnClickListener {
            listener.OnItemClicked(item)
        }

    }

    class GoodsVH(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        var tvJumlah = itemView.findViewById<TextView>(R.id.tv_jumlah)
        var tvSuppliers = itemView.findViewById<TextView>(R.id.tv_suppliers)
    }

    override fun getItemCount(): Int = listGoods.size

    interface GoodListener{
        fun OnItemClicked(goods: Goods)
    }

}