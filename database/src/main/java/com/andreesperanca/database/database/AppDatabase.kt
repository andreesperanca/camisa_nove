package com.andreesperanca.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.andreesperanca.database.dao.PlayerDao
import com.andreesperanca.database.dao.SettingsDao
import com.andreesperanca.database.model.Player
import com.andreesperanca.database.model.Settings
import com.andreesperanca.database.util.BigDecimalConverter

@Database(entities = [Player::class, Settings::class], version = 1, exportSchema = false)
@TypeConverters(BigDecimalConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun playersDao(): PlayerDao
    abstract fun settingsDao(): SettingsDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "database.db")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
