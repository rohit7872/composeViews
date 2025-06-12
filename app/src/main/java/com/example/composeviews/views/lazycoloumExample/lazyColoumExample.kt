import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeviews.views.lazycoloumExample.PersonRepository

@Composable

fun lazyColumnExample(navController: NavController) {
    val personRepository = remember { PersonRepository() }
    val getAllData = remember { personRepository.getAllData() }

    LazyColumn(
        contentPadding = PaddingValues(12.dp)
    ) {
        items(getAllData) { person ->
            CustomItem(person = person)
        }
    }
}
