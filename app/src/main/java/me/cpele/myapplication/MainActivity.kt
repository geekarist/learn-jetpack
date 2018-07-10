package me.cpele.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController

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

        setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater?.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val itemDest = navController.graph.find { dest -> dest.id == item?.itemId }

        if (itemDest != null) {
            navController.navigate(itemDest.id)
        } else {
            item?.itemId
                    ?.let { itemId -> navController.graph.getAction(itemId) }
                    ?.let { itemAction ->
                        navController.navigate(itemAction.destinationId)
                    }
        }

        return super.onOptionsItemSelected(item)
    }
}
