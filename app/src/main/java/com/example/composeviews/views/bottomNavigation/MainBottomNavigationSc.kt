import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainBottomNavigationSc(navController: NavController) {

    // Create a NavController to manage navigation
    val navController = rememberNavController()

    // Scaffold provides the layout structure (top bar, bottom bar, etc.)
    Scaffold(
        // Attach the BottomNavigationBar to the Scaffold's bottomBar slot
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        // Load the navigation graph inside the Scaffold content area
        BottomNavGraph(navController = navController)
    }
}
