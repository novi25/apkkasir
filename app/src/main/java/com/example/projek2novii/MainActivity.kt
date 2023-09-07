package com.example.projek2novii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val NamaPelanggan = findViewById<EditText>(R.id.editNamaPelanggan)
        val namaBarang = findViewById<EditText>(R.id.editNamaBarang)
        val jumlahBeli = findViewById<EditText>(R.id.editJumlahBeli)
        val hargaSatuan = findViewById<EditText>(R.id.editHargaSatuan)
        val uangBayar = findViewById<EditText>(R.id.editUangBayar)
        val btnProcess = findViewById<Button>(R.id.btnProses)

        val txthargaTotal = findViewById<TextView>(R.id.txtHargaTotal)
        val txtUangKembali = findViewById<TextView>(R.id.txtUangKembali)
        val txtBonus = findViewById<TextView>(R.id.txtBonus)
        val txtKeterangan = findViewById<TextView>(R.id.txtKeterangan)
        val btnReset = findViewById<Button>(R.id.btnReset)


        btnProcess.setOnClickListener {
            var hargabarang = Integer.parseInt(hargaSatuan.text.toString())
            var jmlBarang = Integer.parseInt(jumlahBeli.text.toString())
            var hargaTotal = hargabarang * jmlBarang
            var uangBayar = Integer.parseInt(uangBayar.text.toString())
            var kembalian = uangBayar - hargaTotal

            txthargaTotal.text ="Harga total Rp." + hargaTotal
            txtUangKembali.text = "kembalian :" + if (kembalian<=0) "Tidak Ada" else kembalian

            if(hargaTotal >= 200000) {
                txtBonus.text ="Bonus Mouse"
            }else if(hargaTotal >= 400000){
                txtBonus.text ="Bonus Keyeboard"
                } else if(hargaTotal >= 600000){
                    txtBonus.text ="Harga Hardiks"
                } else {
                    txtBonus.text ="Bonus Tidak Ada"
                }

                if (kembalian ==0){
                    txtKeterangan.text ="Keterangan : Uang Pas"
                }else if  (kembalian >0){
                    txtKeterangan.text ="Keterangan: Menunggu Kembalian"
                }else{
                    txtKeterangan.text ="Keterangan : Uang Kurang" + abs(kembalian)
                }
        }

        btnReset.setOnClickListener{
            NamaPelanggan.setText("")
            namaBarang.setText("")
            jumlahBeli.setText("")
            hargaSatuan.setText("")
            uangBayar.setText("")
            txthargaTotal.text ="HargaTotal"
            txtUangKembali.text ="Kembalian"
            txtBonus.text= "Bonus"
            txtKeterangan.text="Keteragan"
        }

        }
    }
