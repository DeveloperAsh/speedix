package com.speedix.user.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.speedix.user.R
import com.speedix.user.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var dataBinding : ActivityMainBinding
    var lastTabID : Int = 0
    var tabCount : Int = 4 ;

    lateinit var lastBottomImg : ImageView
    lateinit var lastBottomText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        setTabLayoutBottom()
        setClick()
     }

    private fun setTabLayoutBottom() {
        for ( i in 0 until tabCount)
        {
            val tab : TabLayout.Tab = dataBinding.tabBottom.newTab();
            dataBinding.tabBottom.addTab(tab)
        }
    }

    private fun setClick() {
        dataBinding.viewHomeTab.setOnClickListener(this)
        dataBinding.viewCartTab.setOnClickListener(this)
        dataBinding.viewHelpTab.setOnClickListener(this)
        dataBinding.viewMoreTab.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        bottomTabsClick(v)

    }

    private fun bottomTabsClick(v: View)
    {
        if(lastTabID != v.id)
        {
            when(v.id)
            {
                R.id.view_home_tab -> {

                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.home_enable))
                        .into(dataBinding.imgHomeTab)

                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.cart_disable))
                        .into(dataBinding.imgCartTab)


                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.help_disable))
                        .into(dataBinding.imgHelpTab)


                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.profile_disable))
                        .into(dataBinding.imgMoreTab)

                    dataBinding.txtHomeTab.setTextColor(resources.getColor(R.color.enable_tab_color))
                    dataBinding.txtCartTab.setTextColor(resources.getColor(R.color.disable_tab_color))
                    dataBinding.txtHelpTab.setTextColor(resources.getColor(R.color.disable_tab_color))
                    dataBinding.txtMoreTab.setTextColor(resources.getColor(R.color.disable_tab_color))


                }
                R.id.view_cart_tab -> {

                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.home_disable))
                        .into(dataBinding.imgHomeTab)

                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.cart_enable))
                        .into(dataBinding.imgCartTab)


                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.help_disable))
                        .into(dataBinding.imgHelpTab)


                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.profile_disable))
                        .into(dataBinding.imgMoreTab)

                    dataBinding.txtHomeTab.setTextColor(resources.getColor(R.color.disable_tab_color))
                    dataBinding.txtCartTab.setTextColor(resources.getColor(R.color.enable_tab_color))
                    dataBinding.txtHelpTab.setTextColor(resources.getColor(R.color.disable_tab_color))
                    dataBinding.txtMoreTab.setTextColor(resources.getColor(R.color.disable_tab_color))
                }
                R.id.view_help_tab -> {

                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.home_disable))
                        .into(dataBinding.imgHomeTab)

                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.cart_disable))
                        .into(dataBinding.imgCartTab)


                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.help_enable))
                        .into(dataBinding.imgHelpTab)


                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.profile_disable))
                        .into(dataBinding.imgMoreTab)

                    dataBinding.txtHomeTab.setTextColor(resources.getColor(R.color.disable_tab_color))
                    dataBinding.txtCartTab.setTextColor(resources.getColor(R.color.disable_tab_color))
                    dataBinding.txtHelpTab.setTextColor(resources.getColor(R.color.enable_tab_color))
                    dataBinding.txtMoreTab.setTextColor(resources.getColor(R.color.disable_tab_color))
                }
                R.id.view_more_tab -> {

                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.home_disable))
                        .into(dataBinding.imgHomeTab)

                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.cart_disable))
                        .into(dataBinding.imgCartTab)


                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.help_disable))
                        .into(dataBinding.imgHelpTab)


                    Glide.with(this)
                        .load(resources.getDrawable(R.drawable.profile_enable))
                        .into(dataBinding.imgMoreTab)

                    dataBinding.txtHomeTab.setTextColor(resources.getColor(R.color.disable_tab_color))
                    dataBinding.txtCartTab.setTextColor(resources.getColor(R.color.disable_tab_color))
                    dataBinding.txtHelpTab.setTextColor(resources.getColor(R.color.disable_tab_color))
                    dataBinding.txtMoreTab.setTextColor(resources.getColor(R.color.enable_tab_color))

                }
            }

            dataBinding.tabBottom.getTabAt(v.getTag().toString().toInt())?.select()
        }
    }


    private fun setFocusTab(image:ImageView, drawbleId:Int , text:TextView)
    {
        Glide.with(this)
            .load(resources.getDrawable(drawbleId))
            .into(image)

        text.setTextColor(resources.getColor(R.color.enable_tab_color))
        lastBottomImg = image
        lastBottomText=text

    }

    private fun setDefocusTab(image:ImageView, drawbleId:Int , text:TextView)
    {
        Glide.with(this)
            .load(resources.getDrawable(drawbleId))
            .into(image)

        text.setTextColor(resources.getColor(R.color.disable_tab_color))
        lastBottomImg = image
        lastBottomText=text

    }
}