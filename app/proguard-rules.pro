########################################### Default ###########################################
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
-dontoptimize
-dontpreverify
-keepattributes *Annotation*

########################################### Keep Classes With Members ###########################################
-keepclasseswithmembers class * {
    @retrofit.http.* <methods>;
}

-keepclassmembers class cn.trinea.android.** { *; }
-keepclassmembers class ** {
    @com.squareup.otto.Subscribe public *;
    @com.squareup.otto.Produce public *;
}
########################################### Dontwarn ###########################################
-dontwarn com.squareup.okhttp.**
-dontwarn rx.**
-dontwarn retrofit.**
-dontwarn okio.**
-dontwarn cn.trinea.android.**

########################################### Keep Public Class ###########################################
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service

########################################### Keep Class ###########################################
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-keep class retrofit.** { *; }
-keep class cn.trinea.android.** { *; }
-keep class br.com.oi.futuro.interfaces.** { *; }
