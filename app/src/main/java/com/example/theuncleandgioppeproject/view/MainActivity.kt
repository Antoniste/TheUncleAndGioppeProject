package com.example.theuncleandgioppeproject.view
// nel main activity creiamo il lettore NFC di seguito vederemo come

import android.app.PendingIntent
import android.app.PendingIntent.FLAG_MUTABLE
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.nfc.tech.NfcF
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.theuncleandgioppeproject.R
import com.example.theuncleandgioppeproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
// qui andremo a dichiarare : il valore dell'array che all'interno chiama IntentFilter una lasse
    // internda dell'ide
    //IntentFilter è una classe in Android che definisce un pattern per le azioni degli Intent.
    // Gli Intent sono oggetti utilizzati per
    // avviare operazioni o comunicare tra componenti diversi dell'applicazione o tra diverse applicazioni.
    private var intentFiltersArray: Array<IntentFilter>? = null
    // questo valore fa si che possimo accedere  alle proprieta di nfcf cosi da poter scrivere sui dispositivi NFC
    private val techListsArray = arrayOf(arrayOf(NfcF::class.java.name))
    // questo valore ci permette di utilizzare direttamente LNfc adapter (mettendolo su lazy abbiamo la possibilita
    //di usarlo altrimenti rimane inattivo
    private val nfcAdapter: NfcAdapter? by lazy {
        NfcAdapter.getDefaultAdapter(this)
    }
    private var pendingIntent: PendingIntent? = null

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
// grazie al valore intetfilter possiamo chiamare gli intent nel nostro codice, come questo qui sotto
        val action = intent.action
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == action) {

            // tramite l'adapter andremo a chiamare il comando che ci permette di vedere il messaggio
            // che è scritto al interno nel NFC
            val parcelables = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)
            with(parcelables) {
                try {
                    val inNdefMessage = this?.get(0) as NdefMessage
                    val inNdefRecords = inNdefMessage.records
                    //if there are many records, you can call inNdefRecords[1] as array
                    val inMessage = String(inNdefRecords[0].payload)
                    val machineid = inMessage.drop(3);
// e displaiarlo sotto forma di toast
                    Toast.makeText(
                        applicationContext,
                        "The Bobbers is: $machineid",
                        Toast.LENGTH_SHORT
                    ).show()


                } catch (ex: Exception) {
                    Toast.makeText(
                        applicationContext,
                        "There is no information on the device please write and retry ",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
// facciamo partire il lettore NFC direttamente nel oncreate cosi da dare modo all'app di averlo sempre attivo
        //nfc process start
        pendingIntent = PendingIntent.getActivity(
            this, 0, Intent(this, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), FLAG_MUTABLE
        )
        val ndef = IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED)

        try {
            ndef.addDataType("text/plain")
        } catch (e: IntentFilter.MalformedMimeTypeException) {
            throw RuntimeException("fail", e)
        }

        intentFiltersArray = arrayOf(ndef)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
        navController = navHostFragment.navController
    }
    // quando l'app va in pausa e poi riprende a fuzionare la stessa cosa succede al nostro lettore
    override fun onResume() {
        super.onResume()
        nfcAdapter?.enableForegroundDispatch(
            this,
            pendingIntent,
            intentFiltersArray,
            techListsArray
        )
    }
// stessa cosa del paragrafo precedente solo che questa è quando l'untente entra in stato onpause si blocca
    // anche NFCreder
    override fun onPause() {
        if (this.isFinishing) {
            nfcAdapter?.disableForegroundDispatch(this)
        }
        super.onPause()
    }
}
