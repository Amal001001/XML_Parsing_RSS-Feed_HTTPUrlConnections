package com.example.xml_parsing_rss_feed_httpurlconnections

import com.example.xml_parsing_rss_feed_httpurlconnections.model.channel
import retrofit2.Call
import retrofit2.http.GET

interface rssAPI {
    @get:GET("/rss.xml")
    val rss: Call<rss?>?

    companion object {
        const val BASE_URL = "https://www.3ders.org"
    }
}