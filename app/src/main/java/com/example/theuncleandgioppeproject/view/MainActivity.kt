package com.example.theuncleandgioppeproject.view

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
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
import android.nfc.*
import com.example.theuncleandgioppeproject.core.network.base.network.Constants.NFC_READ_COMMAND
import com.example.theuncleandgioppeproject.core.network.base.network.Constants.e
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
    private fun enableForegroundDispatch(activity: AppCompatActivity, adapter: NfcAdapter?) {
        val intent = Intent(activity.applicationContext, activity.javaClass)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val pendingIntent = PendingIntent.getActivity(
            activity.applicationContext,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val filters = arrayOfNulls<IntentFilter>(1)
        val techList = arrayOf<Array<String>>()
        filters[0] = IntentFilter()
        with(filters[0]) {
            this?.addAction(NfcAdapter.ACTION_NDEF_DISCOVERED)
            this?.addCategory(Intent.CATEGORY_DEFAULT)
            try {
                this?.addDataType("text/plain")
            } catch (ex: IntentFilter.MalformedMimeTypeException) {
                throw RuntimeException(e)
            }
        }
        adapter?.enableForegroundDispatch(activity, pendingIntent, filters, techList)
    }
    override fun onResume() {
        super.onResume()
        enableForegroundDispatch(this, this.nfcAdapter)
    }

}
