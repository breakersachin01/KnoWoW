package com.example.knowow

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.codemybrainsout.ratingdialog.RatingDialog
import com.google.ai.client.generativeai.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import org.json.JSONArray
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var randomCategory: TextView
    private lateinit var randomFact: TextView
    private lateinit var randomImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1000)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        randomCategory = findViewById(R.id.category)
        randomFact = findViewById(R.id.randomFact)
        randomImage = findViewById(R.id.randomFactImage)

        processdata()
        // Change the action bar color
        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.actColor)))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        menu?.findItem(R.id.myswitch)?.setActionView(R.layout.toggle_button);

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.refresh -> {
                processdata()
                true
            }

//            R.id.myswitch -> {
//                val switch = item.actionView?.findViewById<SwitchCompat>(R.id.switch_button)
//                switch?.setOnClickListener {
//                    if (switch.isSelected) {
//                        Toast.makeText(this, "Switch is off", Toast.LENGTH_SHORT).show()
//                        switch.isSelected = false
//                    } else {
//                        Toast.makeText(this, "Switch is on", Toast.LENGTH_SHORT).show()
//                        switch.isSelected = true
//                    }
//                }
//                true
//            }

            R.id.rate -> {

                val ratingDialog: RatingDialog = RatingDialog.Builder(this)
                    .threshold(3)
                    .onThresholdCleared { dialog, rating, thresholdCleared -> Log.i("rate", "onThresholdCleared: $rating $thresholdCleared") }
                    .onRatingBarFormSubmit { feedback -> Log.i("rate", "onRatingBarFormSubmit: $feedback") }
                    .onRatingChanged { rating, thresholdCleared -> Log.i("rate", "onRatingChanged: $rating $thresholdCleared")
                                        Toast.makeText(this, "Thank you for rating us $rating stars", Toast.LENGTH_SHORT).show()}
                    .build()
                ratingDialog.show()
                true
            }

            else -> false
        }
    }


    private fun processdata() {

        val stringReq = object : StringRequest(URL,
            { response ->
                Log.d("Responsemsg", response)
                val jsonArray = JSONArray(response)
                val jsonObj = jsonArray.getJSONObject(0)
                randomFact.text = jsonObj.getString("fact")
            },
            { error ->
                randomFact.text = "Error: $error"
            }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["X-Api-Key"] = "api_key"
                return headers
            }
        }
        val queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringReq)
    }

    companion object {
        const val URL = "https://api.api-ninjas.com/v1/facts";
    }

    fun scienceCard(view: View) {
        val scienceFactsArray = resources.getStringArray(R.array.science_facts_array)
        val intent = Intent(this, FactsSection::class.java).apply{
            putExtra("factsArray", scienceFactsArray)
            putExtra("category", "Science")
            putExtra("image", R.drawable.science)
        }
        startActivity(intent)
    }
    fun historicalCard(view: View) {
        val scienceFactsArray = resources.getStringArray(R.array.historical_facts_array)
        val intent = Intent(this, FactsSection::class.java).apply{
            putExtra("factsArray", scienceFactsArray)
            putExtra("category", "History")
            putExtra("image", R.drawable.history)
        }
        startActivity(intent)
    }
    fun technologyCard(view: View) {
        val scienceFactsArray = resources.getStringArray(R.array.technology_facts_array)
        val intent = Intent(this, FactsSection::class.java).apply{
            putExtra("factsArray", scienceFactsArray)
            putExtra("category", "Technology")
            putExtra("image", R.drawable.technology)
        }
        startActivity(intent)
    }
    fun natureCard(view: View) {
        val scienceFactsArray = resources.getStringArray(R.array.nature_facts_array)
        val intent = Intent(this, FactsSection::class.java).apply{
            putExtra("factsArray", scienceFactsArray)
            putExtra("category", "Nature")
            putExtra("image", R.drawable.nature)
        }
        startActivity(intent)
    }
    fun sportsCard(view: View) {
        val scienceFactsArray = resources.getStringArray(R.array.sports_facts_array)
        val intent = Intent(this, FactsSection::class.java).apply{
            putExtra("factsArray", scienceFactsArray)
            putExtra("category", "Sports")
            putExtra("image", R.drawable.sports)
        }
        startActivity(intent)
    }
    fun generalCard(view: View) {
        val scienceFactsArray = resources.getStringArray(R.array.general_facts_array)
        val intent = Intent(this, FactsSection::class.java).apply{
            putExtra("factsArray", scienceFactsArray)
            putExtra("category", "General")
            putExtra("image", R.drawable.general)
        }
        startActivity(intent)
    }
    fun codingCard(view: View) {
        val scienceFactsArray = resources.getStringArray(R.array.coding_facts_array)
        val intent = Intent(this, FactsSection::class.java).apply{
            putExtra("factsArray", scienceFactsArray)
            putExtra("category", "Coding")
            putExtra("image", R.drawable.coding)
        }
        startActivity(intent)
    }
    fun geographyCard(view: View) {
        val scienceFactsArray = resources.getStringArray(R.array.geography_facts_array)
        val intent = Intent(this, FactsSection::class.java).apply{
            putExtra("factsArray", scienceFactsArray)
            putExtra("category", "Geography")
            putExtra("image", R.drawable.geography)
        }
        startActivity(intent)
    }

}