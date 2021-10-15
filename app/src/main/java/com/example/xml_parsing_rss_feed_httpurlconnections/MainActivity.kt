package com.example.xml_parsing_rss_feed_httpurlconnections

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xml_parsing_rss_feed_httpurlconnections.model.channel
import com.example.xml_parsing_rss_feed_httpurlconnections.model.item
import kotlinx.android.synthetic.main.item_row.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class MainActivity : AppCompatActivity() {

    private  val BASE_URL = "https://www.3ders.org/rss.xml/"

    lateinit var rv: RecyclerView
    private lateinit var rvAdapter: RVAdapter
    private var itemArray = mutableListOf<item>()

//    lateinit var tv: TextView
    lateinit var bFetch: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)
        rvAdapter = RVAdapter(itemArray)
        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)

//        tv = findViewById(R.id.tv)
        bFetch = findViewById(R.id.bFetch)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val rssAPI = retrofit.create(rssAPI::class.java)
        val call = rssAPI.rss

        bFetch.setOnClickListener(object : View.OnClickListener {
           override fun onClick(v: View?) {

                call!!.clone().enqueue(object : Callback<rss?> {
                    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
                    override fun onResponse(call: Call<rss?>, response: Response<rss?>) {

                        val items = response.body()!!.channel?.item
                        for (item in items!!) {
                            Log.d("main", "onResponse: " + item.title)
//                            var text = tv.text.toString()
//                            tv.text = "$text + \n + ${item.title}"
                              itemArray.add(item)
                            rvAdapter.notifyDataSetChanged()
                        }

                    }

                    override fun onFailure(call: Call<rss?>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "An Error Occured", Toast.LENGTH_SHORT).show()
                    }
                })

            }

        })

    }
}