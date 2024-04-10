import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

val items = listOf(
    Route.Home,
    Route.Wallet,
    Route.Notification,
    Route.Profile,
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                          navController.navigate(screen.route) {
                              popUpTo(navController.graph.findStartDestination().id) {
                                  saveState = true
                              }
                              launchSingleTop = true
                              restoreState = true
                          }
                },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.title,
                        tint = if(currentDestination?.hierarchy?.any { it.route == screen.route } == true) { Color.Yellow } else { Color.White },
                        modifier =
                            Modifier
                                .size(25.dp)
                    )
                },
                label = {
                    Text(
                        text = screen.title,
                        fontWeight = FontWeight.Bold,
                        color = if(currentDestination?.hierarchy?.any { it.route == screen.route } == true) { Color.Yellow } else { Color.White }
                    )
                }
            )
        }
    }
}