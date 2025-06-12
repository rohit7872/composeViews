
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeviews.views.lazycoloumExample.DataPerson


@Composable
fun CustomItem(person: DataPerson) {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "${person.age}", // Dynamically showing age
            color = Color.Black,     // Text color
            fontSize = 24.sp,        // Font size
            fontWeight = FontWeight.Bold // Font weight
        )

        Text(
            text = person.firstName,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = person.lastName,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
    }
}


@Composable
@Preview
fun CustomItemPreview() {
    CustomItem(
        person = DataPerson(
            id = 0,
            firstName = "John",
            lastName = "Doe",
            age = 20
        )
    )
}