package com.vinodpatildev.roomdemo

import android.util.Log
import android.util.Patterns
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.StringUtil
import com.vinodpatildev.roomdemo.db.Subscriber
import com.vinodpatildev.roomdemo.db.SubscriberRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository): ViewModel() {
    val subscribers = repository.allSubscribers

    private var isUpdateOrDelete = false
    private lateinit var subscriberIsUpdateOrDelete: Subscriber

    val inputName = MutableLiveData<String?>()

    val inputEmail = MutableLiveData<String?>()

    val saveOrUpdateButtonText = MutableLiveData<String>()

    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
    get() = statusMessage
 
    init {
        saveOrUpdateButtonText.value = "SAVE"
        clearAllOrDeleteButtonText.value = "CLEAR ALL"
    }

    fun saveOrUpdate(){
        if (inputName.value == null) {
            statusMessage.value = Event("Please enter subscriber's name")
        } else if (inputEmail.value == null) {
            statusMessage.value = Event("Please enter subscriber's email")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()) {
            statusMessage.value = Event("Please enter a correct email address")
        } else {
            if (isUpdateOrDelete) {
                subscriberIsUpdateOrDelete.name = inputName.value!!
                subscriberIsUpdateOrDelete.email = inputEmail.value!!
                update(subscriberIsUpdateOrDelete)
                exitUpdateAndDelete()
            } else {
                val name = inputName.value!!
                val email = inputEmail.value!!
                insert(Subscriber(0, name, email))
                inputName.value = null
                inputEmail.value = null
            }
        }

    }
    fun clearAllOrDelete(){
        if(isUpdateOrDelete){
            delete(subscriberIsUpdateOrDelete)
            exitUpdateAndDelete()
        }else {
            deleteAll()
        }
    }
    fun insert(subscriber: Subscriber){
        viewModelScope.launch {
            val newRowId = repository.insert(subscriber)
            if(newRowId >-1){
                statusMessage.value = Event("Subscriber id:$newRowId inserted successfully.")
            }else{
                statusMessage.value = Event("Error Occurred.")
            }
        }
    }
    fun insert(subscribers: List<Subscriber>){
        viewModelScope.launch {
            val newRowIds = repository.insert(subscribers)
            if(newRowIds.size>0){
                statusMessage.value = Event("${newRowIds.size} Subscribers are inserted successfully.")
            }else{
                statusMessage.value = Event("Error Occurred.")
            }
        }
    }
    fun update(subscriber: Subscriber){
        viewModelScope.launch {
            val noOfRowsUpdated = repository.update(subscriber)
            if(noOfRowsUpdated>0){
                statusMessage.value = Event("${noOfRowsUpdated} subscribers updated successfully.")
            }else{
                statusMessage.value = Event("Error Occurred.")
            }
        }
    }
    fun delete(subscriber: Subscriber){
        viewModelScope.launch {
            val noOfSubscriberDeleted = repository.delete(subscriber)
            if(noOfSubscriberDeleted>0){
                statusMessage.value = Event("${noOfSubscriberDeleted} subscriber deleted successfully.")
            }else{
                statusMessage.value = Event("Error Occurred.")
            }
        }

    }
    fun deleteAll(){
        viewModelScope.launch {
            repository.deleteAll()
        }
        statusMessage.value = Event("All subscribers deleted successfully.")
    }

    fun initUpdateAndDelete(subscriber: Subscriber){
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email

        isUpdateOrDelete = true
        subscriberIsUpdateOrDelete = subscriber

        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }
    fun exitUpdateAndDelete(){
        inputName.value = ""
        inputEmail.value = ""

        isUpdateOrDelete = false

        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }
}