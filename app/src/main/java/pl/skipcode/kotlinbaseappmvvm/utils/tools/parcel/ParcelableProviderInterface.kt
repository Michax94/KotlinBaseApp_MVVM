package pl.skipcode.kotlinbaseappmvvm.utils.tools.parcel

import android.os.Parcelable

interface ParcelableProviderInterface {
    fun from(from: Any): Parcelable
}