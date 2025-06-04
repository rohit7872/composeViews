import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

/**
 * Entry point composable for the Text Customization screen.
 * This screen demonstrates various text styles, backgrounds, alignment, and a simple fade-in animation.
 *
 * @param navController NavController instance to enable navigation if needed (not used here directly).
 */
@Composable
fun TextCustomizationScreen(navController: NavController) {
    // 'visible' state controls whether the content is shown with animation.
    // 'remember' stores this state across recompositions.
    // 'mutableStateOf(false)' initializes it as false (hidden).
    var visible by remember { mutableStateOf(false) }

    // LaunchedEffect runs a suspend function when this composable enters composition.
    // Here, we delay 300ms before setting visible = true to trigger fade-in animation.
    LaunchedEffect(Unit) {
        delay(300) // Small delay for better animation effect.
        visible = true
    }

    // Outer Box to provide full screen size, background color, padding, and centered content alignment.
    Box(
        modifier = Modifier
            .fillMaxSize()                      // Fill the entire screen space.
            .background(Color(0xFFEAEAEA))     // Light gray background for contrast.
            .padding(16.dp),                   // Padding from screen edges.
        contentAlignment = Alignment.Center   // Center child content inside the Box.
    ) {
        // AnimatedVisibility shows/hides the content with an animation.
        // Here it fades in the Surface when 'visible' becomes true.
        AnimatedVisibility(visible = visible, enter = fadeIn()) {
            // Surface provides a material container with elevation and rounded corners.
            Surface(
                shape = RoundedCornerShape(20.dp),  // Rounded corners for modern look.
                shadowElevation = 10.dp,             // Shadow to lift the surface visually.
                modifier = Modifier
                    .fillMaxWidth()                  // Surface fills available width.
                    .heightIn(min = 200.dp)          // Minimum height so content has room.
                    .padding(16.dp),                 // Padding inside parent Box.
                color = Color.White                  // White background for surface.
            ) {
                // Column arranges children vertically with spacing and center alignment.
                Column(
                    modifier = Modifier
                        .fillMaxWidth()              // Fill full width of Surface.
                        .padding(20.dp),            // Padding inside Surface for content.
                    verticalArrangement = Arrangement.spacedBy(12.dp), // Space between texts.
                    horizontalAlignment = Alignment.CenterHorizontally // Center text horizontally.
                ) {
                    // Text 1: Bold, italic, large font size with a horizontal gradient background.
                    Text(
                        text = "Bold and Large Text with Gradient BG",
                        fontSize = 22.sp,                   // Larger font size.
                        fontWeight = FontWeight.Bold,      // Bold text weight.
                        fontStyle = FontStyle.Italic,      // Italic style for emphasis.
                        textAlign = TextAlign.Center,      // Center text horizontally.
                        color = Color.White,                // White text color for contrast.
                        modifier = Modifier
                            .fillMaxWidth()                // Fill the width of the column.
                            .background(                  // Background gradient brush.
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        Color(0xFF42A5F5),
                                        Color(0xFF66BB6A)
                                    ) // Blue to green gradient.
                                ),
                                shape = RoundedCornerShape(12.dp) // Rounded corners matching text container.
                            )
                            .padding(vertical = 16.dp, horizontal = 8.dp) // Padding inside background.
                    )

                    // Text 2: Uses MaterialTheme's typography for consistent styling.
                    Text(
                        text = "Styled with MaterialTheme.typography",
                        style = MaterialTheme.typography.headlineSmall, // Predefined Material style.
                        color = Color(0xFFEF5350),                        // Custom red color.
                        textAlign = TextAlign.Center,                     // Center text.
                        modifier = Modifier.fillMaxWidth()                // Fill width.
                    )

                    // Text 3: Simple centered text with normal font size.
                    Text(
                        text = "Center aligned normal text",
                        fontSize = 16.sp,                                 // Standard readable size.
                        textAlign = TextAlign.Center,                     // Center text.
                        modifier = Modifier.fillMaxWidth()                // Fill width.
                    )

                    //Text:4  Text selection and disselections
                    SelectionContainer {
                        Text(
                            text = "Hello, this text is selectetable")
                    }
                    // Text:5
                    DisableSelection {
                        Text(
                            text = "Hello, this text is Not selectetable")
                    }
                }
            }
        }
    }
}
