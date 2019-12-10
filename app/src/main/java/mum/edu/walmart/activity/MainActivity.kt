package mum.edu.walmart.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.shopping_activity.*
import mum.edu.walmart.R
import mum.edu.walmart.model.User

class MainActivity : AppCompatActivity() {

    var users:List<User>

    init {
        users = mutableListOf(User("Ahmed","Ahmed","a.heshamafify@gmail.com","1234"),
            User("Kalam","Ay","ay.kalam@gmail.com","4321"),
            User("7aga","7elwa","7aga.7elwa@gmail.com","9876"))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun validateUser(v: View){
        if (email.text!= null && email.text.isNotBlank()){
            val user:User?  = users.filter {x -> x.userName.equals(email.text.toString())}.firstOrNull()
            if(user != null){
                val intent = Intent(this, ShoppingActivity::class.java)
                intent.putExtra("user",user)
                startActivityForResult(intent,1)
            } else{
                Toast.makeText(this,"User not found",Toast.LENGTH_LONG).show()
            }
        } else{
            Toast.makeText(this,"Please enter valid username",Toast.LENGTH_SHORT).show()
        }
    }

    fun forgetPassword(v: View){
        val user:User? = users.filter {x -> x.userName.equals(email.text.toString())}.firstOrNull()

        var emailIntent =  Intent(Intent.ACTION_SEND)
        emailIntent.putExtra(Intent.EXTRA_EMAIL,email.text.toString())
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Forget your password")
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Kindly find you password : ${user!!.password}")
        startActivity(emailIntent)

    }


}
