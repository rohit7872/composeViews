// Import required Jetpack Compose libraries
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

/**
 * This is the main Composable function that represents the screen showing the expandable card.
 * Called from the navigation graph.
 */
@Composable
fun ExpandedCardScreen(navController: NavController) {

    // Box is used to center the expandable card inside the screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4)) // Light grey background
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Reusable composable for the expandable card with icon
        ExpandedcardWithicon(
            title = "What is Jetpack Compose?",
            description = "Jetpack Compose is Android’s modern UI toolkit. It simplifies and accelerates UI development on Android with less code and powerful tools."
        )
    }
}

/**
 * Composable function to create an expandable/collapsible card with rotating icon.
 * @param title - Title to be shown on top
 * @param description - Detailed text shown when expanded
 */
@Composable
fun ExpandedcardWithicon(title: String, description: String) {
    // State variable to toggle expanded/collapsed state
    var expanded by remember { mutableStateOf(false) }

    // Animates the rotation of the arrow icon based on `expanded` state
    val rotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f, // 180 degrees when expanded
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
        label = "ArrowRotation"
    )

    // Surface is the card background with rounded corners and shadow
    Surface(
        shape = RoundedCornerShape(16.dp),
        tonalElevation = 4.dp,
        color = Color.White,
        shadowElevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded } // Toggle expand on click
            .animateContentSize( // Animates size change smoothly
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            )
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Title and icon row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.weight(1f) // Takes up remaining space
                )

                // Rotating arrow icon that indicates expand/collapse
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Expand Arrow",
                    modifier = Modifier
                        .size(24.dp)
                        .rotate(rotation) // Applies the animated rotation
                )
            }

            // Description shown only when expanded
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}
