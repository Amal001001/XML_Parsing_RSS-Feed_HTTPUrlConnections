package com.example.xml_parsing_rss_feed_httpurlconnections.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "channel", strict = false)
//class channel constructor() : Serializable {
class channel @JvmOverloads constructor(

    //    @field:Element(required = false, name = "item")
//    @param:Element(name = "item")
//      var item: item? = null
//  var item: String? = null
    @field:ElementList(inline = true, name = "item")
  //  @param:Element(name = "item")
    var item: List<item>? = null

//}
////
    ) : Serializable {
    }