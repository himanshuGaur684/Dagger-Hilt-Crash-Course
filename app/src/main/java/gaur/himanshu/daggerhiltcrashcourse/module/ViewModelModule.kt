package gaur.himanshu.daggerhiltcrashcourse.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import gaur.himanshu.daggerhiltcrashcourse.model.Transmission

@InstallIn(ViewModelComponent::class)
@Module
object ViewModelModule {


    @Provides
    fun provideTransmission():Transmission = Transmission(name =  "viewmodel transmissoin")


}