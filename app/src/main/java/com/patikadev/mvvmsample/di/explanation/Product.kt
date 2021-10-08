package com.patikadev.mvvmsample.di.explanation

class Product(private val item : Item){

    fun getItemPrice() : String{
       return item.getPrice()
    }

    fun getItemType() : String {
        return item.getType()
    }


}