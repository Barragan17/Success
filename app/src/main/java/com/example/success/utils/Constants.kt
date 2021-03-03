package com.example.success.utils

import com.example.success.R
import com.example.success.models.Quotes

object Constants {

    fun getQuotes(): ArrayList<Quotes>{
        val quotes = ArrayList<Quotes>()

        val quo1 = Quotes(1, "Life has no limitations, excepts you makes one", R.drawable.background_1)
        quotes.add(quo1)

        val quo2 = Quotes(2, "The Future Belongs to Those Who Believe in the Beauty of Their Dreams", R.drawable.background_2)
        quotes.add(quo2)

        val quo3 = Quotes(3, "If Your Goals Don't Scare You, They Aren't Big Enough", R.drawable.background_3)
        quotes.add(quo3)

        val quo4 = Quotes(4, "Every Next Level of Your Life, Will Demand a Different You", R.drawable.background_4)
        quotes.add(quo4)

        val quo5 = Quotes(5, "Work Hard in Silence, Let The Success Be Your Noise", R.drawable.background_5)
        quotes.add(quo5)

        quotes.shuffle()
        return quotes
    }
}