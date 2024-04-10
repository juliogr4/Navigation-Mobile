import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Route(val route: String, val icon: ImageVector, val title: String) {
    data object Home : Route(route = "Home", icon = Icons.Default.Home, title = "Home")
    data object Profile : Route(route = "Profile", icon = Icons.Default.Person, title =  "Profile")
    data object Notification : Route(route = "Notification", icon = Icons.Default.Notifications, title =  "Notification")
    data object Wallet : Route(route = "Wallet", icon = Icons.Default.Info,  title = "Wallet")
}