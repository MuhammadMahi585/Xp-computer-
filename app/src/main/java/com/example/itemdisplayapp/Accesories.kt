package com.example.itemdisplayapp

import androidx.annotation.DrawableRes

data class Accesories (
    @DrawableRes val imageRes: Int,
    val name: String,
    val price: String
)
val acessorieslist= listOf(
    Accesories(R.drawable.apple_iphone_5_smartphone___800x902,"Iphone 5","$100"),
    Accesories(R.drawable.samsung_galaxy_s10_ceramic_black_back___1280x854,"Galaxy s10","$200"),
    Accesories(R.drawable.samsung_galaxy_s10_ceramic_black_front___1280x854,"Galaxy s10","$300"),
    Accesories(R.drawable.smartphone_iphone_11_pro_max_silver___1280x854,"Iphone 11","$400"),
    Accesories(R.drawable.samsung_galaxy_s10_prism_white_back___1280x854,"Galaxy s10","$500")
)