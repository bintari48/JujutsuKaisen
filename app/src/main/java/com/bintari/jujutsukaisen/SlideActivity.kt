package com.bintari.jujutsukaisen

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bintari.jujutsukaisen.databinding.ActivitySlideBinding

class SlideActivity : AppCompatActivity() {
    private var idPengguna = ""

    companion object {
        const val PENGGUNA = "nama_pengguna"
        const val WEB_PREFIX = "https://github.com/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySlideBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_slide)

        idPengguna = intent?.extras?.getString(PENGGUNA).toString()

        title = "Hai $idPengguna"

        binding.teksDetailPengguna.text = idPengguna

        //perintah setOnClickListener itu untuk mengaktifkan button, jika buttonnya di klik maka akan pindah ke activaty berikutnya
        //Metode ini dipanggil bila pengguna menyentuh item (saat dalam mode sentuh). atau berfokus pada item dengan tombol navigasi atau trackball,
        // lalu menekan tombol "enter" yang sesuai atau menekan trackball.
        binding.tombolGithub.setOnClickListener { cekGithub() }
        binding.tombolTentang.setOnClickListener{ keTentangPengguna() }
    }

    // Untuk mendeklarasikan fungsi, gunakan kata kunci fun diikuti dengan nama ...
    // Anda dapat menetapkan penyetel tersebut sebagai private
    private fun keTentangPengguna() {
        val intentPengguna = Intent(this, HalamanActivity::class.java)
        startActivity(intentPengguna)
    }

    // Untuk mendeklarasikan fungsi, gunakan kata kunci fun diikuti dengan nama ...
    // Anda dapat menetapkan penyetel tersebut sebagai private
    private fun cekGithub() {
        val queryUrl: Uri = Uri.parse("$WEB_PREFIX${idPengguna}")
        val intent = Intent(Intent.ACTION_VIEW,queryUrl)
        startActivity(intent)
    }
}