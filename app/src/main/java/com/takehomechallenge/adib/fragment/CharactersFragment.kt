package com.takehomechallenge.adib.fragment

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.takehomechallenge.adib.R
import com.takehomechallenge.adib.adapter.CharactersAdapter
import com.takehomechallenge.adib.models.CharactersResponse
import com.takehomechallenge.adib.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CharactersAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_characters, container, false)

        recyclerView = view.findViewById(R.id.rv_characters)

        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        ambilData()

        swipeRefreshLayout.setOnRefreshListener {
            ambilData()
        }

        return view
    }

    private fun ambilData(){
        RetrofitClient.getApi().getAllCharacters().enqueue(object : Callback<CharactersResponse>{
            override fun onResponse(call: Call<CharactersResponse>, response: Response<CharactersResponse>) {
                val res = response.body()?.results
                if (res != null) {
                    adapter = CharactersAdapter(res)
                    recyclerView.adapter = adapter
                    Log.d("data:" , res.toString())
                    // Berhenti animasi refresh setelah jeda 2 detik
                    Handler().postDelayed({
                        swipeRefreshLayout.isRefreshing = false
                    }, 2000)
                }
            }

            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                Log.e("data failed", t.message.toString())
                // Berhenti animasi refresh setelah jeda 2 detik
                Handler().postDelayed({
                    swipeRefreshLayout.isRefreshing = false
                }, 2000)
            }

        })
    }
}
