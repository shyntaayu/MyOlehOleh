package com.example.atry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.google.firebase.database.*

class ListActivity : AppCompatActivity() {

    lateinit var ref : DatabaseReference
    lateinit var list : MutableList<Users>
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        ref = FirebaseDatabase.getInstance().getReference("USERS")
        list = mutableListOf()
        listView = findViewById(R.id.listView)

        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){

                    list.clear()
                    for (h in p0.children){
                        val user = h.getValue(Users::class.java)
                        list.add(user!!)
                    }
                    Log.d("ada", list.toString())
                    val adapter = Adapter(this@ListActivity,R.layout.users,list)
                    listView.adapter = adapter
                }
            }
        })
    }
}
