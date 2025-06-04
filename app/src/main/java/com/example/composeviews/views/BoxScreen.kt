
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
/**
 * BoxScreen.kt
 *
 * This screen demonstrates the use of the Jetpack Compose `Box` layout.
 * `Box` is used to stack elements (children) on top of each other or align
 * them relative to the parent using alignment parameters.
 *
 * ✅ Why use `Box`:
 * - Perfect for overlapping or layering views (like background + content).
 * - Allows fine-grained alignment of elements (e.g., top-start, center, bottom-end).
 * - Works well for designing cards, tooltips, badges, profile layouts, and more.
 *
 * 🔧 How it works:
 * - `BoxExample()` is the main composable for layout.
 * - `BackgroundBox()` creates a rounded background.
 * - `AlignedBox()` is a reusable composable that shows colored boxes aligned
 *    at different positions in the parent `Box`.
 * - All children are placed using `.align()` inside the parent `Box`.
 *
 * 🧭 Navigation:
 * - Add this screen to your navigation graph with `composable("box") { BoxScreen() }`
 * - Navigate from dashboard using: `navController.navigate("box")`
 *
 * 📦 Summary:
 * This example is modular, clean, and reusable — making it ideal for learning
 * how to organize UI layouts with Box in Jetpack Compose.
 */


/**
 * Entry point composable for this screen.
 * Connected to NavGraph.
 * Calls the main UI layout for Box demo.
 */
@Composable
fun BoxScreen(navController: NavController) {
    BoxExample()
}

/**
 * This function sets up the main layout using Box.
 * - Fills the screen
 * - Adds background and padding
 * - Adds three child boxes at different alignments
 */
@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .fillMaxSize()                     // Fills entire screen
            .background(Color(0xFFEFEFEF))     // Light background color
            .padding(16.dp)                    // Padding from screen edge
    ) {
        // Background layer
        BackgroundBox()

        // Three colored boxes placed using alignment
        AlignedBox(
            text = "Top Start",
            color = Color(0xFFEF5350),
            alignment = Alignment.TopStart
        )

        AlignedBox(
            text = "Center",
            color = Color(0xFF66BB6A),
            alignment = Alignment.Center
        )

        AlignedBox(
            text = "Bottom End",
            color = Color(0xFF42A5F5),
            alignment = Alignment.BottomEnd
        )
    }
}

/**
 * Creates a styled background inside the parent Box.
 * - Fills size of parent
 * - Rounded corners
 * - Light gray color
 */
@Composable
fun BackgroundBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp))     // Rounded corners
            .background(Color.LightGray)         // Light background
    )
}

/**
 * Reusable box with:
 * - Text
 * - Custom color
 * - Aligned to a specified position in parent Box
 *
 * @param text Label to show in the box
 * @param color Background color of the box
 * @param alignment Where to position this box inside the parent Box
 */
@Composable
fun AlignedBox(text: String, color: Color, alignment: Alignment) {
    Box(
        modifier = Modifier
            .size(140.dp)                           // Fixed size
            .clip(RoundedCornerShape(16.dp))       // Rounded corners
            .background(color)                     // Custom color
            .shadow(6.dp, RoundedCornerShape(16.dp)) // Shadow for elevation
    ) {
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.Center) // Center text inside box
        )
    }
}
