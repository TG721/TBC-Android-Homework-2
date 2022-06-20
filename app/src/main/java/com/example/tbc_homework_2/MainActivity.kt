package com.example.tbc_homework_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val regularNumbers = listOf("ერთი", "ორი", "სამი", "ოთხი",
                                "ხუთი", "ექვსი", "შვიდი",
                                "რვა", "ცხრა"
                                )
    val numbersFrom10To19 = listOf("ათი", "თერთმეტი", "თორმეტი", "ცამეტი", "თოთხმეტი",
                                "თხუთმეტი", "თექვსმეტი", "ჩვიდმეტი", "თვრამეტი", "ცხრამეტი"
                                )

    val dozensNumbers = listOf("", "ოც", "ოც", "ორმოც", "ორმოც", "სამოც", "სამოც",
                                "ოთხმოც", "ოთხმოც"
                                )

    val hundredsNumbers = listOf("ას", "ორას", "სამას", "ოთხას", "ხუთას",
                                "ექვსას", "შვიდას", "რვაას", "ცხრაას"
                                )
    val i = "ი"
    val andWord = "და"
    val thousand = "ათასი"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNumber = findViewById<View>(R.id.editText) as TextView
        val outputNumber = findViewById<View>(R.id.textView) as TextView
        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            var inputNumberString = inputNumber.text.toString()
            if (inputNumberString == "1000")
                outputNumber.text = thousand
            else if (inputNumberString.length == 1)
                outputNumber.text = regularNumbers[inputNumberString.toInt() - 1]
            else if (inputNumberString.length < 4 && (  inputNumberString[inputNumberString.length-2]!='0' ) )
            {
                //the final output string value
                var ans = ""
                var temp = inputNumberString
                //inputNumberString will hold 2 digit part of actual input
                //if actual input number is 3 digit, it will be saves in temp variable
                if(inputNumberString.length==3)
                inputNumberString = inputNumberString.substring(1)
                if (inputNumberString[0]=='1')
                    ans = numbersFrom10To19[inputNumberString[1].toString().toInt()]
                else if(inputNumberString[0].toString().toInt()%2==0) {
                     ans = dozensNumbers[inputNumberString[0].toString().toInt()-1]  +
                            if (inputNumberString[1]=='0') {
                                i
                            } else {
                                andWord+regularNumbers[inputNumberString[1].toString().toInt() - 1]
                            }


                }
                else {
                     ans = dozensNumbers[inputNumberString[0].toString().toInt()-1] + andWord + numbersFrom10To19[inputNumberString[1].toString().toInt()]


                }
                if(temp.length==3)
                    ans= hundredsNumbers[temp[0].toString().toInt()-1] + " " + ans

                outputNumber.text = ans
            }

            else {
                if(inputNumberString[1]=='0' && inputNumberString[2]=='0' )
                    outputNumber.text = hundredsNumbers[inputNumberString[0].toString().toInt()-1] + i
                else outputNumber.text = hundredsNumbers[inputNumberString[0].toString().toInt()-1] + " " + regularNumbers[inputNumberString[2].toString().toInt() - 1]
            }

        }

    }
}