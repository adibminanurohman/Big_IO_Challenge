package com.takehomechallenge.adib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.takehomechallenge.adib.adapter.ViewPagerAdapter
import com.takehomechallenge.adib.fragment.CharactersFragment
import com.takehomechallenge.adib.fragment.FavoriteFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi objek ViewPager dan TabLayout dari tata letak XML
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        // Buat instance dari ViewPagerAdapter, kelas yang mengelola fragmen di dalam ViewPager
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // Tambahkan fragmen CharactersFragment ke dalam adapter dengan judul "Characters"
        adapter.addFragment(CharactersFragment(), "Characters")

        // Tambahkan fragmen FavoriteFragment ke dalam adapter dengan judul "Favorite"
        adapter.addFragment(FavoriteFragment(), "Favorite")

        // Hubungkan adapter dengan ViewPager
        viewPager.adapter = adapter

        // Hubungkan TabLayout dengan ViewPager untuk menampilkan judul tab
        tabLayout.setupWithViewPager(viewPager)
    }
}