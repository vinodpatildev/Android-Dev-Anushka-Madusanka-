package com.vinodpatildev.roomdemo.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {
    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber):Long

    @Insert
    suspend fun insertSubscribers(subscribers: List<Subscriber>):List<Long>

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber):Int

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber):Int

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscribers() : LiveData<List<Subscriber>>

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAllSubscribers()
}