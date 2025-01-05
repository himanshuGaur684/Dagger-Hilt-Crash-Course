package gaur.himanshu.daggerhiltcrashcourse.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@InstallIn(SingletonComponent::class)
@Module
object IntoSetModule {


    @IntoSet
    @Provides
    fun provideFirstString(): String = "first string"

    @IntoSet
    @Provides
    fun provideSecondString(): String = "second string"


}