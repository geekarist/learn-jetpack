package me.cpele.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navController = findNavController(R.id.my_nav_host_fragment)

        navController.addOnNavigatedListener { controller, destination ->
            val isHome = controller.graph.startDestination == destination.id
            supportActionBar?.setDisplayHomeAsUpEnabled(!isHome)
        }
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()
}
