package pl.skipcode.kotlinbaseappmvvm.data.liveData

data class ResponseLiveData<T>(
        val data: T? = null,
        val correct : Boolean,
        val message : Int? = null
)