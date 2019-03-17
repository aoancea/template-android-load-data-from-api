package com.example.template_android_load_data_from_api.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.template_android_load_data_from_api.R
import com.example.template_android_load_data_from_api.models.Team
import kotlinx.android.synthetic.main.item_team.view.*

class TeamStandingAdapter(private val teams: ArrayList<Team>, private val context: Context) :
    RecyclerView.Adapter<TeamStandingAdapter.TeamItemViewHolder>() {

    // Gets the number of teams in the list
    override fun getItemCount(): Int {
        return teams.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamItemViewHolder {
        return TeamItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_team, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: TeamItemViewHolder, position: Int) {

        var team: Team = teams[position]

        holder.tvTeamPosition.text = team.position
        holder.tvTeamGoals.text = team.goals
        holder.tvTeamName.text = team.name
        holder.tvTeamPlayedMatches.text = team.played_matches
        holder.tvTeamPoints.text = team.points
        holder.tvTeamWinLose.text = team.win_lose
    }

    class TeamItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each team property to the view
        val tvTeamPosition: TextView = view.team_position
        val tvTeamGoals: TextView = view.team_goals
        val tvTeamName: TextView = view.team_name
        val tvTeamPlayedMatches: TextView = view.team_played_matches
        val tvTeamPoints: TextView = view.team_points
        val tvTeamWinLose: TextView = view.team_win_lose
    }
}