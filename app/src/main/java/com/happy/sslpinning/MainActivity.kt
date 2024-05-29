package com.happy.sslpinning


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.happy.maxyard.gson.login.LoginJson
import com.happy.sslpinning.databinding.ActivityMainBinding
import com.karumi.dexter.BuildConfig

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


class MainActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityMainBinding

    var userNameString :String=""
    var passwordString :String=""
    var successlogin:String = "0"
    lateinit var sharedPreferences : SharedPreferences
    var versionNoString : String = ""

    companion object
    {
        lateinit  var appContext: Context
    }

//    companion object
//    {
//        fun readTextFile(context: Context) : String?
//        {
//            var content : String? = ""
//            try {
//                val inputStream: InputStream = context.getResources().openRawResource(R.raw.maxvalue_certificate_03_04_2024)
//                val inputStreamReader = InputStreamReader(inputStream)
//                val sb = StringBuilder()
//                var line: String?
//
//                val br = BufferedReader(inputStreamReader)
//                line = br.readLine()
//                while (line != null) {
//                    sb.append(line)
//                    line = br.readLine()
//                }
//                br.close()
//
//                content = sb.toString()
//                Log.d("Log", content)
//
//            } catch (e:Exception){
//                Log.d("Log", e.toString())
//            }
//
//
//            return content
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MainActivity.appContext = applicationContext

        supportActionBar?.hide()

      //  sharedPreferences = this.getSharedPreferences(Const.Shared_Pref_name, MODE_PRIVATE)

        /**
         * version number
         */

        // on below line we are creating a variable and storing
        // our version name and version code.
        binding.versionNo.text = BuildConfig.VERSION_NAME
        Log.e("Log", "versionname" + BuildConfig.VERSION_NAME)

        versionNoString = BuildConfig.VERSION_NAME


        binding.loginButton.setOnClickListener {

            Log.e("Log", "InsideLoginButton")
            userNameString = binding.usernameET.text.toString().trim()
            Log.e("Log", "userNameString" + userNameString)
            passwordString = binding.passwordET.text.toString().trim()
            Log.e("Log", "passwordString" + passwordString)



            if (userNameString.isEmpty() || passwordString.isEmpty())
            {
                Log.e("Log", "userEmpty")
                Toast.makeText(this, "Please enter username or password", Toast.LENGTH_LONG).show()
            }
            else
            {
//                if (Fns.isInternetAvailable(this))
//                {
                    Log.e("Log", "isInternetAvailable")
                    getData(userNameString, passwordString, 1, versionNoString)

//                }
//                else
//                {
//                    Fns.neturalAlert("Alert", "No Internet Connected", this)
//                }
            }

        }
    }

    private fun getData(
        userNameString: String,
        passwordString: String,
        mobileLogin: Int,
        versionNo: String
    )
    {
        Log.e("Log", "getData")
        val apiService: ApiService = retrofit.create(ApiService::class.java)
        val registerInfo = LoginInputModel(userNameString, passwordString, mobileLogin, versionNo)

        apiService.registerUser(registerInfo).enqueue(object :
            Callback<LoginJson> {
            override fun onFailure(call: Call<LoginJson>, t: Throwable) {
                Log.e("Log", "onFailure" + t.message)
                Toast.makeText(
                    this@MainActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onResponse(call: Call<LoginJson>, response: Response<LoginJson>)
            {
                Log.e("Log", "responsecode" + response.code())

                if (response.code() == 200)
                {
                    Log.e("Log", "insideresponsecode200")

                    val addUser = response.body()

                    val status : Int? = addUser?.data?.loginResponseStatus?.get(0)?.status

                    if (status == 1)
                    {
                        // Saving token into sharedpreferences
//                        val tokenEdit = sharedPreferences.edit()
//                        tokenEdit.putString(Const.Shp_Token, addUser?.data?.token.toString())
//                        tokenEdit.putString(Const.Shp_USER_ID, addUser?.data?.loginResponseStatus?.get(0)?.loginID.toString())
//                        tokenEdit.putString(Const.Shp_IDYard, addUser?.data?.loginResponseStatus?.get(0)?.idYardMaster.toString()
//                        )
//                        tokenEdit.apply()
//
//                        intent = Intent(this@LoginActivity, MainMenuActivity::class.java)
//                        startActivity(intent)

                        intent = Intent(this@MainActivity, MainMenuActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_SHORT).show()

                    }
                    else
                    {
                        val statusMessage : String? = addUser?.data?.loginResponseStatus?.get(0)?.statusMessage

//                        val builder = AlertDialog.Builder(this@LoginActivity,R.style.CustomAlertDialog)
//                            .create()
//                        val view = layoutInflater.inflate(R.layout.customview_alert_layout,null)
//                        val  okButton = view.findViewById<ImageView>(R.id.ok_button)
//                        val  shareButton = view.findViewById<ImageView>(R.id.share_button)
//                        builder.setView(view)
//                        okButton.setOnClickListener {
//                            builder.cancel()
//                        }
//                        shareButton.setOnClickListener {
//                            // Creating intent with action send
//                            val intent = Intent(Intent.ACTION_SEND)
//
//                            // Setting Intent type
//                            intent.type = "text/plain"
//
//                            // Setting whatsapp package name
//                            intent.setPackage("com.whatsapp")
//
//                            // Give your message here
//                            intent.putExtra(Intent.EXTRA_TEXT, statusMessage)
//
//                            // Starting Whatsapp
//                            startActivity(intent)
//                        }
//
//                        builder.setCanceledOnTouchOutside(false)
//                        builder.show()

                        val builder = AlertDialog.Builder(this@MainActivity)
                        builder.setTitle("Alert")
                      //  builder.setIcon(R.drawable.loginwarning)
                        builder.setMessage(statusMessage)

                        builder.setPositiveButton("OK") { dialog, which ->

                            dialog.cancel()
                            //finish()
                        }

                        builder.setNegativeButton("Share") { dialog, which ->
                            // Creating intent with action send
                            val intent = Intent(Intent.ACTION_SEND)

                            // Setting Intent type
                            intent.type = "text/plain"

                            // Setting whatsapp package name
                            intent.setPackage("com.whatsapp")

                            // Give your message here
                            intent.putExtra(Intent.EXTRA_TEXT, statusMessage)

                            // Starting Whatsapp
                            startActivity(intent)


                        }
                        val dialog = builder.create()
                        dialog.show()


                    }


                }
                else
                {
                    Log.e("Log", "InsideElse")
                    Toast.makeText(this@MainActivity, "Registration failed!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })

    }

}