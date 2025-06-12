import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController) {

    // Define the navigation host and initial screen
    NavHost(navController, startDestination = Screen.Home.route) {

        // Composable destination for Home Screen
        composable(Screen.Home.route) {
            HomeScreen()
        }

        // Composable destination for Profile Screen
        composable(Screen.Profile.route) {
            ProfileScreen()
        }

        // Composable destination for Settings Screen
        composable(Screen.Settings.route) {
            SettingsScreen()
        }
    }
}
