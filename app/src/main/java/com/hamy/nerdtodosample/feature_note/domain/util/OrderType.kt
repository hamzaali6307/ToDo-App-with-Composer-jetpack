package com.hamy.nerdtodosample.feature_note.domain.util

sealed class OrderType{
    object Ascending : OrderType()
    object Decending : OrderType()
}
