package com.apdef.shopapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.apdef.shopapps.model.Goods
import com.apdef.shopapps.storage.GoodsDao
import com.apdef.shopapps.storage.GoodsRoomDatabase
import com.apdef.shopapps.R
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    companion object{
        const val EDIT_GOODS_EXTRA = "edit_goods_extra"
    }
    private lateinit var goods: Goods
    private lateinit var db : GoodsRoomDatabase
    private lateinit var dao: GoodsDao
    private var isUpdated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        db = GoodsRoomDatabase.getDatabase(applicationContext)
        dao = db.getGoodsDao()

        if (intent.getParcelableExtra<Goods>(EDIT_GOODS_EXTRA) != null){
            btn_delete.visibility = View.VISIBLE
            isUpdated = true
            goods = intent.getParcelableExtra(EDIT_GOODS_EXTRA)
            et_name.setText(goods.name)
            et_quantity.setText(goods.jumlah)
            et_suppliers.setText(goods.suppliers)

        }

        btn_save.setOnClickListener {
            val name = et_name.text.toString()
            val quantity = et_quantity.text.toString()
            val suppliers = et_suppliers.text.toString()
            if (name.isEmpty() && quantity.isEmpty()){
                Toast.makeText(this, "Kolom tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }else{
                if (isUpdated){
                    saveItem(Goods(id = goods.id, name = name, jumlah = quantity, suppliers = suppliers))
                }else{
                    saveItem(Goods(name = name, jumlah = quantity, suppliers = suppliers))
                }
                finish()
            }

        }
        btn_delete.setOnClickListener {
            deleteItem(goods)
            finish()
        }
    }

    private fun saveItem( goods: Goods){
        if (dao.getById(goods.id).isEmpty()){
            dao.insert(goods)
        }else{
            dao.update(goods)
        }
        Toast.makeText(this, "Data tersimpan!", Toast.LENGTH_SHORT).show()
    }

    private fun deleteItem(goods: Goods){
        dao.delete(goods)
        Toast.makeText(this, "Data berhasil dihapus!", Toast.LENGTH_SHORT).show()
    }
}