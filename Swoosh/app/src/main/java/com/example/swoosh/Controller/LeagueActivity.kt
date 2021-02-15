package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }


    var player = Player("", "")
    //var selectedLeague = ""

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player) //saving the player here; for orientation change
    } //this is done so that the Player variable is not lost when screen is rotated

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)!!
        }
    } //reading the player info here from previous instance of the activity

    fun onMensClicked (view: View){
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        //selectedLeague = "mens"
        player.league = "mens"

    }

    fun onWomensClicked (view: View){
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        //selectedLeague = "womens"
        player.league = "womens"
    }

    fun onCoedClicked (view: View){
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false
        //selectedLeague = "coed"
        player.league = "coed"
    }

    fun leagueNextBtnClicked(view: View) {
        if(player.league!= "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player) //Extra League is global constant
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league ", Toast.LENGTH_SHORT).show() //small pop up
        }

    }

}