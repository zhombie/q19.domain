package kz.q19.domain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kz.garage.chat.model.reply_markup.button.TextButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = TextButton("qwerty123")
        println(button)
    }

}