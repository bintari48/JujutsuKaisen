package com.bintari.jujutsukaisen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bintari.jujutsukaisen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //perintah setOnClickListener itu untuk mengaktifkan button, jika buttonnya di klik maka akan pindah ke activaty berikutnya
        //Metode ini dipanggil bila pengguna menyentuh item (saat dalam mode sentuh). atau berfokus pada item dengan tombol navigasi atau trackball,
        // lalu menekan tombol "enter" yang sesuai atau menekan trackball.
        binding.tombolLogin.setOnClickListener { cekPassword()
        }
    }

    private fun cekPassword() {
        val namaPengguna = binding.teksPengguna.text.toString()
        val passwordPengguna = binding.teksPassword.text.toString()

        if (namaPengguna.isEmpty() || passwordPengguna.isEmpty()) {
            Toast.makeText(this, "Mohon masukkan nama dan password", Toast.LENGTH_SHORT).show()
            return
        }

        if (namaPengguna == "bintari" && passwordPengguna == "123456") {
            val intent = Intent(this, SlideActivity::class.java)

            intent.putExtra("nama_pengguna", binding.teksPengguna.text.toString())

            startActivity(intent)

            finish()
        } else {
            Toast.makeText(this, "Nama atau password salah.", Toast.LENGTH_SHORT).show()
            return
        }
    }
}
