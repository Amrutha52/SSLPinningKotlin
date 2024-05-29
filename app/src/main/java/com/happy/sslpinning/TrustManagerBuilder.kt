package com.happy.sslpinning

import javax.net.ssl.X509TrustManager
import java.security.cert.X509Certificate

object TrustManagerBuilder {
    fun trustAllCertificates(): X509TrustManager {
        return object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        }
    }
}

