package com.timearchitect.backstackjava25

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.timearchitect.backstackjava25.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     var frag = true
     lateinit var etOnActivity:EditText // klassens variabel
    lateinit var binding: ActivityMainBinding  // bindar Activity layout componenter som en klass

    companion object{   //static variabel som syns over package
        lateinit var etStatic:EditText
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
    }
        //binding sättet där det är en klass
        binding =  ActivityMainBinding.inflate(layoutInflater)
        binding.button3.setText("NEXT FRAGEMENT!!!")
        setContentView(binding.root)
        var str = "Hello World"
        str.let { println("$it!!") }



        etOnActivity = findViewById(R.id.editTextText)
        etStatic= findViewById(R.id.editTextText)
    var fragmentButton = findViewById<Button>(R.id.button3)

    var activityButton = findViewById<Button>(R.id.button2)
    var clearBackstackBtn = findViewById<Button>(R.id.button4)
        clearBackstackBtn.setOnClickListener {         //clear backstack
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
            if(frag) {
                var f:Fragment = BlankFragment2()
                var b:Bundle = Bundle()
                b.putString("name","Alrik He")
                f.arguments = b

                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, f, "next")
                    .addToBackStack("frag2")
                    .commit()
            }else
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView,BlankFragment(),"next")
                    .addToBackStack("frag1")
                    .commit()

            frag=!frag  //flip true/false
        }





        var st = "Hello World"
        st.let { Log.i("ALRIK", "$it  sig själv med extra här $it"); }


    }



}