package com.example.homework2.com.example.homework2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "ReviewsDB"
        private const val TABLE_NAME = "reviews"
        private const val KEY_USERNAME = "username"
        private const val KEY_COMMENT = "comment"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($KEY_USERNAME TEXT, $KEY_COMMENT TEXT)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addReview(review: Review) {
        val values = ContentValues()
        values.put(KEY_USERNAME, review.name)
        values.put(KEY_COMMENT, review.comment)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllReviews(): List<Review> {
        val reviewsList = mutableListOf<Review>()

        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val username = cursor.getColumnIndex(KEY_USERNAME)
                val comment = cursor.getColumnIndex(KEY_COMMENT)
                val review = Review(username.toString(), comment.toString())
                reviewsList.add(review)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return reviewsList
    }


}