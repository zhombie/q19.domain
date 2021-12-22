package kz.q19.domain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kz.q19.domain.model.file.LocalFile
import kz.q19.domain.model.user.User
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = User(-1, "qwerty123")
        println(user)

        val d = LocalFile(File(""))
        d.get().delete()
    }
}