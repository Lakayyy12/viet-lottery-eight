package com.application.vietlotteryeight

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.card_layout.view.*

class MyAdapter(private val context: Context, private val myModelArrayList: ArrayList<MyModel>): PagerAdapter(){
    override fun getCount(): Int {
        return  myModelArrayList.size //return list of records/items
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //inflate layout card_layout.xml
        val  view = LayoutInflater.from(context).inflate(R.layout.card_layout, container, false)

        //getdata
        val model = myModelArrayList[position]
        val title = model.title
        val description = context.resources.getString(model.description)
        val image = model.image

        //set data to ui views
        view.bannerIv.setImageResource(image)
        view.tanjiro.text = title
        view.description.text = description


        //handle item/card click
        view.setOnClickListener{
            Navigator.showContent(context, "$title \n $description")
        }
        //add view to container
       container.addView(view)
        return view
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}

