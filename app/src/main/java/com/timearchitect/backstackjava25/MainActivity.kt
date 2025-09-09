package com.timearchitect.backstackjava25

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
     var frag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
    }
    var fragmentButton = findViewById<Button>(R.id.button3)

    var activityButton = findViewById<Button>(R.id.button2)
    var clearBackstackBtn = findViewById<Button>(R.id.button4)
        //clear backstack
        clearBackstackBtn.setOnClickListener {
           // supportFragmentManager.clearBackStack("frag1")
            var i = Intent(this,MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        // supportFragmentManager.popBackStack()  // popa/backa 1
        }
        

        //byt activity
        activityButton.setOnClickListener {
            var i = Intent( this, MainActivity2::class.java )
            startActivity(i)
        }

        // byt fragment
        fragmentButton.setOnClickListener {
            if(frag)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView,BlankFragment2(),"next")
                .addToBackStack("frag2")
                .commit()
            else
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView,BlankFragment(),"next")
                    .addToBackStack("frag1")
                    .commit()

            frag=!frag  //flip true/false
        }




    }



}