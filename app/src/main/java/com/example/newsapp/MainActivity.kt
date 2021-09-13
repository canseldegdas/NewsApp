package com.example.newsapp

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.fragments.DetailNewsFragment
import com.example.newsapp.fragments.NewsCard1Fragment
import com.example.newsapp.fragments.NewsCard2Fragment
import com.example.newsapp.fragments.NewsCard3Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    var newsCardDetails: DetailNewsFragment? = null
    var newsCardFragmentList: ArrayList<Pair<Fragment, Int>> = arrayListOf()
    var selectedItemId:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()



    }

    fun init() {

        var newsCard1 = NewsCard1Fragment.newInstance("aa", "ss")
        var newsCard2 = NewsCard2Fragment.newInstance("aa", "ss")
        var newsCard3 = NewsCard2Fragment.newInstance("aa", "ss")
        var newsCard4 = NewsCard3Fragment.newInstance("aa", "ss")
        var newsCard5 = NewsCard3Fragment.newInstance("aa", "ss")
        var newsCard6 = NewsCard2Fragment.newInstance("aa", "ss")
        var newsCard7 = NewsCard3Fragment.newInstance("aa", "ss")
        var newsCard8 = NewsCard2Fragment.newInstance("aa", "ss")
        var newsCard9 = NewsCard3Fragment.newInstance("aa", "ss")
        var newsCard10 = NewsCard3Fragment.newInstance("aa", "ss")
        var newsCard11 = NewsCard2Fragment.newInstance("aa", "ss")
        var newsCard12 = NewsCard2Fragment.newInstance("aa", "ss")
        var newsCard13 = NewsCard3Fragment.newInstance("aa", "ss")
        var newsCard14 = NewsCard3Fragment.newInstance("aa", "ss")
        var newsCard15 = NewsCard2Fragment.newInstance("aa", "ss")
        newsCardDetails = DetailNewsFragment.newInstance("aa", "ss")

        newsCardFragmentList.add(Pair(newsCard1, binding.frmNewsCard1.id))
        newsCardFragmentList.add(Pair(newsCard2, binding.frmNewsCard2.id))
        newsCardFragmentList.add(Pair(newsCard3, binding.frmNewsCard3.id))
        newsCardFragmentList.add(Pair(newsCard4, binding.frmNewsCard4.id))
        newsCardFragmentList.add(Pair(newsCard5, binding.frmNewsCard5.id))
        newsCardFragmentList.add(Pair(newsCard6, binding.frmNewsCard6.id))
        newsCardFragmentList.add(Pair(newsCard7, binding.frmNewsCard7.id))
        newsCardFragmentList.add(Pair(newsCard8, binding.frmNewsCard8.id))
        newsCardFragmentList.add(Pair(newsCard9, binding.frmNewsCard9.id))
        newsCardFragmentList.add(Pair(newsCard10, binding.frmNewsCard10.id))
        newsCardFragmentList.add(Pair(newsCard11, binding.frmNewsCard11.id))
        newsCardFragmentList.add(Pair(newsCard12, binding.frmNewsCard12.id))
        newsCardFragmentList.add(Pair(newsCard13, binding.frmNewsCard13.id))
        newsCardFragmentList.add(Pair(newsCard14, binding.frmNewsCard14.id))
        newsCardFragmentList.add(Pair(newsCard15, binding.frmNewsCard15.id))

        addFragments(newsCard1,binding.frmNewsCard1.id)
        addFragments(newsCard2,binding.frmNewsCard2.id)
        addFragments(newsCard3,binding.frmNewsCard3.id)
        addFragments(newsCard4,binding.frmNewsCard4.id)
        addFragments(newsCard5,binding.frmNewsCard5.id)
        addFragments(newsCard6,binding.frmNewsCard6.id)
        addFragments(newsCard7,binding.frmNewsCard7.id)
        addFragments(newsCard8,binding.frmNewsCard8.id)
        addFragments(newsCard9,binding.frmNewsCard9.id)
        addFragments(newsCard10,binding.frmNewsCard10.id)
        addFragments(newsCard11,binding.frmNewsCard11.id)
        addFragments(newsCard12,binding.frmNewsCard12.id)
        addFragments(newsCard13,binding.frmNewsCard13.id)
        addFragments(newsCard14,binding.frmNewsCard14.id)
        addFragments(newsCard15,binding.frmNewsCard15.id)



        binding.frmNewsCard1.setOnClickListener(this)
        binding.frmNewsCard2.setOnClickListener(this)
        binding.frmNewsCard3.setOnClickListener(this)
        binding.frmNewsCard4.setOnClickListener(this)
        binding.frmNewsCard5.setOnClickListener(this)
        binding.frmNewsCard6.setOnClickListener(this)
        binding.frmNewsCard7.setOnClickListener(this)
        binding.frmNewsCard8.setOnClickListener(this)
        binding.frmNewsCard9.setOnClickListener(this)
        binding.frmNewsCard10.setOnClickListener(this)
        binding.frmNewsCard11.setOnClickListener(this)
        binding.frmNewsCard12.setOnClickListener(this)
        binding.frmNewsCard13.setOnClickListener(this)
        binding.frmNewsCard14.setOnClickListener(this)
        binding.frmNewsCard15.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        newsCardFragmentList.forEach {
            if (it.second == v?.id) {
                selectedItemId=v.id;
                openDetailFragment(newsCardDetails, v.id)
            } else {
                removeNewsFragments(it.first)
            }
        }
    }
    fun addFragments(fragment: Fragment,@IdRes id: Int){
        supportFragmentManager.beginTransaction().add(id,fragment).commit()

    }

    fun openDetailFragment(fragment: Fragment?, @IdRes id: Int?) {
        if (fragment == null && id == null) {
            return
        }
        supportFragmentManager.beginTransaction().replace(id!!, fragment!!).commit()

    }

    fun removeNewsFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().remove(fragment).commit()

    }

    override fun onBackPressed() {
        newsCardFragmentList.forEach {
            if (it.second == selectedItemId) {
                openDetailFragment(it.first, it.second)
            } else {
                addFragments(it.first,it.second)
            }
        }

    }
}