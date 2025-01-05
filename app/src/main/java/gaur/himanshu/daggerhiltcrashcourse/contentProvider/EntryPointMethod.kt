package gaur.himanshu.daggerhiltcrashcourse.contentProvider

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gaur.himanshu.daggerhiltcrashcourse.model.Engine


@InstallIn(SingletonComponent::class)
@EntryPoint
interface EntryPointMethod {

    fun getEngine(): Engine

}
