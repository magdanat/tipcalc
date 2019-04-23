package edu.washington.magdanat.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    var nonNum : Regex = Regex("[$,.]")
    var money : String = "0.00"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.buttonTip)
        var editText: EditText = findViewById(R.id.editText)
        // Reformats inputted text to a double that is reformatted into US currency
        val moneyFormat = NumberFormat.getCurrencyInstance(Locale.US)

        // Tip button is disabled on launch
        button.isEnabled = false

        editText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                Log.i(TAG, "The input has changed!")

                // Enables button
                button.isEnabled = true;

                // Remove listener to avoid crashing application
                editText.removeTextChangedListener(this)

                val temp = editText.text.toString().replace(nonNum, "").toDouble()
                val new = moneyFormat.format((temp / 100))


                editText.setText(new)

                // Places selection at the end
                editText.setSelection(editText.text.length)

                // Will remove all text if user removes all number values and disable the button again
                if (editText.text.toString().equals("$0.00")) {
                    editText.setText("")
                    button.isEnabled = false
                }

                // Adds listener back for new input changes
                editText.addTextChangedListener(this)
                money = new
            }

        })

        button.setOnClickListener {
            Log.i(TAG, "The button has been clicked!")

            val temp = money.replace(nonNum, "").toDouble()
            val newNum = temp * 0.15
            Toast.makeText(this, moneyFormat.format((newNum / 100)), Toast.LENGTH_SHORT).show()

        }
    }
}

