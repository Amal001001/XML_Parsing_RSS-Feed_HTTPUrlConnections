package com.example.xml_parsing_rss_feed_httpurlconnections.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "item", strict = false)
//class item @JvmOverloads constructor(
class item constructor(): Serializable {

      @field:Element(name = "title")
   //   @param:Element(name = "title")
      var title: String? = null

//        @field:Element(name = "title")
//        var title: String? = null

//        @field:Element(name = "description")
//        @param:Element(name = "description")
//        var description: String? = null
//
//        @field:Element(name = "category")
//        var category: String? = null

//        override fun toString(): String {
//            return "Author{" +
//                    "name='" + name + '\'' +
//                    ", uri='" + uri + '\'' +
//                    '}'
//        }
}
//) : Serializable {
//    }