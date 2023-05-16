package com.example.theuncleandgioppeproject.view

import android.content.Intent
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.nfc.tech.NfcA
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.theuncleandgioppeproject.R
import com.example.theuncleandgioppeproject.databinding.ActivityMainBinding
import com.example.theuncleandgioppeproject.utils.Constants.NFC_READ_COMMAND
import android.nfc.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private val nfcAdapter by lazy { NfcAdapter.getDefaultAdapter(this) }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        var tagFromIntent: Tag? = intent?.getParcelableExtra(NfcAdapter.EXTRA_TAG)
        val nfc = NfcA.get(tagFromIntent)
        val atqa: ByteArray = nfc.atqa
        val sak: Short = nfc.sak
        nfc.connect()
        val isConnected = nfc.isConnected

        if (isConnected) {
            val receivedData: ByteArray = nfc.transceive(NFC_READ_COMMAND)
        }else{
        Log.e("ans", "Not connected")
    }
}


override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
    navController = navHostFragment.navController

}
}
