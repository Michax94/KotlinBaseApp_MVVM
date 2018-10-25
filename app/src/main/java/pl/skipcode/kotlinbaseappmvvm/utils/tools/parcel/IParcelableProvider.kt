package pl.skipcode.kotlinbaseappmvvm.utils.tools.parcel

import android.os.Parcelable

interface IParcelableProvider {
    fun from(from: Any): Parcelable
}