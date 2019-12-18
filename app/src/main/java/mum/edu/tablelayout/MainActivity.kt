package mum.edu.tablelayout

import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addNewRow(v: View){
        // Create a new table row.
        val tableRow = TableRow(applicationContext)
        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT,50f)
        tableRow.setLayoutParams(layoutParams)
        // add values into row by calling addView()
        val codeView = TextView(this)
        codeView.text = codeName.text.toString()
        val version = TextView(this)
        version.text = versionNo.text.toString()
        codeView.layoutParams = layoutParams
        version.layoutParams = layoutParams
        tableRow.addView(version,0)
        tableRow.addView(codeView,1)

        // Finally add the created row row into layout
        tableLayout.addView(tableRow) // id from Layout_file
    }
}
