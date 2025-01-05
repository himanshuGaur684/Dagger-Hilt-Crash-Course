package gaur.himanshu.daggerhiltcrashcourse.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gaur.himanshu.daggerhiltcrashcourse.model.Engine
import gaur.himanshu.daggerhiltcrashcourse.model.Transmission
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideEngine(): Engine {
        return Engine("app module engine")
    }

    @Named("app")
    @Provides
    fun provideTransmission():Transmission = Transmission(name = "app module transmissoin")

}