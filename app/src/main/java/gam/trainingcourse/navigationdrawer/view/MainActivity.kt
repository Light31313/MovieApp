package gam.trainingcourse.navigationdrawer.view

import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import gam.trainingcourse.navigationdrawer.R
import gam.trainingcourse.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navDrawerView: NavigationView = binding.navDrawerView
        val navBottomView: BottomNavigationView = binding.navBottomView

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main)
        val navController = navHostFragment!!.findNavController()
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_game, R.id.nav_movie, R.id.nav_book, R.id.nav_music
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navDrawerView.setupWithNavController(navController)
        navBottomView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}