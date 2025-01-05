package gaur.himanshu.daggerhiltcrashcourse

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import gaur.himanshu.daggerhiltcrashcourse.contentProvider.DaggerParentComponent

@HiltAndroidApp
class BaseApplication : Application() {

    val parentComponent by lazy {
        DaggerParentComponent.create()
    }

}