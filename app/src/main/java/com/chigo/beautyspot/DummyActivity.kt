package com.chigo.beautyspot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.chigo.beautyspot.ui.ListAdapter
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.Volley
import com.chigo.beautyspot.data.Details
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_dummy.*
import org.json.JSONArray
import org.json.JSONObject

class DummyActivity : AppCompatActivity() {
    var adapter:ListAdapter?= null

    lateinit var requestQueue: RequestQueue
    private var data:ArrayList<Details>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dummy)

        data =ArrayList<Details>()
        val dis = Details("Name", true, 5, "address")

        rv_list.layoutManager = LinearLayoutManager(this)
//        data!!.add(dis)
//        adapter = ListAdapter(data!!)
        rv_list.adapter = adapter




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
    }


}
