object Dependencies {

    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}" }
    val lifecycleViewmodelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleRuntimeKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3:${Versions.composeMaterial3}" }
    val composeTestJunit4 by lazy { "junit:junit:${Versions.Junit4}" }
    val composeUiTestJunit4 by lazy { "androidx.compose.ui:ui-test-junit4" }
    val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest"}
    val composeNavigation by lazy { "androidx.navigation:navigation-compose:${Versions.composeNavigation}" }

    //daggerhilt
    val hiltAndroid by lazy {"com.google.dagger:hilt-android:${Versions.hilt}"}
    val hiltAndroidCompiler by lazy {"com.google.dagger:hilt-compiler:${Versions.hilt}"}
    val hiltCompiler by lazy {"androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"}
    val hiltNavigationCompose by lazy {"androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"}

    //network
    val retrofit by lazy {"com.squareup.retrofit2:retrofit:${Versions.retrofit}"}
    val okHttp by lazy {"com.squareup.okhttp:okhttp:${Versions.okhttp}"}
    val gsonConverter by lazy {"com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"}
    val moshi by lazy {"com.squareup.moshi:moshi-kotlin:${Versions.moshi}"}
    val moshiConverter by lazy {"com.squareup.retrofit2:converter-moshi:${Versions.moshi}"}
    val loggingInterceptor by lazy {"com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"}
}

object Modules {
    const val utilities = ":utilities"
}