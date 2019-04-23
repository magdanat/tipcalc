package edu.washington.magdanat.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // If edittext isn't empty, enable button
        val button: Button = findViewById(R.id.buttonTip)
        val editText: EditText = findViewById(R.id.editText)

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
//                if (editText.text.isEmpty()) {
//                    button.isEnabled = false
//                } else {
//                    button.isEnabled = true
//                }
                button.isEnabled = editText.text.isEmpty()
                if (!editText.text.isEmpty()) {

                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun amount() {

    }

    private fun tipButton() {

    }

}
