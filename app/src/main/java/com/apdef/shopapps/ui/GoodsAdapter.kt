package com.apdef.shopapps.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apdef.shopapps.R
import com.apdef.shopapps.model.Goods

class GoodsAdapter (private val listGoods: ArrayList<Goods>,
                    private val listener: GoodListener
):RecyclerView.Adapter<GoodsAdapter.GoodsVH>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_goods, parent, false)
        return GoodsVH(view)
    }

    override fun onBindViewHolder(holder: GoodsVH, position: Int) {
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