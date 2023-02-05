package com.example.jetpackcompose

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class NavItems(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val navRoute : String
){
    object Home : NavItems(R.string.home, R.drawable.ic_home, NAV_HOME )
    object Favourite : NavItems(R.string.favourites, R.drawable.ic_fav, NAV_FAV )
    object Feed : NavItems(R.string.feed, R.drawable.ic_feed, NAV_FEED )
    object Profile : NavItems(R.string.profile, R.drawable.ic_profile, NAV_PROFILE )
}
