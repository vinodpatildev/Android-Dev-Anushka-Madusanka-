package com.vinodpatildev.roomdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Subscriber::class], version = 1)
abstract class SubscriberDatabase: RoomDatabase() {
    abstract val subscriberDAO : SubscriberDAO

    companion object{
        @Volatile
        private var INSTANCE:SubscriberDatabase? = null

        fun getInstance(ctx: Context):SubscriberDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    ctx,
                    SubscriberDatabase::class.java,
                    "subscriber_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}