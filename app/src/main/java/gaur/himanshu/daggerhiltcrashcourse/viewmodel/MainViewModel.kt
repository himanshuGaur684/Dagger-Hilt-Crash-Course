package gaur.himanshu.daggerhiltcrashcourse.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import gaur.himanshu.daggerhiltcrashcourse.model.Transmission
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val transmission: Transmission
) : ViewModel() {

    val _transmission = MutableStateFlow(Transmission(""))

    init {
        _transmission.update { transmission }
    }

}