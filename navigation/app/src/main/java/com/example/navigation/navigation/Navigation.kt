import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    startDestination: String = Route.Notification.route
) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier,
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Route.Home.route) { HomeScreen() }
            composable(route = Route.Wallet.route) { WalletScreen() }
            composable(route = Route.Notification.route) { NotificationScreen() }
            composable(route = Route.Profile.route) { ProfileScreen() }
        }
    }


}