package pl.skipcode.kotlinbaseappmvvm.di.modules

//@Module
//class NetworkModule : BaseNetworkModule() {
//
//    @Named("HttpLogging")
//    @Provides
//    fun provideHttpLoggingInterceptor(): Interceptor =
//            HttpLoggingInterceptor()
//                    .setLevel(HttpLoggingInterceptor.Level.BODY)
//
//    @Singleton
//    @Provides
//    fun provideOkHttpClient(
//            @Named("rest") restInterceptor: Interceptor,
//            @Named("response") responseInterceptor: Interceptor,
//            @Named("HttpLogging") loggingInterceptor: Interceptor
//    ): OkHttpClient =
//            OkHttpClient.Builder()
//                    .addInterceptor(restInterceptor)
//                    .addInterceptor(responseInterceptor)
//                    .addInterceptor(loggingInterceptor)
//                    .connectTimeout(20, TimeUnit.SECONDS)
//                    .readTimeout(20, TimeUnit.SECONDS)
//                    .writeTimeout(20, TimeUnit.SECONDS)
//                    .build()
//
//}