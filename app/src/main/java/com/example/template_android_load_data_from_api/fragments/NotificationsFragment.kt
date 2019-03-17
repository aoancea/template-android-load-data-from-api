package com.example.template_android_load_data_from_api.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.template_android_load_data_from_api.R
import com.example.template_android_load_data_from_api.adapters.TeamStandingAdapter
import com.example.template_android_load_data_from_api.models.Team

import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    private val teams: ArrayList<Team> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Loads animals into the ArrayList
        addTeams()

        // Creates a vertical Layout Manager
        rv_team_standings.layoutManager = LinearLayoutManager(this.requireContext())

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it
        rv_team_standings.adapter = TeamStandingAdapter(teams, this.requireContext())
    }

    private fun addTeams() {
        teams.add(Team("#", "Team", "P", "W-L", "G", "PTS"))

        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
        teams.add(Team("1", "Team 1", "2", "4-3", "5", "45"))
        teams.add(Team("2", "Team 2", "3", "4-7", "2", "30"))
        teams.add(Team("3", "Team 3", "1", "1-8", "1", "7"))
    }
}