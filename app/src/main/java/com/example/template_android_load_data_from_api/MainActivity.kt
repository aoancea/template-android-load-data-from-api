package com.example.template_android_load_data_from_api

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.template_android_load_data_from_api.api.ApiCall
import com.example.template_android_load_data_from_api.api.IApiCall
import com.example.template_android_load_data_from_api.models.Issue
import com.example.template_android_load_data_from_api.models.MagicService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val apiCall: IApiCall = ApiCall()

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

        apiCall.listIssues(
            ApiCall.CallbackInterface<List<Issue>>() {

                @Override
                fun success(responseObj: List<Issue>) {

                    var issues: List<Issue> = responseObj

                }
            })

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
