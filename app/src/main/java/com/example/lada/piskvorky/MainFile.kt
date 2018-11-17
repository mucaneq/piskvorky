package com.example.lada.piskvorky

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_file.*
import java.util.*
import kotlin.collections.ArrayList

class MainFile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_file)


    }

    fun buClick(view:View)
    {
    val SelBut=view as Button
        var ButID=IntArray(2)
        ButID.set(0,0)
        ButID.set(1,0)
        when(SelBut.id)
        {

            R.id.b1 ->{ ButID[0]=0; ButID[1]=0;}
            R.id.b2 -> { ButID[0]=0; ButID[1]=1;}
            R.id.b3 -> { ButID[0]=0; ButID[1]=2;}
            R.id.b4 -> { ButID[0]=0; ButID[1]=3;}
            R.id.b5 -> { ButID[0]=0; ButID[1]=4;}
            R.id.b6 -> { ButID[0]=1; ButID[1]=0;}
            R.id.b7 -> { ButID[0]=1; ButID[1]=1;}
            R.id.b8 -> { ButID[0]=1; ButID[1]=2;}
            R.id.b9 -> { ButID[0]=1; ButID[1]=3;}

            R.id.b10 -> { ButID[0]=1; ButID[1]=4;}
            R.id.b11 -> { ButID[0]=2; ButID[1]=0;}
            R.id.b12 -> { ButID[0]=2; ButID[1]=1;}
            R.id.b13 -> { ButID[0]=2; ButID[1]=2;}
            R.id.b14 -> { ButID[0]=2; ButID[1]=3;}
            R.id.b15 -> { ButID[0]=2; ButID[1]=4;}
            R.id.b16 -> { ButID[0]=3; ButID[1]=0;}
            R.id.b17 -> { ButID[0]=3; ButID[1]=1;}
            R.id.b18 ->{ ButID[0]=3; ButID[1]=2;}
            R.id.b19 -> { ButID[0]=3; ButID[1]=3;}
            R.id.b20 -> { ButID[0]=3; ButID[1]=4;}
            R.id.b21 -> { ButID[0]=4; ButID[1]=0;}
            R.id.b22 -> { ButID[0]=4; ButID[1]=1;}
            R.id.b23 -> { ButID[0]=4; ButID[1]=2;}
            R.id.b24 -> { ButID[0]=4; ButID[1]=3;}
            R.id.b25 -> { ButID[0]=4; ButID[1]=4;}



        }

        playgame(ButID[0],ButID[1],SelBut)


    }

        var activePlayer=1
    var tabulkaP1= Array(5, {IntArray(5)})
    var tabulkaP2= Array(5, {IntArray(5)})



        fun playgame(x:Int,y:Int, buselected:Button)
        {
            if(activePlayer==1)
            {
                buselected.text="x"
                buselected.setBackgroundResource(R.color.Grill)
                buselected.isEnabled=false
                tabulkaP1[x][y]=1
                wincheck(activePlayer,x,y,tabulkaP1)
                activePlayer=2


            } else{

                buselected.text="o"
                buselected.setBackgroundResource(R.color.chcankaPink)
                buselected.isEnabled=false
                tabulkaP2[x][y]=1
                wincheck(activePlayer,x,y, tabulkaP2)
                activePlayer=1

            }

        }
        fun wincheck(player:Int, x:Int,y:Int, current:Array<IntArray>) {

            var pohyb = Array(8) { IntArray(2) }
            pohyb[0][0] = 0
            pohyb[0][1] = 1
            pohyb[1][0] = -1
            pohyb[1][1] = 1
            pohyb[2][0] = 1
            pohyb[2][1] = 1
            pohyb[3][0] = 1
            pohyb[3][1] = 0
            pohyb[4][0] = 1
            pohyb[4][1] = -1
            pohyb[5][0] = 0
            pohyb[5][1] = -1
            pohyb[6][0] = -1
            pohyb[6][1] = -1
            pohyb[7][0] = -1
            pohyb[7][1] = 0

            for (i in pohyb)
            {
              var count:Int=0
                var PuvX=i[0]
                var PuvY=i[1]
                var opak:Int=1
                while (true)
                {
                    if(x+(i[0]*opak)>=0&&x+(i[0]*opak)<5&&y+(i[1]*opak)>=0&&y+(i[1]*opak)<5){
                        if (current[x+ i[0]*opak][y+(i[1]*opak)]==1)
                    {
                      opak++
                        count++
                        if (count>=2)
                        {

                            val intent=Intent(this,photo_boi::class.java)

                            this!!.startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this).toBundle())

                        }
                    }
                    else break} else break
                }
                i[0]=PuvX
                i[1]=PuvY
                opak=1
                while (true)
                {

                    if(x-(i[0]*opak)>=0&&x-(i[0]*opak)<5&&y-(i[1]*opak)>=0&&y-(i[1]*opak)<5){
                    if (current[x-(i[0]*opak)][y-(i[1]*opak)]==1)
                    {

                            opak++

                        count++
                        if (count>=2)
                        {

                            val intent=Intent(this,photo_boi::class.java)

                            this!!.startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this).toBundle())

                        }
                    } else break}else break
                }


            }

        }



}
