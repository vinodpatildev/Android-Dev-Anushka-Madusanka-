package com.vinodpatildev.roomdemo.db

import androidx.lifecycle.LiveData

class SubscriberRepository(private val dao: SubscriberDAO) {
    val allSubscribers = dao.getAllSubscribers()

    suspend fun insert(subscriber: Subscriber):Long{
        return dao.insertSubscriber(subscriber)
    }
    suspend fun insert(subscribers: List<Subscriber>):List<Long>{
        return dao.insertSubscribers(subscribers)
    }
    suspend fun update(subscriber: Subscriber):Int{
        return dao.updateSubscriber(subscriber)
    }
    suspend fun delete(subscriber: Subscriber):Int{
        return dao.deleteSubscriber(subscriber)
    }
    suspend fun getAllSubscribers(): LiveData<List<Subscriber>> {
        return allSubscribers
    }
    suspend fun deleteAll(){
        dao.deleteAllSubscribers()
    }
}