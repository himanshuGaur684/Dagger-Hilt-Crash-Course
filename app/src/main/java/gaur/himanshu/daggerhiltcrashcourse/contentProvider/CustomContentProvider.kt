package gaur.himanshu.daggerhiltcrashcourse.contentProvider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log
import dagger.hilt.android.EntryPointAccessors
import gaur.himanshu.daggerhiltcrashcourse.BaseApplication
import gaur.himanshu.daggerhiltcrashcourse.model.Engine
import javax.inject.Inject

class CustomContentProvider : ContentProvider() {


    @Inject
    lateinit var engine: Engine

    companion object {
        val TABLE = "table"
        val AUTHORITY = "gaur.himanshu.content"
        val CONTENT_URI = Uri.parse("content://$AUTHORITY/$TABLE")

    }

    override fun onCreate(): Boolean {

        (context?.applicationContext as BaseApplication)
            .parentComponent
            .childComponentFactory()
            .create()
            .inject(this)

        val entryPoint =
            EntryPointAccessors.fromApplication(context!!, EntryPointMethod::class.java)



        Log.d("TAGGGGGGGGGG", "onCreate: ${entryPoint.getEngine().name}")

        return true
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        return null
    }

    override fun getType(p0: Uri): String? {
        return ""
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return Uri.EMPTY
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }
}