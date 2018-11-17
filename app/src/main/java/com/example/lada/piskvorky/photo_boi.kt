package com.example.lada.piskvorky


import android.content.Context
import android.graphics.Rect
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_photo_boi.*
import kotlinx.coroutines.*
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;

class photo_boi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_boi)







        }













  fun savePhone(view: View)
{



    val cislo=editText.text.toString()
    val inicialy=editText2.text.toString()
    val path = Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_DCIM
    )
    val myFile = File(path, "kocicky.txt")
    val fOut = FileOutputStream(myFile, true)
    val myOutWriter = OutputStreamWriter(fOut)
    myOutWriter.append(inicialy+": "+cislo+" / ")
    myOutWriter.close()
    fOut.close()


Toast.makeText(this,"kočička uložena",Toast.LENGTH_SHORT).show()
}










}







