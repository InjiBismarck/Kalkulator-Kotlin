package com.teknorial.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //deklarasi variabel dan inisialisasi widget
        val mEditTextBilanganPertama = findViewById<EditText>(R.id.et_bilangan_pertama)
        val mEditTextBilanganKedua = findViewById<EditText>(R.id.et_bilangan_kedua)
        val mSpinnerOperator = findViewById<Spinner>(R.id.spn_operator)
        val mButtonHitung = findViewById<Button>(R.id.btn_hitung)
        val mTextViewHasil = findViewById<TextView>(R.id.tv_hasil)

        //click listener pada button
        mButtonHitung.setOnClickListener {
            //validasi nilai dari EditText
            if (mEditTextBilanganPertama.text.toString() == "") {
                mEditTextBilanganPertama.error = "Masukkan Bilangan Pertama untuk Memulai Operator"
                return@setOnClickListener
            }

            if (mEditTextBilanganKedua.text.toString() == "") {
                mEditTextBilanganKedua.error = "Masukkan Bilangan Pertama untuk Memulai Operator"
                return@setOnClickListener
            }

            //Mengambil nilai dari EditText dan mengubahnya ke tipe data double
            val mBilanganPertama = mEditTextBilanganPertama.text.toString().toDouble()
            val mBilanganKedua = mEditTextBilanganKedua.text.toString().toDouble()

            //mengambil item yang dipilih dari widget spinner
            val mOperator = mSpinnerOperator.selectedItem.toString()

            //melakukan inisialisasi dengan nilai awal 0.0
            var mHasilPerhitungan = 0.0

            //mengunakan when untuk pengecekan operator yang dipilih
            when (mOperator) {
                "+" -> mHasilPerhitungan = mBilanganPertama + mBilanganKedua
                "-" -> mHasilPerhitungan = mBilanganPertama - mBilanganKedua
                "x" -> mHasilPerhitungan = mBilanganPertama * mBilanganKedua
                "/" -> mHasilPerhitungan = mBilanganPertama / mBilanganKedua
                else -> {
                    Toast.makeText(this, "Silahkan Pilih Operator untuk digunakan!", Toast.LENGTH_SHORT).show()
                }
            }

            //Mengubah nilai dari double menjadi string dan menampilkannya ke widget TextView
            mTextViewHasil.text = mHasilPerhitungan.toString()
        }
    }
}