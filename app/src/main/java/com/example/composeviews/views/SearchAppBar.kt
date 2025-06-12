import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun SearchAppBar(navController: NavController) {

    // 📌 Mutable state to hold the search query text
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    // Why: This allows Compose to recompose the UI whenever the search text changes.

    // 📌 Scaffold provides a basic screen structure with slots for topBar, content, etc.
    Scaffold(
        topBar = {
            // 📌 TopAppBar creates the standard app bar (toolbar) at the top of the screen.
            TopAppBar(
                title = {
                    // 📌 TextField allows user to input search text inside the app bar.
                    TextField(
                        value = searchQuery, // The current text in the search bar
                        onValueChange = { searchQuery = it }, // Updates searchQuery as user types
                        modifier = Modifier.fillMaxWidth(), // Makes the search bar take the full width of the app bar
                        placeholder = { Text(text = "Search...") }, // Shows hint text when the search bar is empty
                        singleLine = true, // Restricts the search bar to a single line of text
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = MaterialTheme.colors.surface // Matches app bar background color
                        )
                    )
                }
            )
        }
    ) {
        // 📌 Content of the screen goes here (optional)
        // Why: This is where you can display search results or other UI components.
    }
}
