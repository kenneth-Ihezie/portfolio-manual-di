package com.example.myportfolio.view

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myportfolio.R
import com.example.myportfolio.view.MainActivity.Companion.COST
import com.example.myportfolio.view.MainActivity.Companion.DATE
import com.example.myportfolio.view.MainActivity.Companion.ITEM
import com.example.myportfolio.view.MainActivity.Companion.TIME
import com.example.myportfolio.view.MainActivity.Companion.UPDATE
import com.example.myportfolio.viewmodel.PortfolioViewModel
import kotlinx.android.synthetic.main.activity_update.*
import java.text.SimpleDateFormat
import java.util.*

class UpdateActivity : AppCompatActivity() {
    private lateinit var portfolioViewModel: PortfolioViewModel
    private var mAdapter: PortfolioAdapter? = null
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

       // mAdapter = PortfolioAdapter(this, this)

        val itemReceived = intent.getStringExtra(ITEM)
        itemPort_update.setText(itemReceived)
        val costReceived = intent.getStringExtra(COST)
        costPort_update.setText(costReceived)
        val dateReceived = intent.getStringExtra(DATE)
        datePortfolio_update.setText(dateReceived)
        val timeReceived = intent.getStringExtra(TIME)
        timePort_update.text = timeReceived
        val updateInReceived = intent.getLongExtra(UPDATE, 0)

        portfolioViewModel = ViewModelProvider(this).get(PortfolioViewModel::class.java)
        portfolioViewModel.allPortfolios.observe(this, Observer {
        })
        timePort_update.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                val timeSet = SimpleDateFormat("HH:mm").format(cal.time)
                timePort_update.text = timeSet
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

        portfolio_addUpdate.setOnClickListener {
            if (TextUtils.isEmpty(itemPort_update.text) || TextUtils.isEmpty(costPort_update.text) || TextUtils.isEmpty(
                    timePort_update.text
                ) || TextUtils.isEmpty(datePortfolio_update.text)
            ) {
                Toast.makeText(this, "Portfolio field cant be empty", Toast.LENGTH_LONG).show()
            } else {
                val updatePortfolio = Intent(this, MainActivity::class.java)

                Log.d("ohh", "$updateInReceived")
                 portfolioViewModel.updatePortfolio( updateInReceived, itemPort_update.text.toString(), costPort_update.text.toString(), timePort_update.text.toString(), datePortfolio_update.text.toString())
                startActivity(updatePortfolio)
            }
            finish()
        }
    }
}

