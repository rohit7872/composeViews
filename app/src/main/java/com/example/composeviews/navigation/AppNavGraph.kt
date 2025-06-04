import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { DashboardScreen(navController) }
        composable("box") { BoxScreen(navController) }
        composable("TextCustomizationScreen") { TextCustomizationScreen(navController) }
        composable("ExpandedCardScreen") { ExpandedCardScreen(navController) }
        composable("TextFieldScreen") { AllTextFieldsScreen(navController) }
//        composable("text") { TextScreen() }
//        composable("button") { ButtonScreen() }

    }
}