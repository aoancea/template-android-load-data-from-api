package com.example.template_android_load_data_from_api

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.template_android_load_data_from_api.api.ApiCall
import com.example.template_android_load_data_from_api.api.IApiCall
import com.example.template_android_load_data_from_api.models.Issue
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val apiCall: IApiCall = ApiCall()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    companion object {
        private const val LOG_TAG = "MainActivity"
    }
}
