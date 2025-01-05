package gaur.himanshu.daggerhiltcrashcourse.viewmodel

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import gaur.himanshu.daggerhiltcrashcourse.model.Engine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AssistedViewModel @AssistedInject constructor(
    private val engine: Engine,
    @Assisted  val userId: String
) : ViewModel() {

    private val _uiState = MutableStateFlow("")
    val uiState = _uiState.asStateFlow()

    init {

        _uiState.update { "initialize" }
    }


    @AssistedFactory
    interface AssistedViewModelInterface {

        fun create(userId: String): AssistedViewModel

    }


}