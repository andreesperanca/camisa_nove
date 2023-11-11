package com.andreesperanca.database.util

import androidx.room.TypeConverter
import java.math.BigDecimal

class BigDecimalConverter {

    @TypeConverter
    fun toBigDecimal(float: Float): BigDecimal {
        return float.toBigDecimal()
    }

    @TypeConverter
    fun toFloat(bigDecimal: BigDecimal): Float {
        return bigDecimal.toFloat()
    }

}