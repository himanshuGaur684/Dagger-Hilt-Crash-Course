package gaur.himanshu.daggerhiltcrashcourse.contentProvider

import dagger.Component
import dagger.Subcomponent
import gaur.himanshu.daggerhiltcrashcourse.module.AppModule

@Component(modules = [AppModule::class])
interface ParentComponent {

    fun childComponentFactory(): ChildComponent.Factory

}

@Subcomponent
interface ChildComponent {

    fun inject(customContentProvider: CustomContentProvider)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ChildComponent
    }

}
