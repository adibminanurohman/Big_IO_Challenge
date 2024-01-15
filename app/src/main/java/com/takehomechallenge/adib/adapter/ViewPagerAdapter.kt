package com.takehomechallenge.adib.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    // Daftar fragmen yang akan ditampilkan di dalam ViewPager
    private val fragmentList: MutableList<Fragment> = ArrayList()

    // Daftar judul tab yang sesuai dengan setiap fragmen
    private val titleList: MutableList<String> = ArrayList()

    // Metode untuk mendapatkan fragmen pada posisi tertentu
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    // Metode untuk mendapatkan jumlah total fragmen dalam ViewPager
    override fun getCount(): Int {
        return fragmentList.size
    }

    // Metode untuk menambahkan fragmen dan judul tab ke dalam daftar
    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }

    // Metode untuk mendapatkan judul tab pada posisi tertentu
    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }
}
