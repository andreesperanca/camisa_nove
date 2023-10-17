package com.andreesperanca.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andreesperanca.database.dao.PlayerDao
import com.andreesperanca.database.model.Player

@Database(entities = [Player::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun playersDao(): PlayerDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "players_db")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
