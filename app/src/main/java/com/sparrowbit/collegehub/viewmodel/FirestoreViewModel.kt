package com.sparrowbit.collegehub.viewmodel

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sparrowbit.collegehub.model.Chapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


const val TAG = "FIRESTORE"

enum class FireStoreStatus {
    LOADING,
    SUCCESS,
    ERROR,
    NO_INTERNET
}

class FirestoreViewModel : ViewModel() {
    private val db = Firebase.firestore

    private val _chapterList = MutableLiveData<List<Chapter>>()
    val chapterList: LiveData<List<Chapter>> = _chapterList

    private val _tappedSubjectName = MutableLiveData<String>()
    val tappedSubjectName: LiveData<String> = _tappedSubjectName

    private val _firestoreStatus = MutableLiveData<FireStoreStatus>()
    val fireStoreStatus: LiveData<FireStoreStatus> = _firestoreStatus

    fun setTappedSubjectName(subjectName: String) {
        _tappedSubjectName.value = subjectName
    }

    private val _internetConnectionCheck = MutableLiveData<Boolean>()
    val internetConnectionCheck: LiveData<Boolean> = _internetConnectionCheck

    fun checkInternetConnection(isConnected: Boolean) {
        _internetConnectionCheck.value = isConnected
    }

    fun loadChapter(subjectName: String) {
        if (internetConnectionCheck.value!! == true) {
            _firestoreStatus.value = FireStoreStatus.LOADING
            try {
                val chapterDocumentRef = db.collection(subjectName)
                chapterDocumentRef.get()
                    .addOnSuccessListener {
                        if (!it.isEmpty) {
                            val chapters = it.documents.map { documnet ->
                                val name = documnet.getString("name") ?: ""
                                val link = documnet.getString("link") ?: ""
                                Chapter(name = name, link = link)
                            }
                            _chapterList.value = chapters
                            _firestoreStatus.value = FireStoreStatus.SUCCESS
                        }
                    }
                    .addOnFailureListener {
                        _firestoreStatus.value = FireStoreStatus.ERROR
                        Log.d(TAG, "get failed with ", it)
                    }
                // Handler is used to send messages between threads
                // post() method is used to send message to the handler
                //Looper is a class that's responsible for processing messages in a thread
                // The Looper.getMainLooper() method returns the Looper associated with the main thread of the current process.
                /* The Handler constructor that you're referring to takes two arguments: the Looper instance that the handler
                should be associated with, and a callback that should be executed when a message is received. */
                //By associating the Handler with the main thread's Looper, any messages that are processed by the handler will be executed on the main thread
                Handler(Looper.getMainLooper()).postDelayed({
                    if (_firestoreStatus.value == FireStoreStatus.LOADING) {
                        _firestoreStatus.value = FireStoreStatus.ERROR
                        _chapterList.value = listOf()
                    }
                }, 10000)
            } catch (e: java.lang.Exception) {
                _firestoreStatus.value = FireStoreStatus.ERROR
                _chapterList.value = listOf()
            }
        } else {
            _firestoreStatus.value = FireStoreStatus.NO_INTERNET
        }
    }
}