object Versions {
    const val minSdk = "21"
    const val targetSdk = "28"
    const val versionCode = 1
    const val versionName = "1.0"

    const val kotlin = "1.2.71"
    const val gradle = "3.2.0"
    const val fabric = "1.+"
    const val crashlytics = "2.9.5"
    const val timber = "4.7.1"

    const val appCompat = "1.0.0"
    const val fragment = "1.0.0"
    const val constraintLayout = "1.1.3"
    const val multidex = "1.0.0"
    const val ktx = "1.0.0"
    const val lifecycle = "2.0.0"

    const val hawk = "2.0.1"
    const val retrofit = "2.3.0"
    const val material = "1.0.0"
    const val leakcanary = "1.6.1"
    const val parceler = "1.1.11"
    const val okHttp = "3.8.0"
    const val espresso = "3.1.0"
    const val rxjava = "2.0.2"
    const val rxandroid = "1.2.1"
    const val rxpermissions = "0.10.2"
    const val dagger2 = "2.12"

    const val testCore = "1.0.0"
    const val junit = "1.0.0"
    const val runner = "1.1.0"
    const val rules = "1.1.0"
    const val mockito = "2.23.0"
}

object LibsPrefix {
    const val lifecycle = "androidx.lifecycle:lifecycle-"
    const val retrofit = "com.squareup.retrofit2:"
    const val okhttp3 = "com.squareup.okhttp3:"
    const val reactivex = "io.reactivex"
    const val dagger2 = "com.google.dagger:dagger"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-"
    const val parceler = "org.parceler:parceler"
}

object Libs {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}@aar"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val leakcanary = "${LibsPrefix.leakcanary}android:${Versions.leakcanary}"
    const val leakcanaryFragment = "${LibsPrefix.leakcanary}support-fragment:${Versions.leakcanary}"

    const val multidex = "com.android.support:multidex:${Versions.multidex}"

    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val design = "com.google.android.material:material:${Versions.material}"

    const val lifecycleViewModelKtx = "${LibsPrefix.lifecycle}viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions = "${LibsPrefix.lifecycle}extensions:${Versions.lifecycle}"
    const val lifecycleCompiler = "${LibsPrefix.lifecycle}compiler:${Versions.lifecycle}"

    const val retrofit = "${LibsPrefix.retrofit}retrofit:${Versions.retrofit}"
    const val retrofitConverterGson = "${LibsPrefix.retrofit}converter-gson:${Versions.retrofit}"
    const val retrofitRxJava2 = "${LibsPrefix.retrofit}adapter-rxjava2:${Versions.retrofit}"

    const val okhttp3 = "${LibsPrefix.okhttp3}okhttp:${Versions.okHttp}"
    const val okhttp3Interceptor = "${LibsPrefix.okhttp3}logging-interceptor:${Versions.okHttp}"

    const val rxjava2RxAndroid = "${LibsPrefix.reactivex}.rxjava2:rxandroid:${Versions.rxjava}"
    const val rxjava2Rxjava = "${LibsPrefix.reactivex}.rxjava2:rxjava:${Versions.rxjava}"
    const val rxandroid = "${LibsPrefix.reactivex}:rxandroid:${Versions.rxandroid}"

    const val rxPermissions = "com.github.tbruyelle:rxpermissions:${Versions.rxpermissions}"

    const val hawk = "com.orhanobut:hawk:${Versions.hawk}"

    const val dagger2 = "${LibsPrefix.dagger2}:${Versions.dagger2}"
    const val dagger2Compiler = "${LibsPrefix.dagger2}-compiler:${Versions.dagger2}"
    const val dagger2Android = "${LibsPrefix.dagger2}-android:${Versions.dagger2}"
    const val dagger2AndroidSupport = "${LibsPrefix.dagger2}-android-support:${Versions.dagger2}"
    const val dagger2Processor = "${LibsPrefix.dagger2}-android-processor:${Versions.dagger2}"

    const val parceler = "${LibsPrefix.parceler}-api:${Versions.parceler}"
    const val parcelerProcessor = "${LibsPrefix.parceler}:${Versions.parceler}"

    const val testCore = "androidx.test:core:${Versions.testCore}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val rules = "androidx.test:rules:${Versions.rules}"
    const val junit = "androidx.test.ext:junit:${Versions.junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
}

object ClassPaths {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val fabricPlugin = "io.fabric.tools:gradle:${Versions.fabric}"
}