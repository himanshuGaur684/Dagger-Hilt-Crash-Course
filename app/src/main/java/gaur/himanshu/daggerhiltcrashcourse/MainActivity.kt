package gaur.himanshu.daggerhiltcrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import gaur.himanshu.daggerhiltcrashcourse.binds.BindsInterface
import gaur.himanshu.daggerhiltcrashcourse.contentProvider.CustomContentProvider
import gaur.himanshu.daggerhiltcrashcourse.model.Car
import gaur.himanshu.daggerhiltcrashcourse.model.Engine
import gaur.himanshu.daggerhiltcrashcourse.ui.theme.DaggerHiltCrashCourseTheme
import gaur.himanshu.daggerhiltcrashcourse.viewmodel.AssistedViewModel
import gaur.himanshu.daggerhiltcrashcourse.viewmodel.MainViewModel
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var engine: Provider<Engine>

    @Inject
    lateinit var car: Car

    @Inject
    lateinit var bindsInterface: BindsInterface

    @Inject
    lateinit var setString : Set<String>

    @Inject
    lateinit var intoMapString:Map<String,String>


    @Inject
    lateinit var assistedInterface: AssistedViewModel.AssistedViewModelInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        contentResolver.query(CustomContentProvider.CONTENT_URI, null, null, null, null)

        enableEdgeToEdge()
        setContent {
            val assistedViewModel = assistedInterface.create("himanshu")
            val uiState by assistedViewModel.uiState.collectAsState()

            val viewModel = hiltViewModel<MainViewModel>()
            val transmission by viewModel._transmission.collectAsState()

            DaggerHiltCrashCourseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name =intoMapString.keys.joinToString(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerHiltCrashCourseTheme {
        Greeting("Android")
    }
}