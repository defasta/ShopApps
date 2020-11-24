package com.apdef.shopapps.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.apdef.shopapps.model.Goods
import com.apdef.shopapps.storage.GoodsRoomDatabase
import com.apdef.shopapps.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }

        getData()
    }

    private fun getData(){
        val db = GoodsRoomDatabase.getDatabase(applicationContext)
        val dao = db.getGoodsDao()
        val listGoods = arrayListOf<Goods>()
        listGoods.addAll(dao.getAll())

        rv_goods.apply {
            adapter = GoodsAdapter(listGoods, object: GoodsAdapter.GoodListener {
                override fun OnItemClicked(goods: Goods) {
                    startActivity(Intent(this@MainActivity, EditActivity::class.java).putExtra(
                        EditActivity.EDIT_GOODS_EXTRA, goods))
                }

            })
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
        onStop()
        onDestroy()
    }
}