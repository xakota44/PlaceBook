package com.raywenderlich.placebook.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.raywenderlich.placebook.model.Bookmark

@Dao
interface BookmarkDao {
    // 2
    @Query("SELECT * FROM Bookmark")
    fun loadAll(): LiveData<List<Bookmark>>
    // 3
    @Query("SELECT * FROM Bookmark WHERE id = :bookmarkId")
    fun loadBookmark(bookmarkId: Long): Bookmark
    @Query("SELECT * FROM Bookmark WHERE id = :bookmarkId")
    fun loadLiveBookmark(bookmarkId: Long): LiveData<Bookmark>
    // 4
    @Insert(onConflict = IGNORE)
    fun insertBookmark(bookmark: Bookmark): Long
    // 5
    @Update(onConflict = REPLACE)
    fun updateBookmark(bookmark: Bookmark)
    // 6
    @Delete
    fun deleteBookmark(bookmark: Bookmark)
}