package com.hopecoding.spotifyclone.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.hopecoding.spotifyclone.data.entities.Song
import com.hopecoding.spotifyclone.other.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song>{
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception){
            emptyList()
        }
    }
}