import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Buttons(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 🔹 Google Button (Custom)
        GoogleButton(
            modifier = Modifier.padding(8.dp)
        ) {
            // Handle Google button click
        }

        // 🔹 Elevated Button
        ElevatedButton(
            onClick = { /* TODO */ }
        ) {
            Text("Elevated Button")
        }

        // 🔹 Filled Button (Regular Button)
        Button(
            onClick = { /* TODO */ }
        ) {
            Text("Filled Button")
        }

        // 🔹 Outlined Button
        OutlinedButton(
            onClick = { /* TODO */ }
        ) {
            Text("Outlined Button")
        }

        // 🔹 Text Button
        TextButton(
            onClick = { /* TODO */ }
        ) {
            Text("Text Button")
        }

        // 🔹 Icon Button
        IconButton(
            onClick = { /* TODO */ }
        ) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
        }

        // 🔹 Button with Icon and Text
        Button(
            onClick = { /* TODO */ }
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favorite",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("Button with Icon")
        }
    }
}


