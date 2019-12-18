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
        users = mutableListOf(User("jo","Ahmed","jo@gmail.com","1234"),
            User("Kalam","Ay","ay.kalam@gmail.com","4321"),
            User("7aga","7elwa","7aga.7elwa@gmail.com","9876"))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = getIntent()
        if (intent != null) {
            if (intent.getSerializableExtra("user") != null){
                val user : User = intent.getSerializableExtra("user") as User
                users = users.plus(user)
            }

        }
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
            email.error = "Please enter valid username"
        }
    }

    fun forgetPassword(v: View){
        val user:User? = users.filter {x -> x.userName.equals(email.text.toString())}.firstOrNull()
        if (user != null) {
            var intent = Intent()
            intent.action = Intent.ACTION_SEND

            intent.type = "text/plain"

            intent.putExtra(Intent.EXTRA_EMAIL, email.text.toString())
            intent.putExtra(Intent.EXTRA_SUBJECT, "Forget your password")
            intent.putExtra(Intent.EXTRA_TEXT, "Kindly find you password : ${user!!.password}")
            startActivity(Intent.createChooser(intent, "Send email..."))
        } else {
            email.error = "Please enter valid username"
        }

    }

    fun onClickCreateAccount(v : View){
        val intent = Intent(this,CreateAccount::class.java)
        startActivity(intent)

    }


}
