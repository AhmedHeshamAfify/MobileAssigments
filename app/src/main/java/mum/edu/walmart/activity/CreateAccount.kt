package mum.edu.walmart.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.create_account.*
import mum.edu.walmart.R
import mum.edu.walmart.model.User


class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account)
    }

    fun onClickCreateNewAccount(v : View){
        if (firstName.text.toString() != "" && lastName.text.toString() != "" && email.text.toString() != "" && password.text.toString() != "") {
            val user = User(
                firstName.text.toString(),
                lastName.text.toString(),
                email.text.toString(),
                password.text.toString()
            )

            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        } else {
            Toast.makeText(this,"Please fill all data", Toast.LENGTH_LONG).show()
        }
    }
}