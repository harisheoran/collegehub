package com.sparrowbit.collegehub.ui

import android.content.Context
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.sparrowbit.collegehub.databinding.FragmentNotesPdfViewScreenBinding
import com.sparrowbit.collegehub.viewmodel.NetworkStateViewModel

class Notes_Pdf_view_screen : Fragment() {
    private lateinit var networkViewModel: NetworkStateViewModel
    private val args: Notes_Pdf_view_screenArgs by navArgs()
    private var _binding: FragmentNotesPdfViewScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesPdfViewScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = binding.pdfWebview
        val pdf_status = binding.pdfStatus

        if (hasInternetConnection()) {
            webView.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    webView.visibility = View.INVISIBLE
                    pdf_status.visibility = View.VISIBLE
                    pdf_status.imageAssetsFolder = "assets"
                    pdf_status.setAnimation("loading1.json")
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    pdf_status.visibility = View.GONE
                    webView.visibility = View.VISIBLE
                }

                override fun onReceivedError(
                    view: WebView?,
                    errorCode: Int,
                    description: String?,
                    failingUrl: String?
                ) {
                    webView.visibility = View.INVISIBLE
                    pdf_status.visibility = View.VISIBLE
                    pdf_status.imageAssetsFolder = "assets"
                    pdf_status.setAnimation("slow_internet.json")
                    pdf_status.loop(true)
                    pdf_status.playAnimation()
                }
            }
            binding.pdfStatus.visibility = View.GONE
            webView.loadUrl(args.link!!)
            webView.settings.javaScriptEnabled = true
            webView.settings.setSupportZoom(true)
        } else {
            webView.visibility = View.GONE
            pdf_status.visibility = View.VISIBLE
            pdf_status.imageAssetsFolder = "assets"
            pdf_status.setAnimation("no_internet.json")
            pdf_status.loop(true)
            pdf_status.playAnimation()
        }
    }

    private fun hasInternetConnection(): Boolean {
        val connectivityManager = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}