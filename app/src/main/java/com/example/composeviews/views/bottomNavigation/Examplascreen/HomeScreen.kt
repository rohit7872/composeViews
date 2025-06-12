import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(), // Fills entire screen
        contentAlignment = Alignment.Center // Centers content
    ) {
        Text(text = "Home Screen", fontSize = 24.sp) // Display screen title
    }
}
