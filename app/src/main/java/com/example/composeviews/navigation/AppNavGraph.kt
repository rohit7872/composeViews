import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animatedsplashscreendemo.AnimatedSplashScreen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { DashboardScreen(navController) }
        composable("box") { BoxScreen(navController) }
        composable("TextCustomizationScreen") { TextCustomizationScreen(navController) }
        composable("ExpandedCardScreen") { ExpandedCardScreen(navController) }
        composable("TextFieldScreen") { AllTextFieldsScreen(navController) }
        composable("Buttons") { Buttons(navController) }
        composable("lazyColumnExample") { lazyColumnExample(navController) }
        composable("CustomeUi") { CustomeUi(navController) }
        composable("SearchAppBar") { SearchAppBar(navController) }
        composable("ShimmerListWithDelay") { ShimmerListWithDelay(navController) }
        composable("AnimatedSplashScreen") { AnimatedSplashScreen(navController) }
        composable("SystemBarColorChangeScreen") { SystemBarColorChangeScreen(navController) }
//        composable("text") { TextScreen() }
//        composable("button") { ButtonScreen() }

    }
}