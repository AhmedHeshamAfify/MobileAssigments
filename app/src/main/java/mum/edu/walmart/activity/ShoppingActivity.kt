package mum.edu.walmart.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.shopping_activity.*
import mum.edu.walmart.R
import mum.edu.walmart.model.User

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_activity)
        val intent = getIntent()
        val user =  intent.getSerializableExtra("user") as User
        userName.text = "Welcome ${user.firstName} !"
    }


}