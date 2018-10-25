package pl.skipcode.kotlinbaseappmvvm.utils.tools.parcel

import android.os.Parcelable
import org.parceler.Parcels

class ParcelableProviderImpl : IParcelableProvider {

    override fun from(from: Any): Parcelable =
            Parcels.wrap(from)
}