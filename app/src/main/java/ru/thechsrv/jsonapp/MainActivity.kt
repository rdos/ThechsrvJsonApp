package ru.thechsrv.jsonapp

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import ru.thechsrv.jsonapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemReselectedListener,
    NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        INSTANCE = this
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding!!.button.setOnClickListener {
//            Log.d("AAA", "Onclick")
//        }
//
//        binding!!.button2.setOnClickListener {
//            Log.d("AAA", "Onclick")
//        }

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)


//        navController.
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_data,
                R.id.navigation_dashboard
            )
        )
        //BottomNavigationView workaround
//        navView.setOnItemSelectedListener(this)
        navView.setOnItemReselectedListener(this)

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_activity_main, fragment)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        //
//        val toolbar = supportActionBar;
//        navView.setOnItemSelectedListener{ item ->
//            var fragment: Fragment
//            when (item.itemId) {
//                R.id.navigation_home -> {
//                    toolbar?.setTitle(R.string.title_home)
//                    fragment = HomeFragment()
//                    loadFragment(fragment)
//                    true
//                }
//                R.id.navigation_dashboard -> {
//                    toolbar?.setTitle(R.string.title_dashboard)
//                    fragment = DashboardFragment()
//                    loadFragment(fragment)
//                    true
//
//                }
//                else -> false
//            }
//        }
        Log.d("AAA", "onBackPressed")
    }

    override fun onSupportNavigateUp()
        = findNavController(R.id.nav_host_fragment_activity_main).navigateUp()

//    companion object {
//        private var INSTANCE: MainActivity? = null
//
//        fun getBottomNavView(): BottomNavigationView? {
//            return INSTANCE?.binding?.bottomNavigationView
//        }
//
//    }

    override fun onNavigationItemReselected(item: MenuItem) {
//        TODO("Not yet implemented")
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d("AAA", "Not yet implemented")
        Log.d("AAA", "${item.itemId == R.id.navigation_blank}")

        return true
    }


//    override fun onSupportNavigateUp()
//            = findNavController(R.id.nav_host_fragment_activity_main).navigateUp()
}

//val Activity.botNavView: BottomNavigationView?
//    get() = MainActivity.getBottomNavView()
