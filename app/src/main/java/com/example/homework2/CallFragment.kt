package com.example.homework2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.homework2.com.example.homework2.Review


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.homework2.com.example.homework2.DBHelper


class CallFragment : Fragment() {

    private lateinit var dbHelper: DBHelper
    var clickbutton: Button?=null
    var namePeople: EditText?=null

    var commentPepole: EditText?=null
    var reviewsTextView: TextView?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_call, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbHelper = DBHelper(requireContext())

        clickbutton?.setOnClickListener {
            val username = namePeople?.text.toString()
            val comment = commentPepole?.text.toString()

            val review = Review(username, comment)
            dbHelper.addReview(review)

            // Очистка полей после отправки отзыва
            namePeople?.text?.clear()
            commentPepole?.text?.clear()

            // Обновление списка отзывов и отображение их в TextView
            updateReviewsList()
        }

        // Обновление списка отзывов и отображение их в TextView при создании фрагмента
        updateReviewsList()
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelper.close()
    }

    private fun updateReviewsList() {
        val reviewsList = dbHelper.getAllReviews()
        val reviewsText = StringBuilder()
        for (review in reviewsList) {
            reviewsText.append("${review.name}: ${review.comment}\n\n")
        }
        reviewsTextView?.text = reviewsText.toString()
    }
}