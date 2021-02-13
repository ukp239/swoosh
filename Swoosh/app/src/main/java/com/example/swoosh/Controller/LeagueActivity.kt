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
    var selectedLeague = ""

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
            Toast.makeText(this, "Please select a league ", Toast.LENGTH_SHORT).show()
        }

    }

}