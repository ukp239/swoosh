package com.example.swoosh.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER

import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        //val league = intent.getStringExtra(EXTRA_LEAGUE)
        //val skill = intent.getStringExtra(EXTRA_SKILL)
        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        //searchLeaguesText.text = "Looking for a $league $skill near you..."
        if (player != null) {
            searchLeaguesText.text = "Looking for a ${player.league} ${player.skill} near you..."
        }
    }
}