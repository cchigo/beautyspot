package com.chigo.beautyspot

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.chigo.beautyspot.data.Details
import com.chigo.beautyspot.ui.ListAdapter
import kotlinx.android.synthetic.main.activity_dummy.*
import kotlinx.android.synthetic.main.list_item.*
import org.json.JSONArray
import org.json.JSONObject



class DummyActivity : AppCompatActivity() {
    var adapter:ListAdapter?= null

    lateinit var requestQueue: RequestQueue
     private var data:ArrayList<Details>?=null
   // lateinit var ratingsLayout: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dummy)

        data =ArrayList<Details>()
        val dis = Details("Name", true, 5, "address")

        rv_list.layoutManager = LinearLayoutManager(this)
//        data!!.add(dis)
//        adapter = ListAdapter(data!!)
        rv_list.adapter = adapter

        //linear layout for stars
        //ratingsLayout = findViewById(R.id.ratings_layout)

        //val params: LinearLayout.LayoutParams =
            //LinearLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)






        val url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&types=food&name=harbour&key=AIzaSyDxeQW0YiShwDz1ireJ8e3hwM5EZ0M6CTE"

        requestQueue = Volley.newRequestQueue(this)

        var request = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener<JSONObject> {
                response ->

            var result: JSONArray = response.getJSONArray("results")
//            var name = ""
            for (i in 0 until result.length()){
                var jsonObject = result.getJSONObject(i)
                var name = jsonObject.getString("name")
                //val openObject = jsonObject.getJSONObject("opening_hours")
                val open = true //openObject.getBoolean("open_now")
                val rating = jsonObject.getInt("rating")
               // ratingBar.numStars = rating
                val address = jsonObject.getString("vicinity")

                data!!.add(Details(name, open, rating, address))
            }
            adapter = ListAdapter(data!!)
            rv_list.adapter = adapter
            adapter!!.notifyDataSetChanged()



//            adapter!!.items = data

        }, Response.ErrorListener {
            Log.e("Stuff", it.message)
        })

//        notifyDataSetChanged()

        requestQueue.add(request)
        //setStars()
    }

    fun setStars(){
        for(i in data!!.indices){
            val cur = data!![i]
            var no_of_stars:Int = cur.rating
            for (i in 0 until no_of_stars){

                var imageView = ImageView(this)
                imageView.setImageResource(R.drawable.ic_ful_star)
                //constraintLayout.addView(imageView)
                //ratingsLayout.addView(imageView)

            }
        }

    }


}
