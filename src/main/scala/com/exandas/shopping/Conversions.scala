package com.exandas.shopping

import com.exandas.shopping.Pound
/**
 * Created by kostas on 28/05/2015.
 */
object Conversions {
   implicit def longToPound(value: Long) = Pound(value)

}
