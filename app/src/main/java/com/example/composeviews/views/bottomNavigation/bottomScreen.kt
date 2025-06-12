import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composeviews.R

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", icon= Icons.Default.Home)
    object Profile : Screen("profile", "Profile", icon = Icons.Default.Person)
    object Settings : Screen("settings", "Settings", icon = Icons.Default.Settings)
}
