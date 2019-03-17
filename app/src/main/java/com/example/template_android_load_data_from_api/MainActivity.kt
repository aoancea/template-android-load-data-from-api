package com.example.template_android_load_data_from_api

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.template_android_load_data_from_api.api.ApiCall
import com.example.template_android_load_data_from_api.api.IApiCall
import com.example.template_android_load_data_from_api.fragments.DashboardFragment
import com.example.template_android_load_data_from_api.fragments.HomeFragment
import com.example.template_android_load_data_from_api.fragments.NotificationsFragment
import com.example.template_android_load_data_from_api.models.Issue
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val apiCall: IApiCall = ApiCall()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                replaceFragment(DashboardFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                replaceFragment(NotificationsFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(HomeFragment())

        loadIssues()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun loadIssues() {
        apiCall.listIssues(object : ApiCall.CallbackInterface<List<Issue>> {
            override fun success(issues: List<Issue>) {
                // do something with 'issues' param

                var issuesPrevious: MutableList<Issue> = issues as MutableList<Issue>

                apiCall.listIssues(object : ApiCall.CallbackInterface<List<Issue>> {
                    override fun success(issues: List<Issue>) {
                        // do something with 'issues' param

                        issuesPrevious.addAll(issues)
                    }

                    override fun fail() {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })
            }

            override fun fail() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    companion object {
        private const val LOG_TAG = "MainActivity"
    }
}
