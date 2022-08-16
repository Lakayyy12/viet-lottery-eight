package com.application.vietlotteryeight

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var btn1 : TextView? = null
    private var btn2 : TextView? = null
    private var btn3 : TextView? = null
    private var btn4 : TextView? = null
    private var btn5 : TextView? = null
    private var btn6 : TextView? = null

    private var exit = 0

    //actionbar
    private  lateinit var myModelList: ArrayList<MyModel>
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init actionbar
        loadCards()
        //add page change listener
        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                //change title of actionbar
                var title = myModelList[position].title

            }

            override fun onPageSelected(position: Int) {
            }
            override fun onPageScrollStateChanged(state: Int) {
            }
        })

        btn1 = findViewById(R.id.btn1)
        btn1?.setOnClickListener {
            val intent = Intent(this, AboutPage::class.java)
            startActivity(intent) }

            btn2 = findViewById(R.id.btn2)
            btn2?.setOnClickListener{
                Navigator.showContent(this,getString(R.string.m1))
            }
            btn3 = findViewById(R.id.btn3)
            btn3?.setOnClickListener{
                Navigator.showContent(this,getString(R.string.m2))
            }
            btn4 = findViewById(R.id.btn4)
            btn4?.setOnClickListener{
                Navigator.showContent(this,getString(R.string.m3))
            }
            btn5 = findViewById(R.id.btn5)
            btn5?.setOnClickListener{
                Navigator.showContent(this,getString(R.string.m4))
            }
            btn6 = findViewById(R.id.btn6)
            btn6?.setOnClickListener{
                Navigator.showContent(this,getString(R.string.m5))
            }
        }

    private fun loadCards(){
        //init list
        myModelList = ArrayList()

        //add items/data to list
        myModelList.add(MyModel(
            "Hướng dẫn xổ số 1",
            R.string.v1,
            R.drawable.logo1))
        myModelList.add(MyModel(
            "Hướng dẫn xổ số 2",
            R.string.v2,
            R.drawable.logo1))
        myModelList.add(MyModel(
            "Hướng dẫn xổ số 3",
            R.string.v3,
            R.drawable.logo1))
        myModelList.add(MyModel(
            "Hướng dẫn xổ số 4",
            R.string.v4,
            R.drawable.logo1))
        myModelList.add(MyModel(
            "Hướng dẫn xổ số 5",
            R.string.v5,
            R.drawable.logo1))

            //setup adapter
            myAdapter = MyAdapter(this, myModelList)

                    //set adapter to viewpager
                    viewPager.adapter = myAdapter

                    // set default padding
                    viewPager.setPadding(50,0,50,0)
    }
    override fun onBackPressed() {
        if (exit == 0){
            exit = 1
            Toast.makeText(this, "Nhấp lại để thoát!", Toast.LENGTH_SHORT).show()
        }else{
            super.finishAffinity()
        }
    }
    }

