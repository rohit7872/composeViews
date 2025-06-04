import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(title = { Text("Jetpack Compose Reference") })
    }) {
        Column(modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
            Button(onClick = { navController.navigate("box") }, modifier = Modifier.fillMaxWidth()) {
                Text("Text Demo")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("box") }, modifier = Modifier.fillMaxWidth()) {
                Text("Box Demo")
            }


            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("TextCustomizationScreen") }, modifier = Modifier.fillMaxWidth()) {
                Text("TextCustomizationScreen")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("ExpandedCardScreen") }, modifier = Modifier.fillMaxWidth()) {
                Text("Expanded Card")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("TextFieldScreen") }, modifier = Modifier.fillMaxWidth()) {
                Text("Text Field/Edit Text")
            }

        }
    }
}