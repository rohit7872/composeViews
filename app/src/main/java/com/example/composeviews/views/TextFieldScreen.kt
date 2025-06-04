import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff

@Composable
fun AllTextFieldsScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var description by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4))
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Text("All TextField Examples", fontSize = 22.sp, color = MaterialTheme.colorScheme.primary)

            // Basic TextField
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Basic TextField") },
                modifier = Modifier.fillMaxWidth()
            )

            // Outlined TextField with leading icon
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Address") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email Icon") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )

            // Password TextField with toggle visibility
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Lock Icon") },
                trailingIcon = {
                    val icon = if (showPassword) Icons.Default.VisibilityOff else Icons.Default.Visibility
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Icon(imageVector = icon, contentDescription = "Toggle Password")
                    }
                },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )

            // Multiline TextField
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Multiline Description") },
                maxLines = 4,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            // Error handling TextField
            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                    showError = it.length < 3
                },
                label = { Text("Username (min 3 chars)") },
                isError = showError,
                supportingText = {
                    if (showError) Text("Name must be at least 3 characters", color = Color.Red)
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Full Name") },
                placeholder = { Text("Enter your full name") },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "Name Icon")
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            // Submit Button
            Button(
                onClick = {
                    focusManager.clearFocus()
                    // Handle logic here (e.g. validation, save, navigate)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit All")
            }
        }
    }
}
