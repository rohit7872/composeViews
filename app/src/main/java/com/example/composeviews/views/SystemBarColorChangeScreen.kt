import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

// Add depedency for this
// implementation "com.google.accompanist:accompanist-systemuicontroller:0.28.0"
@Composable
fun SystemBarColorChangeScreen(navController: NavController) {

    // 📌 Remember System UI Controller to control system bar colors
    val systemUiController = rememberSystemUiController()

    // 📌 Change status bar and navigation bar color using SideEffect
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Black, // Set your desired color here
            darkIcons = false // false = white icons, true = dark icons
        )
    }

    // 📌 Example UI
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "System Bar Color Example") })
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text(text = "Hello, World!", modifier = Modifier)
        }
    }
}


