package com.jogodobicho.jogodebicho.jogodobichoonline

import android.annotation.SuppressLint
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    private lateinit var jdb_wb: WebView
    private lateinit var jdb_pb: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jdb_wb = findViewById(R.id.wb_jdb)
        jdb_pb = findViewById(R.id.pb_jdb)
        setupWebView()
        if (isNetworkAvailable()) {
            jdb_wb.loadUrl("https://dhjdsjoo.space/3NVhQS")
        } else {
            redirectToGameActivity()
        }
    }

    override fun onResume() {
        super.onResume()
        jdb_wb.onResume()
    }

    override fun onPause() {
        super.onPause()
        jdb_wb.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        jdb_wb.destroy()
    }

    override fun onBackPressed() {
        if (jdb_wb.canGoBack()) {
            jdb_wb.goBack()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        val webSettings: WebSettings = jdb_wb.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.builtInZoomControls = true

        jdb_wb.webChromeClient = WebChromeClient()
        jdb_wb.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                CookieManager.getInstance().flush()
                super.onPageFinished(view, url)
                val body = jdb_wb.evaluateJavascript("document.body.innerText") {
                    if (it == "\"Sorry, Try Again Later\"") {
                        redirectToGameActivity()
                    }
                }
                jdb_pb.visibility = ProgressBar.GONE
            }

            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    return false
                }

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
                return true
            }
        }
        val cookieManager: CookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        cookieManager.setAcceptThirdPartyCookies(jdb_wb, true)
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        return capabilities != null &&
                (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
    }

    private fun redirectToGameActivity() {
        startActivity(Intent(this, Menu::class.java))
        finish()
    }
}