package gaur.himanshu.daggerhiltcrashcourse.model

import javax.inject.Inject
import javax.inject.Named

data class Car @Inject constructor(
    val engine: Engine,
    @Named("app") val transmission: Transmission
)
