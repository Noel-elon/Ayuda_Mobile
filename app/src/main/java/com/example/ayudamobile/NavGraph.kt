package com.example.ayudamobile


import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.android.parcel.Parcelize

sealed class Destination : Parcelable {

    @Parcelize
    object SignUp : Destination()

    @Parcelize
    object SignIn : Destination()

    @Parcelize
    object Feed : Destination()


}

class Actions(navigator: Navigator<Destination>) {

    val signUp: () -> Unit = {
        navigator.navigate(Destination.SignUp)
    }

    val feed: () -> Unit = {
        navigator.navigate(Destination.Feed)
    }

    val pressOnBack: () -> Unit = {
        navigator.back()
    }
}