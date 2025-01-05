package gaur.himanshu.daggerhiltcrashcourse.binds

import javax.inject.Inject

interface BindsInterface {

    fun hello():String

}

class BindsInterfaceImpl @Inject constructor() : BindsInterface{
    override fun hello(): String {
        return "hello binds interface"
    }
}
