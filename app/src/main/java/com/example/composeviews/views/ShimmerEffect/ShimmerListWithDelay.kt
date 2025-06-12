import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun ShimmerListWithDelay(navController: NavController) {
    // 📌 List to hold actual data after loading
    var itemList by remember { mutableStateOf(listOf<String>()) }

    // 📌 Manage loading state to control shimmer visibility
    var isLoading by remember { mutableStateOf(true) }

    // 📌 Simulate API loading with delay
    LaunchedEffect(key1 = true) {
        delay(5000) // Simulate 5 seconds loading time
        // Set data after loading
        itemList = List(20) { index -> "Item ${index + 1}" }
        isLoading = false // Stop shimmer after loading
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Shimmer List Example") }) }
    ) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {

            if (isLoading) {
                // 📌 Show shimmer placeholder list while loading
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(5) { // Showing 5 shimmer placeholders
                        ShimmerItem()
                    }
                }

            } else {
                // 📌 Show actual list after loading is complete
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(itemList) { item ->
                        RealListItem(item)
                    }
                }
            }
        }
    }
}


@Composable
fun RealListItem(item: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Text(text = item, color = Color.White, style = MaterialTheme.typography.h6)
    }
}
