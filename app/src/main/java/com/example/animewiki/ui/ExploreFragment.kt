package com.example.animewiki.ui

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animewiki.adapters.ExploreAdapter
import com.example.animewiki.api.JikanRetrofit
import com.example.animewiki.data.RandomCharchter
//import com.example.animewiki.data.SearchAnime
import com.example.animewiki.data.TopAnime
import com.example.animewiki.data.SearchAnime
import com.example.animewiki.databinding.ExploreItemListBinding.bind
import com.example.animewiki.databinding.FragmentExploreBinding
import com.example.animewiki.databinding.FragmentExploreBinding.bind
import com.example.animewiki.databinding.FragmentRandomBinding.bind
import com.example.animewiki.databinding.FragmentRandomBinding.inflate
import com.example.animewiki.databinding.FragmentTopBinding.bind
import retrofit2.Call

import retrofit2.Response
import javax.security.auth.callback.Callback



class ExploreFragment : Fragment() {


    private lateinit var binding: FragmentExploreBinding






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?) =
        FragmentExploreBinding.inflate(inflater, container, false).also {
            binding = it
        }.root





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.apply {

            val jikanRetrofit = JikanRetrofit.create()
            val call = jikanRetrofit.getRandomCharchter()

            searchButton.setOnClickListener {

                val searchAnime =searchInputText.text.toString()
                val callSearchAnime = jikanRetrofit.getSearchAnime(searchAnime)
                val manager = requireActivity().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                manager.hideSoftInputFromWindow(searchInputText.windowToken,0)
//                val manager = activity!!.>()getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//                manager.hideSoftInputFromWindow(searchInputText.getWindowToken(), 0)

                callSearchAnime.enqueue(object : Callback<SearchAnime>  {
                     fun onResponse(
                        call: Call<SearchAnime>,
                        response: Response<SearchAnime>
                    ){

                        if (response.body() != null){
                            val searchAnime= response.body()!!.results
                            animerv.adapter = ExploreAdapter(this@ExploreFragment, searchAnime)
                            animerv.layoutManager = GridLayoutManager(requireContext(), 2)
                        }
                    }

                    fun onFailure(call: Call<SearchAnime>,t: Throwable) {}
                })
            }


//            call.enqueue(object : Callback<TopAnime>{
//                override fun onResponse(
//                    call: Call<RandomCharchter>,
//                    response: Response<RandomCharchter>
//                ){
//                    if (response.body() != null){
//                        val top = response.body()!!.results
//                        animerv.adapter = ExploreAdapter(this@ExploreFragment, top)
//                        animerv.layoutManager = GridLayoutManager(this@ExploreFragment,2)
//                    }
//
//                }
//
//
//
//            })
        }

    }




}


