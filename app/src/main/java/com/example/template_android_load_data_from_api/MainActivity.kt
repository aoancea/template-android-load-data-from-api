package com.example.template_android_load_data_from_api

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.example.template_android_load_data_from_api.adapters.AnimalAdapter
import com.example.template_android_load_data_from_api.api.ApiCall
import com.example.template_android_load_data_from_api.api.IApiCall
import com.example.template_android_load_data_from_api.models.Issue
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val apiCall: IApiCall = ApiCall()

    val animals: ArrayList<String> = ArrayList()

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

        // Loads animals into the ArrayList
        addAnimals()

        // Creates a vertical Layout Manager
        rv_animal_list.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it
        rv_animal_list.adapter = AnimalAdapter(animals, this)

        loadIssues()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun addAnimals() {
        animals.add("dog")
        animals.add("cat")
        animals.add("owl")
        animals.add("cheetah")
        animals.add("raccoon")
        animals.add("bird")
        animals.add("snake")
        animals.add("lizard")
        animals.add("hamster")
        animals.add("bear")
        animals.add("lion")
        animals.add("tiger")
        animals.add("horse")
        animals.add("frog")
        animals.add("fish")
        animals.add("shark")
        animals.add("turtle")
        animals.add("elephant")
        animals.add("cow")
        animals.add("beaver")
        animals.add("bison")
        animals.add("porcupine")
        animals.add("rat")
        animals.add("mouse")
        animals.add("goose")
        animals.add("deer")
        animals.add("fox")
        animals.add("moose")
        animals.add("buffalo")
        animals.add("monkey")
        animals.add("penguin")
        animals.add("parrot")
    }

    fun loadIssues() {
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

    companion object {
        private const val LOG_TAG = "MainActivity"
    }
}
