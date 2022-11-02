package com.example.examratecalc

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.examratecalc.databinding.ActivityMainBinding
import java.text.DecimalFormat
var aRate: Float = 1.0F
var bRate: Float = 1.0F
var cRate: Float = 1.0F
var dRate: Float = 1.0F
var fRate: Float = 1.0F
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.compute.setOnClickListener { calculateRates() }
    }
    private fun calculateRates(){
        val df = DecimalFormat("#.##")
        val totalinput = binding.numStudents.text.toString().toFloat()
        val aInput= binding.studentWithAs.text.toString().toFloat()
        val bInput = binding.studentWithBs.text.toString().toFloat()
        val cInput= binding.studentWithCs.text.toString().toFloat()
        val dInput = binding.studentWithDs.text.toString().toFloat()
        val fInput = binding.studentWithFs.text.toString().toFloat()

        aRate = aInput/totalinput
        aRate = df.format(aRate).toFloat() * 100
        bRate = bInput/totalinput
        bRate = df.format(bRate).toFloat() * 100
        cRate = cInput/totalinput
        cRate = df.format(cRate).toFloat() * 100
        dRate= dInput/totalinput
        dRate = df.format(dRate).toFloat() * 100
        fRate= fInput/totalinput
        fRate = df.format(fRate).toFloat() * 100
        Log.d("Main", "working float $aRate")
        Log.d("Main", "working float $bRate")
        Log.d("Main", "working float $cRate")
        Log.d("Main", "working float $dRate")
        Log.d("Main", "working float $fRate")

        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Percentages of student's grade distribution are")
            .setMessage("As: $aRate% " +
                    "\nBs: $bRate%" +
                    "\nCs: $cRate%" +
                    "\nDs: $dRate%" +
                    "\nFs: $fRate%")

        val alert = dialogBuilder.create()
        alert.show()
        val handler = Handler()
        handler.postDelayed(Runnable {
                                     val intent = Intent(this,BarGraph::class.java)
            startActivity(intent)
        }, 1500)
    }
}
