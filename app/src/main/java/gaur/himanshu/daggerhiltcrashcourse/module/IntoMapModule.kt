package gaur.himanshu.daggerhiltcrashcourse.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey

@InstallIn(SingletonComponent::class)
@Module
object IntoMapModule {

    @IntoMap
    @StringKey("first")
    @Provides
    fun provideFirstString(): String = "first string"

    @IntoMap
    @StringKey("second")
    @Provides
    fun provideSecondString(): String = "second string"
}