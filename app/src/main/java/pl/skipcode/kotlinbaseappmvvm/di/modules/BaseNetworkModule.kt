package pl.skipcode.kotlinbaseappmvvm.di.modules

//@Module
//abstract class BaseNetworkModule {
//
//    @Named("rest")
//    @Provides
//    fun provideRestInterceptor(configuration: ConfigurationInterface): Interceptor =
//            RestInterceptor(configuration)
//
//    @Named("response")
//    @Provides
//    fun provideResponseInterceptor(
//            configuration: ConfigurationInterface
//    ): Interceptor =
//            ResponseInterceptor(configuration)
//
//    @Singleton
//    @Provides
//    fun provideGson(): Gson =
//            GsonBuilder()
//                    .setDateFormat(BuildConfig.DATE_FORMAT)
//                    .registerTypeAdapter(Date::class.java, DateDeserializer())
//                    .registerTypeAdapter(Date::class.java, DateSerializer())
//                    .serializeNulls()
//                    .create()
//
//    @Singleton
//    @Provides
//    fun provideConverterFactory(gson: Gson): Converter.Factory =
//            GsonConverterFactory.create(gson)
//
//    @Singleton
//    @Provides
//    fun provideAdapterFactory(): CallAdapter.Factory =
//            RxJava2CallAdapterFactory.create()
//
//    @Singleton
//    @Provides
//    fun provideRetrofit(
//            okHttpClient: OkHttpClient,
//            converterFactory: Converter.Factory,
//            callAdapterFactory: CallAdapter.Factory
//    ): Retrofit =
//            Retrofit.Builder()
//                    .baseUrl(BuildConfig.PATH_API)
//                    .client(okHttpClient)
//                    .addConverterFactory(converterFactory)
//                    .addCallAdapterFactory(callAdapterFactory)
//                    .build()
//
//}