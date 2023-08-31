package com.test.information.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import com.test.information.R


class dmcs_check_and_act_form_list : Fragment() {

  private lateinit var dmcsbtnsave: Button
  private lateinit var displaydmcsname: TextView
  private lateinit var positiondmcsname: TextView
//  private lateinit var iconshow: ImageView

  // dmcs form list 1
  private lateinit var DHNSA1: EditText
  private lateinit var DHNSB1: EditText
  private lateinit var DHNSC1: EditText
  private lateinit var DHNSD1: EditText

  private lateinit var DHNSA2: EditText
  private lateinit var DHNSB2: EditText
  private lateinit var DHNSC2: EditText
  private lateinit var DHNSD2: EditText

  private lateinit var DHNSA3: EditText
  private lateinit var DHNSB3: EditText
  private lateinit var DHNSC3: EditText
  private lateinit var DHNSD3: EditText

  private lateinit var DHNSA4: EditText
  private lateinit var DHNSB4: EditText
  private lateinit var DHNSC4: EditText
  private lateinit var DHNSD4: EditText

  private lateinit var DHNSA5: EditText
  private lateinit var DHNSB5: EditText
  private lateinit var DHNSC5: EditText
  private lateinit var DHNSD5: EditText

  private lateinit var DHNSA6: EditText
  private lateinit var DHNSB6: EditText
  private lateinit var DHNSC6: EditText
  private lateinit var DHNSD6: EditText

  private lateinit var DHNSA7: EditText
  private lateinit var DHNSB7: EditText
  private lateinit var DHNSC7: EditText
  private lateinit var DHNSD7: EditText

  // dmcs form list 2
  private lateinit var CBUA1: EditText
  private lateinit var CBUB1: EditText
  private lateinit var CBUC1: EditText
  private lateinit var CBUD1: EditText

  private lateinit var CBUA2: EditText
  private lateinit var CBUB2: EditText
  private lateinit var CBUC2: EditText
  private lateinit var CBUD2: EditText

  private lateinit var CBUA3: EditText
  private lateinit var CBUB3: EditText
  private lateinit var CBUC3: EditText
  private lateinit var CBUD3: EditText

  private lateinit var CBUA4: EditText
  private lateinit var CBUB4: EditText
  private lateinit var CBUC4: EditText
  private lateinit var CBUD4: EditText

  private lateinit var CBUA5: EditText
  private lateinit var CBUB5: EditText
  private lateinit var CBUC5: EditText
  private lateinit var CBUD5: EditText

  private lateinit var CBUA6: EditText
  private lateinit var CBUB6: EditText
  private lateinit var CBUC6: EditText
  private lateinit var CBUD6: EditText

  private lateinit var CBUA7: EditText
  private lateinit var CBUB7: EditText
  private lateinit var CBUC7: EditText
  private lateinit var CBUD7: EditText

  // dmcs form list 3
  private lateinit var MILOA1: EditText
  private lateinit var MILOB1: EditText
  private lateinit var MILOC1: EditText
  private lateinit var MILOD1: EditText

  private lateinit var MILOA2: EditText
  private lateinit var MILOB2: EditText
  private lateinit var MILOC2: EditText
  private lateinit var MILOD2: EditText

  private lateinit var MILOA3: EditText
  private lateinit var MILOB3: EditText
  private lateinit var MILOC3: EditText
  private lateinit var MILOD3: EditText

  private lateinit var MILOA4: EditText
  private lateinit var MILOB4: EditText
  private lateinit var MILOC4: EditText
  private lateinit var MILOD4: EditText

  private lateinit var MILOA5: EditText
  private lateinit var MILOB5: EditText
  private lateinit var MILOC5: EditText
  private lateinit var MILOD5: EditText

  private lateinit var MILOA6: EditText
  private lateinit var MILOB6: EditText
  private lateinit var MILOC6: EditText
  private lateinit var MILOD6: EditText

  private lateinit var MILOA7: EditText
  private lateinit var MILOB7: EditText
  private lateinit var MILOC7: EditText
  private lateinit var MILOD7: EditText


  // dmcs form list 4
  private lateinit var FADCA1: EditText
  private lateinit var FADCB1: EditText
  private lateinit var FADCC1: EditText
  private lateinit var FADCD1: EditText

  private lateinit var FADCA2: EditText
  private lateinit var FADCB2: EditText
  private lateinit var FADCC2: EditText
  private lateinit var FADCD2: EditText

  private lateinit var FADCA3: EditText
  private lateinit var FADCB3: EditText
  private lateinit var FADCC3: EditText
  private lateinit var FADCD3: EditText

  private lateinit var FADCA4: EditText
  private lateinit var FADCB4: EditText
  private lateinit var FADCC4: EditText
  private lateinit var FADCD4: EditText

  private lateinit var FADCA5: EditText
  private lateinit var FADCB5: EditText
  private lateinit var FADCC5: EditText
  private lateinit var FADCD5: EditText

  private lateinit var FADCA6: EditText
  private lateinit var FADCB6: EditText
  private lateinit var FADCC6: EditText
  private lateinit var FADCD6: EditText

  private lateinit var FADCA7: EditText
  private lateinit var FADCB7: EditText
  private lateinit var FADCC7: EditText
  private lateinit var FADCD7: EditText

  // dmcs form list 5
  private lateinit var RTDA1: EditText
  private lateinit var RTDB1: EditText
  private lateinit var RTDC1: EditText
  private lateinit var RTDD1: EditText

  private lateinit var RTDA2: EditText
  private lateinit var RTDB2: EditText
  private lateinit var RTDC2: EditText
  private lateinit var RTDD2: EditText

  private lateinit var RTDA3: EditText
  private lateinit var RTDB3: EditText
  private lateinit var RTDC3: EditText
  private lateinit var RTDD3: EditText

  private lateinit var RTDA4: EditText
  private lateinit var RTDB4: EditText
  private lateinit var RTDC4: EditText
  private lateinit var RTDD4: EditText

  private lateinit var RTDA5: EditText
  private lateinit var RTDB5: EditText
  private lateinit var RTDC5: EditText
  private lateinit var RTDD5: EditText

  private lateinit var RTDA6: EditText
  private lateinit var RTDB6: EditText
  private lateinit var RTDC6: EditText
  private lateinit var RTDD6: EditText

  private lateinit var RTDA7: EditText
  private lateinit var RTDB7: EditText
  private lateinit var RTDC7: EditText
  private lateinit var RTDD7: EditText

  // dmcs form list 6
  private lateinit var NESTEAA1: EditText
  private lateinit var NESTEAB1: EditText
  private lateinit var NESTEAC1: EditText
  private lateinit var NESTEAD1: EditText

  private lateinit var NESTEAA2: EditText
  private lateinit var NESTEAB2: EditText
  private lateinit var NESTEAC2: EditText
  private lateinit var NESTEAD2: EditText

  private lateinit var NESTEAA3: EditText
  private lateinit var NESTEAB3: EditText
  private lateinit var NESTEAC3: EditText
  private lateinit var NESTEAD3: EditText

  private lateinit var NESTEAA4: EditText
  private lateinit var NESTEAB4: EditText
  private lateinit var NESTEAC4: EditText
  private lateinit var NESTEAD4: EditText

  private lateinit var NESTEAA5: EditText
  private lateinit var NESTEAB5: EditText
  private lateinit var NESTEAC5: EditText
  private lateinit var NESTEAD5: EditText

  private lateinit var NESTEAA6: EditText
  private lateinit var NESTEAB6: EditText
  private lateinit var NESTEAC6: EditText
  private lateinit var NESTEAD6: EditText

  private lateinit var NESTEAA7: EditText
  private lateinit var NESTEAB7: EditText
  private lateinit var NESTEAC7: EditText
  private lateinit var NESTEAD7: EditText

  // dmcs form list 7
  private lateinit var BRKFSTCREALSA1: EditText
  private lateinit var BRKFSTCREALSB1: EditText
  private lateinit var BRKFSTCREALSC1: EditText
  private lateinit var BRKFSTCREALSD1: EditText

  private lateinit var BRKFSTCREALSA2: EditText
  private lateinit var BRKFSTCREALSB2: EditText
  private lateinit var BRKFSTCREALSC2: EditText
  private lateinit var BRKFSTCREALSD2: EditText

  private lateinit var BRKFSTCREALSA3: EditText
  private lateinit var BRKFSTCREALSB3: EditText
  private lateinit var BRKFSTCREALSC3: EditText
  private lateinit var BRKFSTCREALSD3: EditText

  private lateinit var BRKFSTCREALSA4: EditText
  private lateinit var BRKFSTCREALSB4: EditText
  private lateinit var BRKFSTCREALSC4: EditText
  private lateinit var BRKFSTCREALSD4: EditText

  private lateinit var BRKFSTCREALSA5: EditText
  private lateinit var BRKFSTCREALSB5: EditText
  private lateinit var BRKFSTCREALSC5: EditText
  private lateinit var BRKFSTCREALSD5: EditText

  private lateinit var BRKFSTCREALSA6: EditText
  private lateinit var BRKFSTCREALSB6: EditText
  private lateinit var BRKFSTCREALSC6: EditText
  private lateinit var BRKFSTCREALSD6: EditText

  private lateinit var BRKFSTCREALSA7: EditText
  private lateinit var BRKFSTCREALSB7: EditText
  private lateinit var BRKFSTCREALSC7: EditText
  private lateinit var BRKFSTCREALSD7: EditText

  // dmcs form list 8
  private lateinit var INFNTNUTRITIONA1: EditText
  private lateinit var INFNTNUTRITIONB1: EditText
  private lateinit var INFNTNUTRITIONC1: EditText
  private lateinit var INFNTNUTRITIOND1: EditText

  private lateinit var INFNTNUTRITIONA2: EditText
  private lateinit var INFNTNUTRITIONB2: EditText
  private lateinit var INFNTNUTRITIONC2: EditText
  private lateinit var INFNTNUTRITIOND2: EditText

  private lateinit var INFNTNUTRITIONA3: EditText
  private lateinit var INFNTNUTRITIONB3: EditText
  private lateinit var INFNTNUTRITIONC3: EditText
  private lateinit var INFNTNUTRITIOND3: EditText

  private lateinit var INFNTNUTRITIONA4: EditText
  private lateinit var INFNTNUTRITIONB4: EditText
  private lateinit var INFNTNUTRITIONC4: EditText
  private lateinit var INFNTNUTRITIOND4: EditText

  private lateinit var INFNTNUTRITIONA5: EditText
  private lateinit var INFNTNUTRITIONB5: EditText
  private lateinit var INFNTNUTRITIONC5: EditText
  private lateinit var INFNTNUTRITIOND5: EditText

  private lateinit var INFNTNUTRITIONA6: EditText
  private lateinit var INFNTNUTRITIONB6: EditText
  private lateinit var INFNTNUTRITIONC6: EditText
  private lateinit var INFNTNUTRITIOND6: EditText

  private lateinit var INFNTNUTRITIONA7: EditText
  private lateinit var INFNTNUTRITIONB7: EditText
  private lateinit var INFNTNUTRITIONC7: EditText
  private lateinit var INFNTNUTRITIOND7: EditText

  // dmcs form list 9
  private lateinit var CONFECTIONERYA1: EditText
  private lateinit var CONFECTIONERYB1: EditText
  private lateinit var CONFECTIONERYC1: EditText
  private lateinit var CONFECTIONERYD1: EditText

  private lateinit var CONFECTIONERYA2: EditText
  private lateinit var CONFECTIONERYB2: EditText
  private lateinit var CONFECTIONERYC2: EditText
  private lateinit var CONFECTIONERYD2: EditText

  private lateinit var CONFECTIONERYA3: EditText
  private lateinit var CONFECTIONERYB3: EditText
  private lateinit var CONFECTIONERYC3: EditText
  private lateinit var CONFECTIONERYD3: EditText

  private lateinit var CONFECTIONERYA4: EditText
  private lateinit var CONFECTIONERYB4: EditText
  private lateinit var CONFECTIONERYC4: EditText
  private lateinit var CONFECTIONERYD4: EditText

  private lateinit var CONFECTIONERYA5: EditText
  private lateinit var CONFECTIONERYB5: EditText
  private lateinit var CONFECTIONERYC5: EditText
  private lateinit var CONFECTIONERYD5: EditText

  private lateinit var CONFECTIONERYA6: EditText
  private lateinit var CONFECTIONERYB6: EditText
  private lateinit var CONFECTIONERYC6: EditText
  private lateinit var CONFECTIONERYD6: EditText

  private lateinit var CONFECTIONERYA7: EditText
  private lateinit var CONFECTIONERYB7: EditText
  private lateinit var CONFECTIONERYC7: EditText
  private lateinit var CONFECTIONERYD7: EditText

  // dmcs form list 10
  private lateinit var OTHERITEMSA1: EditText
  private lateinit var OTHERITEMSB1: EditText
  private lateinit var OTHERITEMSC1: EditText
  private lateinit var OTHERITEMSD1: EditText

  private lateinit var OTHERITEMSA2: EditText
  private lateinit var OTHERITEMSB2: EditText
  private lateinit var OTHERITEMSC2: EditText
  private lateinit var OTHERITEMSD2: EditText

  private lateinit var OTHERITEMSA3: EditText
  private lateinit var OTHERITEMSB3: EditText
  private lateinit var OTHERITEMSC3: EditText
  private lateinit var OTHERITEMSD3: EditText

  private lateinit var OTHERITEMSA4: EditText
  private lateinit var OTHERITEMSB4: EditText
  private lateinit var OTHERITEMSC4: EditText
  private lateinit var OTHERITEMSD4: EditText

  private lateinit var OTHERITEMSA5: EditText
  private lateinit var OTHERITEMSB5: EditText
  private lateinit var OTHERITEMSC5: EditText
  private lateinit var OTHERITEMSD5: EditText

  // dmcs form list 10
  private lateinit var BDDATOPIC1: EditText
  private lateinit var BDDATOPIC2: EditText
  private lateinit var BDDATOPIC3: EditText
  private lateinit var BDDATOPIC4: EditText
  private lateinit var BDDATOPIC5: EditText
  private lateinit var BDDATOPIC6: EditText
  private lateinit var BDDATOPIC7: EditText

  private  lateinit var BDDAA1: EditText
  private  lateinit var BDDAB1: EditText
  private  lateinit var BDDAC1: EditText
  private  lateinit var BDDAD1: EditText

  private  lateinit var BDDAA2: EditText
  private  lateinit var BDDAB2: EditText
  private  lateinit var BDDAC2: EditText
  private  lateinit var BDDAD2: EditText

  private  lateinit var BDDAA3: EditText
  private  lateinit var BDDAB3: EditText
  private  lateinit var BDDAC3: EditText
  private  lateinit var BDDAD3: EditText

  private  lateinit var BDDAA4: EditText
  private  lateinit var BDDAB4: EditText
  private  lateinit var BDDAC4: EditText
  private  lateinit var BDDAD4: EditText

  private  lateinit var BDDAA5: EditText
  private  lateinit var BDDAB5: EditText
  private  lateinit var BDDAC5: EditText
  private  lateinit var BDDAD5: EditText

  private  lateinit var BDDAA6: EditText
  private  lateinit var BDDAB6: EditText
  private  lateinit var BDDAC6: EditText
  private  lateinit var BDDAD6: EditText

  private  lateinit var BDDAA7: EditText
  private  lateinit var BDDAB7: EditText
  private  lateinit var BDDAC7: EditText
  private  lateinit var BDDAD7: EditText

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {

    }
  }


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    var v:View = inflater.inflate(R.layout.fragment_dmcs_check_and_act_form_list, container, false)

    dmcsbtnsave = v.findViewById(R.id.btn_dmcssave)
    positiondmcsname = v.findViewById(R.id.positiondmcsname)
    displaydmcsname = v.findViewById(R.id.displaydmcsname)
//    iconshow = v.findViewById(R.id.iconhidden)

    // EditText in dmcs form list 1
    DHNSA1 = v.findViewById(R.id.DHNSA1)
    DHNSB1 = v.findViewById(R.id.DHNSB1)
    DHNSC1 = v.findViewById(R.id.DHNSC1)
    DHNSD1 = v.findViewById(R.id.DHNSD1)

    DHNSA2 = v.findViewById(R.id.DHNSA2)
    DHNSB2 = v.findViewById(R.id.DHNSB2)
    DHNSC2 = v.findViewById(R.id.DHNSC2)
    DHNSD2 = v.findViewById(R.id.DHNSD2)

    DHNSA3 = v.findViewById(R.id.DHNSA3)
    DHNSB3 = v.findViewById(R.id.DHNSB3)
    DHNSC3 = v.findViewById(R.id.DHNSC3)
    DHNSD3 = v.findViewById(R.id.DHNSD3)

    DHNSA4 = v.findViewById(R.id.DHNSA4)
    DHNSB4 = v.findViewById(R.id.DHNSB4)
    DHNSC4 = v.findViewById(R.id.DHNSC4)
    DHNSD4 = v.findViewById(R.id.DHNSD4)

    DHNSA5 = v.findViewById(R.id.DHNSA5)
    DHNSB5 = v.findViewById(R.id.DHNSB5)
    DHNSC5 = v.findViewById(R.id.DHNSC5)
    DHNSD5 = v.findViewById(R.id.DHNSD5)

    DHNSA6 = v.findViewById(R.id.DHNSA6)
    DHNSB6 = v.findViewById(R.id.DHNSB6)
    DHNSC6 = v.findViewById(R.id.DHNSC6)
    DHNSD6 = v.findViewById(R.id.DHNSD6)

    DHNSA7 = v.findViewById(R.id.DHNSA7)
    DHNSB7 = v.findViewById(R.id.DHNSB7)
    DHNSC7 = v.findViewById(R.id.DHNSC7)
    DHNSD7 = v.findViewById(R.id.DHNSD7)

    // EditText in dmcs form list 2
    CBUA1 = v.findViewById(R.id.CBUA1)
    CBUB1 = v.findViewById(R.id.CBUB1)
    CBUC1 = v.findViewById(R.id.CBUC1)
    CBUD1 = v.findViewById(R.id.CBUD1)

    CBUA2 = v.findViewById(R.id.CBUA2)
    CBUB2 = v.findViewById(R.id.CBUB2)
    CBUC2 = v.findViewById(R.id.CBUC2)
    CBUD2 = v.findViewById(R.id.CBUD2)

    CBUA3 = v.findViewById(R.id.CBUA3)
    CBUB3 = v.findViewById(R.id.CBUB3)
    CBUC3 = v.findViewById(R.id.CBUC3)
    CBUD3 = v.findViewById(R.id.CBUD3)

    CBUA4 = v.findViewById(R.id.CBUA4)
    CBUB4 = v.findViewById(R.id.CBUB4)
    CBUC4 = v.findViewById(R.id.CBUC4)
    CBUD4 = v.findViewById(R.id.CBUD4)

    CBUA5 = v.findViewById(R.id.CBUA5)
    CBUB5 = v.findViewById(R.id.CBUB5)
    CBUC5 = v.findViewById(R.id.CBUC5)
    CBUD5 = v.findViewById(R.id.CBUD5)

    CBUA6 = v.findViewById(R.id.CBUA6)
    CBUB6 = v.findViewById(R.id.CBUB6)
    CBUC6 = v.findViewById(R.id.CBUC6)
    CBUD6 = v.findViewById(R.id.CBUD6)

    CBUA7 = v.findViewById(R.id.CBUA7)
    CBUB7 = v.findViewById(R.id.CBUB7)
    CBUC7 = v.findViewById(R.id.CBUC7)
    CBUD7 = v.findViewById(R.id.CBUD7)

    // EditText in dmcs form list 3
    MILOA1 = v.findViewById(R.id.MILOA1)
    MILOB1 = v.findViewById(R.id.MILOB1)
    MILOC1 = v.findViewById(R.id.MILOC1)
    MILOD1 = v.findViewById(R.id.MILOD1)

    MILOA2 = v.findViewById(R.id.MILOA2)
    MILOB2 = v.findViewById(R.id.MILOB2)
    MILOC2 = v.findViewById(R.id.MILOC2)
    MILOD2 = v.findViewById(R.id.MILOD2)

    MILOA3 = v.findViewById(R.id.MILOA3)
    MILOB3 = v.findViewById(R.id.MILOB3)
    MILOC3 = v.findViewById(R.id.MILOC3)
    MILOD3 = v.findViewById(R.id.MILOD3)

    MILOA4 = v.findViewById(R.id.MILOA4)
    MILOB4 = v.findViewById(R.id.MILOB4)
    MILOC4 = v.findViewById(R.id.MILOC4)
    MILOD4 = v.findViewById(R.id.MILOD4)

    MILOA5 = v.findViewById(R.id.MILOA5)
    MILOB5 = v.findViewById(R.id.MILOB5)
    MILOC5 = v.findViewById(R.id.MILOC5)
    MILOD5 = v.findViewById(R.id.MILOD5)

    MILOA6 = v.findViewById(R.id.MILOA6)
    MILOB6 = v.findViewById(R.id.MILOB6)
    MILOC6 = v.findViewById(R.id.MILOC6)
    MILOD6 = v.findViewById(R.id.MILOD6)

    MILOA7 = v.findViewById(R.id.MILOA7)
    MILOB7 = v.findViewById(R.id.MILOB7)
    MILOC7 = v.findViewById(R.id.MILOC7)
    MILOD7 = v.findViewById(R.id.MILOD7)

    // EditText in dmcs form list 4
    FADCA1 = v.findViewById(R.id.FADCA1)
    FADCB1 = v.findViewById(R.id.FADCB1)
    FADCC1 = v.findViewById(R.id.FADCC1)
    FADCD1 = v.findViewById(R.id.FADCD1)

    FADCA2 = v.findViewById(R.id.FADCA2)
    FADCB2 = v.findViewById(R.id.FADCB2)
    FADCC2 = v.findViewById(R.id.FADCC2)
    FADCD2 = v.findViewById(R.id.FADCD2)

    FADCA3 = v.findViewById(R.id.FADCA3)
    FADCB3 = v.findViewById(R.id.FADCB3)
    FADCC3 = v.findViewById(R.id.FADCC3)
    FADCD3 = v.findViewById(R.id.FADCD3)

    FADCA4 = v.findViewById(R.id.FADCA4)
    FADCB4 = v.findViewById(R.id.FADCB4)
    FADCC4 = v.findViewById(R.id.FADCC4)
    FADCD4 = v.findViewById(R.id.FADCD4)

    FADCA5 = v.findViewById(R.id.FADCA5)
    FADCB5 = v.findViewById(R.id.FADCB5)
    FADCC5 = v.findViewById(R.id.FADCC5)
    FADCD5 = v.findViewById(R.id.FADCD5)

    FADCA6 = v.findViewById(R.id.FADCA6)
    FADCB6 = v.findViewById(R.id.FADCB6)
    FADCC6 = v.findViewById(R.id.FADCC6)
    FADCD6 = v.findViewById(R.id.FADCD6)

    FADCA7 = v.findViewById(R.id.FADCA7)
    FADCB7 = v.findViewById(R.id.FADCB7)
    FADCC7 = v.findViewById(R.id.FADCC7)
    FADCD7 = v.findViewById(R.id.FADCD7)

    // EditText in dmcs form list 5
    RTDA1 = v.findViewById(R.id.RTDA1)
    RTDB1 = v.findViewById(R.id.RTDB1)
    RTDC1 = v.findViewById(R.id.RTDC1)
    RTDD1 = v.findViewById(R.id.RTDD1)

    RTDA2 = v.findViewById(R.id.RTDA2)
    RTDB2 = v.findViewById(R.id.RTDB2)
    RTDC2 = v.findViewById(R.id.RTDC2)
    RTDD2 = v.findViewById(R.id.RTDD2)

    RTDA3 = v.findViewById(R.id.RTDA3)
    RTDB3 = v.findViewById(R.id.RTDB3)
    RTDC3 = v.findViewById(R.id.RTDC3)
    RTDD3 = v.findViewById(R.id.RTDD3)

    RTDA4 = v.findViewById(R.id.RTDA4)
    RTDB4 = v.findViewById(R.id.RTDB4)
    RTDC4 = v.findViewById(R.id.RTDC4)
    RTDD4 = v.findViewById(R.id.RTDD4)

    RTDA5 = v.findViewById(R.id.RTDA5)
    RTDB5 = v.findViewById(R.id.RTDB5)
    RTDC5 = v.findViewById(R.id.RTDC5)
    RTDD5 = v.findViewById(R.id.RTDD5)

    RTDA6 = v.findViewById(R.id.RTDA6)
    RTDB6 = v.findViewById(R.id.RTDB6)
    RTDC6 = v.findViewById(R.id.RTDC6)
    RTDD6 = v.findViewById(R.id.RTDD6)

    RTDA7 = v.findViewById(R.id.RTDA7)
    RTDB7 = v.findViewById(R.id.RTDB7)
    RTDC7 = v.findViewById(R.id.RTDC7)
    RTDD7 = v.findViewById(R.id.RTDD7)

    // EditText in dmcs form list 6
    NESTEAA1 = v.findViewById(R.id.NESTEAA1)
    NESTEAB1 = v.findViewById(R.id.NESTEAB1)
    NESTEAC1 = v.findViewById(R.id.NESTEAC1)
    NESTEAD1 = v.findViewById(R.id.NESTEAD1)

    NESTEAA2 = v.findViewById(R.id.NESTEAA2)
    NESTEAB2 = v.findViewById(R.id.NESTEAB2)
    NESTEAC2 = v.findViewById(R.id.NESTEAC2)
    NESTEAD2 = v.findViewById(R.id.NESTEAD2)

    NESTEAA3 = v.findViewById(R.id.NESTEAA3)
    NESTEAB3 = v.findViewById(R.id.NESTEAB3)
    NESTEAC3 = v.findViewById(R.id.NESTEAC3)
    NESTEAD3 = v.findViewById(R.id.NESTEAD3)

    NESTEAA4 = v.findViewById(R.id.NESTEAA4)
    NESTEAB4 = v.findViewById(R.id.NESTEAB4)
    NESTEAC4 = v.findViewById(R.id.NESTEAC4)
    NESTEAD4 = v.findViewById(R.id.NESTEAD4)

    NESTEAA5 = v.findViewById(R.id.NESTEAA5)
    NESTEAB5 = v.findViewById(R.id.NESTEAB5)
    NESTEAC5 = v.findViewById(R.id.NESTEAC5)
    NESTEAD5 = v.findViewById(R.id.NESTEAD5)

    NESTEAA6 = v.findViewById(R.id.NESTEAA6)
    NESTEAB6 = v.findViewById(R.id.NESTEAB6)
    NESTEAC6 = v.findViewById(R.id.NESTEAC6)
    NESTEAD6 = v.findViewById(R.id.NESTEAD6)

    NESTEAA7 = v.findViewById(R.id.NESTEAA7)
    NESTEAB7 = v.findViewById(R.id.NESTEAB7)
    NESTEAC7 = v.findViewById(R.id.NESTEAC7)
    NESTEAD7 = v.findViewById(R.id.NESTEAD7)

    // EditText in dmcs form list 7
    BRKFSTCREALSA1 = v.findViewById(R.id.BRKFSTCREALSA1)
    BRKFSTCREALSB1 = v.findViewById(R.id.BRKFSTCREALSB1)
    BRKFSTCREALSC1 = v.findViewById(R.id.BRKFSTCREALSC1)
    BRKFSTCREALSD1 = v.findViewById(R.id.BRKFSTCREALSD1)

    BRKFSTCREALSA2 = v.findViewById(R.id.BRKFSTCREALSA2)
    BRKFSTCREALSB2 = v.findViewById(R.id.BRKFSTCREALSB2)
    BRKFSTCREALSC2 = v.findViewById(R.id.BRKFSTCREALSC2)
    BRKFSTCREALSD2 = v.findViewById(R.id.BRKFSTCREALSD2)

    BRKFSTCREALSA3 = v.findViewById(R.id.BRKFSTCREALSA3)
    BRKFSTCREALSB3 = v.findViewById(R.id.BRKFSTCREALSB3)
    BRKFSTCREALSC3 = v.findViewById(R.id.BRKFSTCREALSC3)
    BRKFSTCREALSD3 = v.findViewById(R.id.BRKFSTCREALSD3)

    BRKFSTCREALSA4 = v.findViewById(R.id.BRKFSTCREALSA4)
    BRKFSTCREALSB4 = v.findViewById(R.id.BRKFSTCREALSB4)
    BRKFSTCREALSC4 = v.findViewById(R.id.BRKFSTCREALSC4)
    BRKFSTCREALSD4 = v.findViewById(R.id.BRKFSTCREALSD4)

    BRKFSTCREALSA5 = v.findViewById(R.id.BRKFSTCREALSA5)
    BRKFSTCREALSB5 = v.findViewById(R.id.BRKFSTCREALSB5)
    BRKFSTCREALSC5 = v.findViewById(R.id.BRKFSTCREALSC5)
    BRKFSTCREALSD5 = v.findViewById(R.id.BRKFSTCREALSD5)

    BRKFSTCREALSA6 = v.findViewById(R.id.BRKFSTCREALSA6)
    BRKFSTCREALSB6 = v.findViewById(R.id.BRKFSTCREALSB6)
    BRKFSTCREALSC6 = v.findViewById(R.id.BRKFSTCREALSC6)
    BRKFSTCREALSD6 = v.findViewById(R.id.BRKFSTCREALSD6)

    BRKFSTCREALSA7 = v.findViewById(R.id.BRKFSTCREALSA7)
    BRKFSTCREALSB7 = v.findViewById(R.id.BRKFSTCREALSB7)
    BRKFSTCREALSC7 = v.findViewById(R.id.BRKFSTCREALSC7)
    BRKFSTCREALSD7 = v.findViewById(R.id.BRKFSTCREALSD7)

    // EditText in dmcs form list 8
    INFNTNUTRITIONA1 = v.findViewById(R.id.INFNTNUTRITIONA1)
    INFNTNUTRITIONB1 = v.findViewById(R.id.INFNTNUTRITIONB1)
    INFNTNUTRITIONC1 = v.findViewById(R.id.INFNTNUTRITIONC1)
    INFNTNUTRITIOND1 = v.findViewById(R.id.INFNTNUTRITIOND1)

    INFNTNUTRITIONA2 = v.findViewById(R.id.INFNTNUTRITIONA2)
    INFNTNUTRITIONB2 = v.findViewById(R.id.INFNTNUTRITIONB2)
    INFNTNUTRITIONC2 = v.findViewById(R.id.INFNTNUTRITIONC2)
    INFNTNUTRITIOND2 = v.findViewById(R.id.INFNTNUTRITIOND2)

    INFNTNUTRITIONA3 = v.findViewById(R.id.INFNTNUTRITIONA3)
    INFNTNUTRITIONB3 = v.findViewById(R.id.INFNTNUTRITIONB3)
    INFNTNUTRITIONC3 = v.findViewById(R.id.INFNTNUTRITIONC3)
    INFNTNUTRITIOND3 = v.findViewById(R.id.INFNTNUTRITIOND3)

    INFNTNUTRITIONA4 = v.findViewById(R.id.INFNTNUTRITIONA4)
    INFNTNUTRITIONB4 = v.findViewById(R.id.INFNTNUTRITIONB4)
    INFNTNUTRITIONC4 = v.findViewById(R.id.INFNTNUTRITIONC4)
    INFNTNUTRITIOND4 = v.findViewById(R.id.INFNTNUTRITIOND4)

    INFNTNUTRITIONA5 = v.findViewById(R.id.INFNTNUTRITIONA5)
    INFNTNUTRITIONB5 = v.findViewById(R.id.INFNTNUTRITIONB5)
    INFNTNUTRITIONC5 = v.findViewById(R.id.INFNTNUTRITIONC5)
    INFNTNUTRITIOND5 = v.findViewById(R.id.INFNTNUTRITIOND5)

    INFNTNUTRITIONA6 = v.findViewById(R.id.INFNTNUTRITIONA6)
    INFNTNUTRITIONB6 = v.findViewById(R.id.INFNTNUTRITIONB6)
    INFNTNUTRITIONC6 = v.findViewById(R.id.INFNTNUTRITIONC6)
    INFNTNUTRITIOND6 = v.findViewById(R.id.INFNTNUTRITIOND6)

    INFNTNUTRITIONA7 = v.findViewById(R.id.INFNTNUTRITIONA7)
    INFNTNUTRITIONB7 = v.findViewById(R.id.INFNTNUTRITIONB7)
    INFNTNUTRITIONC7 = v.findViewById(R.id.INFNTNUTRITIONC7)
    INFNTNUTRITIOND7 = v.findViewById(R.id.INFNTNUTRITIOND7)

    // EditText in dmcs form list 9
    CONFECTIONERYA1 = v.findViewById(R.id.CONFECTIONERYA1)
    CONFECTIONERYB1 = v.findViewById(R.id.CONFECTIONERYB1)
    CONFECTIONERYC1 = v.findViewById(R.id.CONFECTIONERYC1)
    CONFECTIONERYD1 = v.findViewById(R.id.CONFECTIONERYD1)

    CONFECTIONERYA2 = v.findViewById(R.id.CONFECTIONERYA2)
    CONFECTIONERYB2 = v.findViewById(R.id.CONFECTIONERYB2)
    CONFECTIONERYC2 = v.findViewById(R.id.CONFECTIONERYC2)
    CONFECTIONERYD2 = v.findViewById(R.id.CONFECTIONERYD2)

    CONFECTIONERYA3 = v.findViewById(R.id.CONFECTIONERYA3)
    CONFECTIONERYB3 = v.findViewById(R.id.CONFECTIONERYB3)
    CONFECTIONERYC3 = v.findViewById(R.id.CONFECTIONERYC3)
    CONFECTIONERYD3 = v.findViewById(R.id.CONFECTIONERYD3)

    CONFECTIONERYA4 = v.findViewById(R.id.CONFECTIONERYA4)
    CONFECTIONERYB4 = v.findViewById(R.id.CONFECTIONERYB4)
    CONFECTIONERYC4 = v.findViewById(R.id.CONFECTIONERYC4)
    CONFECTIONERYD4 = v.findViewById(R.id.CONFECTIONERYD4)

    CONFECTIONERYA5 = v.findViewById(R.id.CONFECTIONERYA5)
    CONFECTIONERYB5 = v.findViewById(R.id.CONFECTIONERYB5)
    CONFECTIONERYC5 = v.findViewById(R.id.CONFECTIONERYC5)
    CONFECTIONERYD5 = v.findViewById(R.id.CONFECTIONERYD5)

    CONFECTIONERYA6 = v.findViewById(R.id.CONFECTIONERYA6)
    CONFECTIONERYB6 = v.findViewById(R.id.CONFECTIONERYB6)
    CONFECTIONERYC6 = v.findViewById(R.id.CONFECTIONERYC6)
    CONFECTIONERYD6 = v.findViewById(R.id.CONFECTIONERYD6)

    CONFECTIONERYA7 = v.findViewById(R.id.CONFECTIONERYA7)
    CONFECTIONERYB7 = v.findViewById(R.id.CONFECTIONERYB7)
    CONFECTIONERYC7 = v.findViewById(R.id.CONFECTIONERYC7)
    CONFECTIONERYD7 = v.findViewById(R.id.CONFECTIONERYD7)

    // EditText in dmcs form list 10
    OTHERITEMSA1 = v.findViewById(R.id.OTHERITEMSA1)
    OTHERITEMSB1 = v.findViewById(R.id.OTHERITEMSB1)
    OTHERITEMSC1 = v.findViewById(R.id.OTHERITEMSC1)
    OTHERITEMSD1 = v.findViewById(R.id.OTHERITEMSD1)

    OTHERITEMSA2 = v.findViewById(R.id.OTHERITEMSA2)
    OTHERITEMSB2 = v.findViewById(R.id.OTHERITEMSB2)
    OTHERITEMSC2 = v.findViewById(R.id.OTHERITEMSC2)
    OTHERITEMSD2 = v.findViewById(R.id.OTHERITEMSD2)

    OTHERITEMSA3 = v.findViewById(R.id.OTHERITEMSA3)
    OTHERITEMSB3 = v.findViewById(R.id.OTHERITEMSB3)
    OTHERITEMSC3 = v.findViewById(R.id.OTHERITEMSC3)
    OTHERITEMSD3 = v.findViewById(R.id.OTHERITEMSD3)

    OTHERITEMSA4 = v.findViewById(R.id.OTHERITEMSA4)
    OTHERITEMSB4 = v.findViewById(R.id.OTHERITEMSB4)
    OTHERITEMSC4 = v.findViewById(R.id.OTHERITEMSC4)
    OTHERITEMSD4 = v.findViewById(R.id.OTHERITEMSD4)

    OTHERITEMSA5 = v.findViewById(R.id.OTHERITEMSA5)
    OTHERITEMSB5 = v.findViewById(R.id.OTHERITEMSB5)
    OTHERITEMSC5 = v.findViewById(R.id.OTHERITEMSC5)
    OTHERITEMSD5 = v.findViewById(R.id.OTHERITEMSD5)

    // EditText in dmcs form list 11
    BDDATOPIC1 = v.findViewById(R.id.BDDATOPIC1)
    BDDATOPIC2 = v.findViewById(R.id.BDDATOPIC2)
    BDDATOPIC3 = v.findViewById(R.id.BDDATOPIC3)
    BDDATOPIC4 = v.findViewById(R.id.BDDATOPIC4)
    BDDATOPIC5 = v.findViewById(R.id.BDDATOPIC5)
    BDDATOPIC6 = v.findViewById(R.id.BDDATOPIC6)
    BDDATOPIC7 = v.findViewById(R.id.BDDATOPIC7)

    BDDAA1 = v.findViewById(R.id.BDDAA1)
    BDDAB1 = v.findViewById(R.id.BDDAB1)
    BDDAC1 = v.findViewById(R.id.BDDAC1)
    BDDAD1 = v.findViewById(R.id.BDDAD1)

    BDDAA2 = v.findViewById(R.id.BDDAA2)
    BDDAB2 = v.findViewById(R.id.BDDAB2)
    BDDAC2 = v.findViewById(R.id.BDDAC2)
    BDDAD2 = v.findViewById(R.id.BDDAD2)

    BDDAA3 = v.findViewById(R.id.BDDAA3)
    BDDAB3 = v.findViewById(R.id.BDDAB3)
    BDDAC3 = v.findViewById(R.id.BDDAC3)
    BDDAD3 = v.findViewById(R.id.BDDAD3)

    BDDAA4 = v.findViewById(R.id.BDDAA4)
    BDDAB4 = v.findViewById(R.id.BDDAB4)
    BDDAC4 = v.findViewById(R.id.BDDAC4)
    BDDAD4 = v.findViewById(R.id.BDDAD4)

    BDDAA5 = v.findViewById(R.id.BDDAA5)
    BDDAB5 = v.findViewById(R.id.BDDAB5)
    BDDAC5 = v.findViewById(R.id.BDDAC5)
    BDDAD5 = v.findViewById(R.id.BDDAD5)

    BDDAA6 = v.findViewById(R.id.BDDAA6)
    BDDAB6 = v.findViewById(R.id.BDDAB6)
    BDDAC6 = v.findViewById(R.id.BDDAC6)
    BDDAD6 = v.findViewById(R.id.BDDAD6)

    BDDAA7 = v.findViewById(R.id.BDDAA7)
    BDDAB7 = v.findViewById(R.id.BDDAB7)
    BDDAC7 = v.findViewById(R.id.BDDAC7)
    BDDAD7 = v.findViewById(R.id.BDDAD7)


    positiondmcsname.text = "Text"
    displaydmcsname.text = "Text"

    var linename = ""
    var lineposition = ""
    var salesname = ""
    var salesposition = ""
    var cdate = ""
    var dmcscustomertext = ""
    var dmcsbranchtext = ""
    var dmcscallobjtext = ""

    if (arguments!!.getString("linename") != null || arguments!!.getString("lineposition") != null || arguments!!.get("salesname") !=null ||
        arguments!!.getString("salesposition")  !=null || arguments!!.getString("cdate") != null ||
        arguments!!.getString("dmcscustomernametext") !=null || arguments!!.getString("dmcsbranchtext") !=null || arguments!!.getString("dmcscallobjectivetext") !=null) {
      val linemanagername = arguments!!.getString("linename")
      val linemananagerposition = arguments!!.getString("lineposition")
      val salesmanname = arguments!!.getString("salesname")
      val salesmanposition = arguments!!.getString("salesposition")
      val date = arguments!!.getString("cdate")
      val dmcscustomernametext = arguments!!.getString("dmcscustomernametext")
      val dmcsbrancnametext = arguments!!.getString("dmcsbranchtext")
      val dmcscallobjecttext = arguments!!.getString("dmcscallobjectivetext")




      if (linemanagername != null) {
        linename = linemanagername
      }
      if (linemananagerposition != null) {
        lineposition = linemananagerposition
      }
      if (salesmanname != null) {
        salesname = salesmanname
      }
      if (salesmanposition != null) {
        salesposition = salesmanposition
      }
      if (date != null) {
        cdate = date
      }
      if (dmcscustomernametext !=null){
        dmcscustomertext = dmcscustomernametext
      }
      if (dmcsbrancnametext !=null){
        dmcsbranchtext = dmcsbrancnametext
      }
      if (dmcscallobjecttext !=null){
        dmcscallobjtext = dmcscallobjecttext
      }

//    display_date = cdate
      positiondmcsname.setText(salesposition)
      displaydmcsname.setText(salesname)



    }



// drop down
//    var show = 1
//
//    iconshow.setOnClickListener(){
//
//      var formlist1 = v.findViewById<LinearLayout>(R.id.formlist1)
//
//      if (show == 1) {
//        iconshow.setImageResource(R.drawable.iconshow)
//        formlist1.visibility = View.GONE
//
//        show = 2
//      }else{
//        iconshow.setImageResource(R.drawable.iconhide)
//        formlist1.visibility = View.VISIBLE
//
//        show = 1
//      }
//
//    }


    dmcsbtnsave.setOnClickListener(){

      // name of position and salesman name (position name and salesman name)
      var posname = positiondmcsname.text.toString()
      var dname = displaydmcsname.text.toString()

      // get content from the list 1
      var DHA1 = DHNSA1.text.toString()
      var DHB1 = DHNSB1.text.toString()
      var DHC1 = DHNSC1.text.toString()
      var DHD1 = DHNSD1.text.toString()

      var DHA2 = DHNSA2.text.toString()
      var DHB2 = DHNSB2.text.toString()
      var DHC2 = DHNSC2.text.toString()
      var DHD2 = DHNSD2.text.toString()

      var DHA3 = DHNSA3.text.toString()
      var DHB3 = DHNSB3.text.toString()
      var DHC3 = DHNSC3.text.toString()
      var DHD3 = DHNSD3.text.toString()

      var DHA4 = DHNSA4.text.toString()
      var DHB4 = DHNSB4.text.toString()
      var DHC4 = DHNSC4.text.toString()
      var DHD4 = DHNSD4.text.toString()

      var DHA5 = DHNSA5.text.toString()
      var DHB5 = DHNSB5.text.toString()
      var DHC5 = DHNSC5.text.toString()
      var DHD5 = DHNSD5.text.toString()

      var DHA6 = DHNSA6.text.toString()
      var DHB6 = DHNSB6.text.toString()
      var DHC6 = DHNSC6.text.toString()
      var DHD6 = DHNSD6.text.toString()

      var DHA7 = DHNSA7.text.toString()
      var DHB7 = DHNSB7.text.toString()
      var DHC7 = DHNSC7.text.toString()
      var DHD7 = DHNSD7.text.toString()

      // get content from the list 2
      var CBA1 = CBUA1.text.toString()
      var CBB1 = CBUB1.text.toString()
      var CBC1 = CBUC1.text.toString()
      var CBD1 = CBUD1.text.toString()

      var CBA2 = CBUA2.text.toString()
      var CBB2 = CBUB2.text.toString()
      var CBC2 = CBUC2.text.toString()
      var CBD2 = CBUD2.text.toString()

      var CBA3 = CBUA3.text.toString()
      var CBB3 = CBUB3.text.toString()
      var CBC3 = CBUC3.text.toString()
      var CBD3 = CBUD3.text.toString()

      var CBA4 = CBUA4.text.toString()
      var CBB4 = CBUB4.text.toString()
      var CBC4 = CBUC4.text.toString()
      var CBD4 = CBUD4.text.toString()

      var CBA5 = CBUA5.text.toString()
      var CBB5 = CBUB5.text.toString()
      var CBC5 = CBUC5.text.toString()
      var CBD5 = CBUD5.text.toString()

      var CBA6 = CBUA6.text.toString()
      var CBB6 = CBUB6.text.toString()
      var CBC6 = CBUC6.text.toString()
      var CBD6 = CBUD6.text.toString()

      var CBA7 = CBUA7.text.toString()
      var CBB7 = CBUB7.text.toString()
      var CBC7 = CBUC7.text.toString()
      var CBD7 = CBUD7.text.toString()

      // get content from the list 3
      var MILA1 = MILOA1.text.toString()
      var MILB1 = MILOB1.text.toString()
      var MILC1 = MILOC1.text.toString()
      var MILD1 = MILOD1.text.toString()

      var MILA2 = MILOA2.text.toString()
      var MILB2 = MILOB2.text.toString()
      var MILC2 = MILOC2.text.toString()
      var MILD2 = MILOD2.text.toString()

      var MILA3 = MILOA3.text.toString()
      var MILB3 = MILOB3.text.toString()
      var MILC3 = MILOC3.text.toString()
      var MILD3 = MILOD3.text.toString()

      var MILA4 = MILOA4.text.toString()
      var MILB4 = MILOB4.text.toString()
      var MILC4 = MILOC4.text.toString()
      var MILD4 = MILOD4.text.toString()

      var MILA5 = MILOA5.text.toString()
      var MILB5 = MILOB5.text.toString()
      var MILC5 = MILOC5.text.toString()
      var MILD5 = MILOD5.text.toString()

      var MILA6 = MILOA6.text.toString()
      var MILB6 = MILOB6.text.toString()
      var MILC6 = MILOC6.text.toString()
      var MILD6 = MILOD6.text.toString()

      var MILA7 = MILOA7.text.toString()
      var MILB7 = MILOB7.text.toString()
      var MILC7 = MILOC7.text.toString()
      var MILD7 = MILOD7.text.toString()

      // get content from the list 4
      var FADA1 = FADCA1.text.toString()
      var FADB1 = FADCB1.text.toString()
      var FADC1 = FADCC1.text.toString()
      var FADD1 = FADCD1.text.toString()

      var FADA2 = FADCA2.text.toString()
      var FADB2 = FADCB2.text.toString()
      var FADC2 = FADCC2.text.toString()
      var FADD2 = FADCD2.text.toString()

      var FADA3 = FADCA3.text.toString()
      var FADB3 = FADCB3.text.toString()
      var FADC3 = FADCC3.text.toString()
      var FADD3 = FADCD3.text.toString()

      var FADA4 = FADCA4.text.toString()
      var FADB4 = FADCB4.text.toString()
      var FADC4 = FADCC4.text.toString()
      var FADD4 = FADCD4.text.toString()

      var FADA5 = FADCA5.text.toString()
      var FADB5 = FADCB5.text.toString()
      var FADC5 = FADCC5.text.toString()
      var FADD5 = FADCD5.text.toString()

      var FADA6 = FADCA6.text.toString()
      var FADB6 = FADCB6.text.toString()
      var FADC6 = FADCC6.text.toString()
      var FADD6 = FADCD6.text.toString()

      var FADA7 = FADCA7.text.toString()
      var FADB7 = FADCB7.text.toString()
      var FADC7 = FADCC7.text.toString()
      var FADD7 = FADCD7.text.toString()


      // get content from the list 5
      var RTA1 = RTDA1.text.toString()
      var RTB1 = RTDB1.text.toString()
      var RTC1 = RTDC1.text.toString()
      var RTD1 = RTDD1.text.toString()

      var RTA2 = RTDA2.text.toString()
      var RTB2 = RTDB2.text.toString()
      var RTC2 = RTDC2.text.toString()
      var RTD2 = RTDD2.text.toString()

      var RTA3 = RTDA3.text.toString()
      var RTB3 = RTDB3.text.toString()
      var RTC3 = RTDC3.text.toString()
      var RTD3 = RTDD3.text.toString()

      var RTA4 = RTDA4.text.toString()
      var RTB4 = RTDB4.text.toString()
      var RTC4 = RTDC4.text.toString()
      var RTD4 = RTDD4.text.toString()

      var RTA5 = RTDA5.text.toString()
      var RTB5 = RTDB5.text.toString()
      var RTC5 = RTDC5.text.toString()
      var RTD5 = RTDD5.text.toString()

      var RTA6 = RTDA6.text.toString()
      var RTB6 = RTDB6.text.toString()
      var RTC6 = RTDC6.text.toString()
      var RTD6 = RTDD6.text.toString()

      var RTA7 = RTDA7.text.toString()
      var RTB7 = RTDB7.text.toString()
      var RTC7 = RTDC7.text.toString()
      var RTD7 = RTDD7.text.toString()

      // get content from the list 6
      var NESTA1 = NESTEAA1.text.toString()
      var NESTB1 = NESTEAB1.text.toString()
      var NESTC1 = NESTEAC1.text.toString()
      var NESTD1 = NESTEAD1.text.toString()

      var NESTA2 = NESTEAA2.text.toString()
      var NESTB2 = NESTEAB2.text.toString()
      var NESTC2 = NESTEAC2.text.toString()
      var NESTD2 = NESTEAD2.text.toString()

      var NESTA3 = NESTEAA3.text.toString()
      var NESTB3 = NESTEAB3.text.toString()
      var NESTC3 = NESTEAC3.text.toString()
      var NESTD3 = NESTEAD3.text.toString()

      var NESTA4 = NESTEAA4.text.toString()
      var NESTB4 = NESTEAB4.text.toString()
      var NESTC4 = NESTEAC4.text.toString()
      var NESTD4 = NESTEAD4.text.toString()

      var NESTA5 = NESTEAA5.text.toString()
      var NESTB5 = NESTEAB5.text.toString()
      var NESTC5 = NESTEAC5.text.toString()
      var NESTD5 = NESTEAD5.text.toString()

      var NESTA6 = NESTEAA6.text.toString()
      var NESTB6 = NESTEAB6.text.toString()
      var NESTC6 = NESTEAC6.text.toString()
      var NESTD6 = NESTEAD6.text.toString()

      var NESTA7 = NESTEAA7.text.toString()
      var NESTB7 = NESTEAB7.text.toString()
      var NESTC7 = NESTEAC7.text.toString()
      var NESTD7 = NESTEAD7.text.toString()

      // get content from the list 7
      var BRKCREALA1 = BRKFSTCREALSA1.text.toString()
      var BRKCREALB1 = BRKFSTCREALSB1.text.toString()
      var BRKCREALC1 = BRKFSTCREALSC1.text.toString()
      var BRKCREALD1 = BRKFSTCREALSD1.text.toString()

      var BRKCREALA2 = BRKFSTCREALSA2.text.toString()
      var BRKCREALB2 = BRKFSTCREALSB2.text.toString()
      var BRKCREALC2 = BRKFSTCREALSC2.text.toString()
      var BRKCREALD2 = BRKFSTCREALSD2.text.toString()

      var BRKCREALA3 = BRKFSTCREALSA3.text.toString()
      var BRKCREALB3 = BRKFSTCREALSB3.text.toString()
      var BRKCREALC3 = BRKFSTCREALSC3.text.toString()
      var BRKCREALD3 = BRKFSTCREALSD3.text.toString()

      var BRKCREALA4 = BRKFSTCREALSA4.text.toString()
      var BRKCREALB4 = BRKFSTCREALSB4.text.toString()
      var BRKCREALC4 = BRKFSTCREALSC4.text.toString()
      var BRKCREALD4 = BRKFSTCREALSD4.text.toString()

      var BRKCREALA5 = BRKFSTCREALSA5.text.toString()
      var BRKCREALB5 = BRKFSTCREALSB5.text.toString()
      var BRKCREALC5 = BRKFSTCREALSC5.text.toString()
      var BRKCREALD5 = BRKFSTCREALSD5.text.toString()

      var BRKCREALA6 = BRKFSTCREALSA6.text.toString()
      var BRKCREALB6 = BRKFSTCREALSB6.text.toString()
      var BRKCREALC6 = BRKFSTCREALSC6.text.toString()
      var BRKCREALD6 = BRKFSTCREALSD6.text.toString()

      var BRKCREALA7 = BRKFSTCREALSA7.text.toString()
      var BRKCREALB7 = BRKFSTCREALSB7.text.toString()
      var BRKCREALC7 = BRKFSTCREALSC7.text.toString()
      var BRKCREALD7 = BRKFSTCREALSD7.text.toString()

      // get content from the list 8
      var INFNTNUTA1 = INFNTNUTRITIONA1.text.toString()
      var INFNTNUTB1 = INFNTNUTRITIONB1.text.toString()
      var INFNTNUTC1 = INFNTNUTRITIONC1.text.toString()
      var INFNTNUTD1 = INFNTNUTRITIOND1.text.toString()

      var INFNTNUTA2 = INFNTNUTRITIONA2.text.toString()
      var INFNTNUTB2 = INFNTNUTRITIONB2.text.toString()
      var INFNTNUTC2 = INFNTNUTRITIONC2.text.toString()
      var INFNTNUTD2 = INFNTNUTRITIOND2.text.toString()

      var INFNTNUTA3 = INFNTNUTRITIONA3.text.toString()
      var INFNTNUTB3 = INFNTNUTRITIONB3.text.toString()
      var INFNTNUTC3 = INFNTNUTRITIONC3.text.toString()
      var INFNTNUTD3 = INFNTNUTRITIOND3.text.toString()

      var INFNTNUTA4 = INFNTNUTRITIONA4.text.toString()
      var INFNTNUTB4 = INFNTNUTRITIONB4.text.toString()
      var INFNTNUTC4 = INFNTNUTRITIONC4.text.toString()
      var INFNTNUTD4 = INFNTNUTRITIOND4.text.toString()

      var INFNTNUTA5 = INFNTNUTRITIONA5.text.toString()
      var INFNTNUTB5 = INFNTNUTRITIONB5.text.toString()
      var INFNTNUTC5 = INFNTNUTRITIONC5.text.toString()
      var INFNTNUTD5 = INFNTNUTRITIOND5.text.toString()

      var INFNTNUTA6 = INFNTNUTRITIONA6.text.toString()
      var INFNTNUTB6 = INFNTNUTRITIONB6.text.toString()
      var INFNTNUTC6 = INFNTNUTRITIONC6.text.toString()
      var INFNTNUTD6 = INFNTNUTRITIOND6.text.toString()

      var INFNTNUTA7 = INFNTNUTRITIONA7.text.toString()
      var INFNTNUTB7 = INFNTNUTRITIONB7.text.toString()
      var INFNTNUTC7 = INFNTNUTRITIONC7.text.toString()
      var INFNTNUTD7 = INFNTNUTRITIOND7.text.toString()

      // get content from the list 9
      var CONFCA1 = CONFECTIONERYA1.text.toString()
      var CONFCB1 = CONFECTIONERYB1.text.toString()
      var CONFCC1 = CONFECTIONERYC1.text.toString()
      var CONFCD1 = CONFECTIONERYD1.text.toString()

      var CONFCA2 = CONFECTIONERYA2.text.toString()
      var CONFCB2 = CONFECTIONERYB2.text.toString()
      var CONFCC2 = CONFECTIONERYC2.text.toString()
      var CONFCD2 = CONFECTIONERYD2.text.toString()

      var CONFCA3 = CONFECTIONERYA3.text.toString()
      var CONFCB3 = CONFECTIONERYB3.text.toString()
      var CONFCC3 = CONFECTIONERYC3.text.toString()
      var CONFCD3 = CONFECTIONERYD3.text.toString()

      var CONFCA4 = CONFECTIONERYA4.text.toString()
      var CONFCB4 = CONFECTIONERYB4.text.toString()
      var CONFCC4 = CONFECTIONERYC4.text.toString()
      var CONFCD4 = CONFECTIONERYD4.text.toString()

      var CONFCA5 = CONFECTIONERYA5.text.toString()
      var CONFCB5 = CONFECTIONERYB5.text.toString()
      var CONFCC5 = CONFECTIONERYC5.text.toString()
      var CONFCD5 = CONFECTIONERYD5.text.toString()

      var CONFCA6 = CONFECTIONERYA6.text.toString()
      var CONFCB6 = CONFECTIONERYB6.text.toString()
      var CONFCC6 = CONFECTIONERYC6.text.toString()
      var CONFCD6 = CONFECTIONERYD6.text.toString()

      var CONFCA7 = CONFECTIONERYA7.text.toString()
      var CONFCB7 = CONFECTIONERYB7.text.toString()
      var CONFCC7 = CONFECTIONERYC7.text.toString()
      var CONFCD7 = CONFECTIONERYD7.text.toString()

      // get content from the list 10
      var OTHERSA1 = OTHERITEMSA1.text.toString()
      var OTHERSB1 = OTHERITEMSB1.text.toString()
      var OTHERSC1 = OTHERITEMSC1.text.toString()
      var OTHERSD1 = OTHERITEMSD1.text.toString()

      var OTHERSA2 = OTHERITEMSA2.text.toString()
      var OTHERSB2 = OTHERITEMSB2.text.toString()
      var OTHERSC2 = OTHERITEMSC2.text.toString()
      var OTHERSD2 = OTHERITEMSD2.text.toString()

      var OTHERSA3 = OTHERITEMSA3.text.toString()
      var OTHERSB3 = OTHERITEMSB3.text.toString()
      var OTHERSC3 = OTHERITEMSC3.text.toString()
      var OTHERSD3 = OTHERITEMSD3.text.toString()

      var OTHERSA4 = OTHERITEMSA4.text.toString()
      var OTHERSB4 = OTHERITEMSB4.text.toString()
      var OTHERSC4 = OTHERITEMSC4.text.toString()
      var OTHERSD4 = OTHERITEMSD4.text.toString()

      var OTHERSA5 = OTHERITEMSA5.text.toString()
      var OTHERSB5 = OTHERITEMSB5.text.toString()
      var OTHERSC5 = OTHERITEMSC5.text.toString()
      var OTHERSD5 = OTHERITEMSD5.text.toString()

      // get content from the list 11
      var BDATOPIC1 = BDDATOPIC1.text.toString()
      var BDATOPIC2 = BDDATOPIC2.text.toString()
      var BDATOPIC3 = BDDATOPIC3.text.toString()
      var BDATOPIC4 = BDDATOPIC4.text.toString()
      var BDATOPIC5 = BDDATOPIC5.text.toString()
      var BDATOPIC6 = BDDATOPIC6.text.toString()
      var BDATOPIC7 = BDDATOPIC7.text.toString()

      var BDAA1 = BDDAA1.text.toString()
      var BDAB1 = BDDAB1.text.toString()
      var BDAC1 = BDDAC1.text.toString()
      var BDAD1 = BDDAD1.text.toString()

      var BDAA2 = BDDAA2.text.toString()
      var BDAB2 = BDDAB2.text.toString()
      var BDAC2 = BDDAC2.text.toString()
      var BDAD2 = BDDAD2.text.toString()

      var BDAA3 = BDDAA3.text.toString()
      var BDAB3 = BDDAB3.text.toString()
      var BDAC3 = BDDAC3.text.toString()
      var BDAD3 = BDDAD3.text.toString()

      var BDAA4 = BDDAA4.text.toString()
      var BDAB4 = BDDAB4.text.toString()
      var BDAC4 = BDDAC4.text.toString()
      var BDAD4 = BDDAD4.text.toString()

      var BDAA5 = BDDAA5.text.toString()
      var BDAB5 = BDDAB5.text.toString()
      var BDAC5 = BDDAC5.text.toString()
      var BDAD5 = BDDAD5.text.toString()

      var BDAA6 = BDDAA6.text.toString()
      var BDAB6 = BDDAB6.text.toString()
      var BDAC6 = BDDAC6.text.toString()
      var BDAD6 = BDDAD6.text.toString()

      var BDAA7 = BDDAA7.text.toString()
      var BDAB7 = BDDAB7.text.toString()
      var BDAC7 = BDDAC7.text.toString()
      var BDAD7 = BDDAD7.text.toString()


      val DMCSnextFRAG = dmcs_check_and_act_form_signature()
      val bundle = Bundle()

      var test = "test"


      // from dmcs chand and act form
      bundle.putString("linename", linename)
      bundle.putString("lineposition", lineposition)
      bundle.putString("salesname", salesname)
      bundle.putString("salesposition", salesposition)
      bundle.putString("cdate", cdate)
      bundle.putString("dmcscustomertext", dmcscustomertext)
      bundle.putString("dmcsbranchtext", dmcsbranchtext)
      bundle.putString("dmcscallobjecttext", dmcscallobjtext)

      // get content from the list 1
      bundle.putString("DHA1",DHA1)
      bundle.putString("DHB1",DHB1)
      bundle.putString("DHC1",DHC1)
      bundle.putString("DHD1",DHD1)

          bundle.putString("DHA2",DHA2)
          bundle.putString("DHB2",DHB2)
          bundle.putString("DHC2",DHC2)
          bundle.putString("DHD2",DHD2)

          bundle.putString("DHA3",DHA3)
          bundle.putString("DHB3",DHB3)
          bundle.putString("DHC3",DHC3)
          bundle.putString("DHD3",DHD3)

          bundle.putString("DHA4",DHA4)
          bundle.putString("DHB4",DHB4)
          bundle.putString("DHC4",DHC4)
          bundle.putString("DHD4",DHD4)

          bundle.putString("DHA5",DHA5)
          bundle.putString("DHB5",DHB5)
          bundle.putString("DHC5",DHC5)
          bundle.putString("DHD5",DHD5)

          bundle.putString("DHA6",DHA6)
          bundle.putString("DHB6",DHB6)
          bundle.putString("DHC6",DHC6)
          bundle.putString("DHD6",DHD6)

          bundle.putString("DHA7",DHA7)
          bundle.putString("DHB7",DHB7)
          bundle.putString("DHC7",DHC7)
          bundle.putString("DHD7",DHD7)

      // get content from the list 2
          bundle.putString("CBA1",CBA1)
          bundle.putString("CBB1",CBB1)
          bundle.putString("CBC1",CBC1)
          bundle.putString("CBD1",CBD1)

          bundle.putString("CBA2",CBA2)
          bundle.putString("CBB2",CBB2)
          bundle.putString("CBC2",CBC2)
          bundle.putString("CBD2",CBD2)

          bundle.putString("CBA3",CBA3)
          bundle.putString("CBB3",CBB3)
          bundle.putString("CBC3",CBC3)
          bundle.putString("CBD3",CBD3)

          bundle.putString("CBA4",CBA4)
          bundle.putString("CBB4",CBB4)
          bundle.putString("CBC4",CBC4)
          bundle.putString("CBD4",CBD4)

          bundle.putString("CBA5",CBA5)
          bundle.putString("CBB5",CBB5)
          bundle.putString("CBC5",CBC5)
          bundle.putString("CBD5",CBD5)

          bundle.putString("CBA6",CBA6)
          bundle.putString("CBB6",CBB6)
          bundle.putString("CBC6",CBC6)
          bundle.putString("CBD6",CBD6)

          bundle.putString("CBA7",CBA7)
          bundle.putString("CBB7",CBB7)
          bundle.putString("CBC7",CBC7)
          bundle.putString("CBD7",CBD7)

      // get content from the list 3
          bundle.putString("MILA1",MILA1)
          bundle.putString("MILB1",MILB1)
          bundle.putString("MILC1",MILC1)
          bundle.putString("MILD1",MILD1)

          bundle.putString("MILA2",MILA2)
          bundle.putString("MILB2",MILB2)
          bundle.putString("MILC2",MILC2)
          bundle.putString("MILD2",MILD2)

          bundle.putString("MILA3",MILA3)
          bundle.putString("MILB3",MILB3)
          bundle.putString("MILC3",MILC3)
          bundle.putString("MILD3",MILD3)

          bundle.putString("MILA4",MILA4)
          bundle.putString("MILB4",MILB4)
          bundle.putString("MILC4",MILC4)
          bundle.putString("MILD4",MILD4)

          bundle.putString("MILA5",MILA5)
          bundle.putString("MILB5",MILB5)
          bundle.putString("MILC5",MILC5)
          bundle.putString("MILD5",MILD5)

          bundle.putString("MILA6",MILA6)
          bundle.putString("MILB6",MILB6)
          bundle.putString("MILC6",MILC6)
          bundle.putString("MILD6",MILD6)

          bundle.putString("MILA7",MILA7)
          bundle.putString("MILB7",MILB7)
          bundle.putString("MILC7",MILC7)
          bundle.putString("MILD7",MILD7)

          // get content from the list 4
          bundle.putString("FADA1",FADA1)
          bundle.putString("FADB1",FADB1)
          bundle.putString("FADC1",FADC1)
          bundle.putString("FADD1",FADD1)

          bundle.putString("FADA2",FADA2)
          bundle.putString("FADB2",FADB2)
          bundle.putString("FADC2",FADC2)
          bundle.putString("FADD2",FADD2)

          bundle.putString("FADA3",FADA3)
          bundle.putString("FADB3",FADB3)
          bundle.putString("FADC3",FADC3)
          bundle.putString("FADD3",FADD3)

          bundle.putString("FADA4",FADA4)
          bundle.putString("FADB4",FADB4)
          bundle.putString("FADC4",FADC4)
          bundle.putString("FADD4",FADD4)

          bundle.putString("FADA5",FADA5)
          bundle.putString("FADB5",FADB5)
          bundle.putString("FADC5",FADC5)
          bundle.putString("FADD5",FADD5)

          bundle.putString("FADA6",FADA6)
          bundle.putString("FADB6",FADB6)
          bundle.putString("FADC6",FADC6)
          bundle.putString("FADD6",FADD6)

          bundle.putString("FADA7",FADA7)
          bundle.putString("FADB7",FADB7)
          bundle.putString("FADC7",FADC7)
          bundle.putString("FADD7",FADD7)


          // get content from the list 5
          bundle.putString("RTA1",RTA1)
          bundle.putString("RTB1",RTB1)
          bundle.putString("RTC1",RTC1)
          bundle.putString("RTD1",RTD1)

          bundle.putString("RTA2",RTA2)
          bundle.putString("RTB2",RTB2)
          bundle.putString("RTC2",RTC2)
          bundle.putString("RTD2",RTD2)

          bundle.putString("RTA3",RTA3)
          bundle.putString("RTB3",RTB3)
          bundle.putString("RTC3",RTC3)
          bundle.putString("RTD3",RTD3)

          bundle.putString("RTA4",RTA4)
          bundle.putString("RTB4",RTB4)
          bundle.putString("RTC4",RTC4)
          bundle.putString("RTD4",RTD4)

          bundle.putString("RTA5",RTA5)
          bundle.putString("RTB5",RTB5)
          bundle.putString("RTC5",RTC5)
          bundle.putString("RTD5",RTD5)

          bundle.putString("RTA6",RTA6)
          bundle.putString("RTB6",RTB6)
          bundle.putString("RTC6",RTC6)
          bundle.putString("RTD6",RTD6)

          bundle.putString("RTA7",RTA7)
          bundle.putString("RTB7",RTB7)
          bundle.putString("RTC7",RTC7)
          bundle.putString("RTD7",RTD7)

          // get content from the list 6
          bundle.putString("NESTA1",NESTA1)
          bundle.putString("NESTB1",NESTB1)
          bundle.putString("NESTC1",NESTC1)
          bundle.putString("NESTD1",NESTD1)

          bundle.putString("NESTA2",NESTA2)
          bundle.putString("NESTB2",NESTB2)
          bundle.putString("NESTC2",NESTC2)
          bundle.putString("NESTD2",NESTD2)

          bundle.putString("NESTA3",NESTA3)
          bundle.putString("NESTB3",NESTB3)
          bundle.putString("NESTC3",NESTC3)
          bundle.putString("NESTD3",NESTD3)

          bundle.putString("NESTA4",NESTA4)
          bundle.putString("NESTB4",NESTB4)
          bundle.putString("NESTC4",NESTC4)
          bundle.putString("NESTD4",NESTD4)

          bundle.putString("NESTA5",NESTA5)
          bundle.putString("NESTB5",NESTB5)
          bundle.putString("NESTC5",NESTC5)
          bundle.putString("NESTD5",NESTD5)

          bundle.putString("NESTA6",NESTA6)
          bundle.putString("NESTB6",NESTB6)
          bundle.putString("NESTC6",NESTC6)
          bundle.putString("NESTD6",NESTD6)

          bundle.putString("NESTA7",NESTA7)
          bundle.putString("NESTB7",NESTB7)
          bundle.putString("NESTC7",NESTC7)
          bundle.putString("NESTD7",NESTD7)

          // get content from the list 7
          bundle.putString("BRKCREALA1",BRKCREALA1)
          bundle.putString("BRKCREALB1",BRKCREALB1)
          bundle.putString("BRKCREALC1",BRKCREALC1)
          bundle.putString("BRKCREALD1",BRKCREALD1)

          bundle.putString("BRKCREALA2",BRKCREALA2)
          bundle.putString("BRKCREALB2",BRKCREALB2)
          bundle.putString("BRKCREALC2",BRKCREALC2)
          bundle.putString("BRKCREALD2",BRKCREALD2)

          bundle.putString("BRKCREALA3",BRKCREALA3)
          bundle.putString("BRKCREALB3",BRKCREALB3)
          bundle.putString("BRKCREALC3",BRKCREALC3)
          bundle.putString("BRKCREALD3",BRKCREALD3)

          bundle.putString("BRKCREALA4",BRKCREALA4)
          bundle.putString("BRKCREALB4",BRKCREALB4)
          bundle.putString("BRKCREALC4",BRKCREALC4)
          bundle.putString("BRKCREALD4",BRKCREALD4)

          bundle.putString("BRKCREALA5",BRKCREALA5)
          bundle.putString("BRKCREALB5",BRKCREALB5)
          bundle.putString("BRKCREALC5",BRKCREALC5)
          bundle.putString("BRKCREALD5",BRKCREALD5)

          bundle.putString("BRKCREALA6",BRKCREALA6)
          bundle.putString("BRKCREALB6",BRKCREALB6)
          bundle.putString("BRKCREALC6",BRKCREALC6)
          bundle.putString("BRKCREALD6",BRKCREALD6)

          bundle.putString("BRKCREALA7",BRKCREALA7)
          bundle.putString("BRKCREALB7",BRKCREALB7)
          bundle.putString("BRKCREALC7",BRKCREALC7)
          bundle.putString("BRKCREALD7",BRKCREALD7)

          // get content from the list 8
          bundle.putString("INFNTNUTA1",INFNTNUTA1)
          bundle.putString("INFNTNUTB1",INFNTNUTB1)
          bundle.putString("INFNTNUTC1",INFNTNUTC1)
          bundle.putString("INFNTNUTD1",INFNTNUTD1)

          bundle.putString("INFNTNUTA2",INFNTNUTA2)
          bundle.putString("INFNTNUTB2",INFNTNUTB2)
          bundle.putString("INFNTNUTC2",INFNTNUTC2)
          bundle.putString("INFNTNUTD2",INFNTNUTD2)

          bundle.putString("INFNTNUTA3",INFNTNUTA3)
          bundle.putString("INFNTNUTB3",INFNTNUTB3)
          bundle.putString("INFNTNUTC3",INFNTNUTC3)
          bundle.putString("INFNTNUTD3",INFNTNUTD3)

          bundle.putString("INFNTNUTA4",INFNTNUTA4)
          bundle.putString("INFNTNUTB4",INFNTNUTB4)
          bundle.putString("INFNTNUTC4",INFNTNUTC4)
          bundle.putString("INFNTNUTD4",INFNTNUTD4)

          bundle.putString("INFNTNUTA5",INFNTNUTA5)
          bundle.putString("INFNTNUTB5",INFNTNUTB5)
          bundle.putString("INFNTNUTC5",INFNTNUTC5)
          bundle.putString("INFNTNUTD5",INFNTNUTD5)

          bundle.putString("INFNTNUTA6",INFNTNUTA6)
          bundle.putString("INFNTNUTB6",INFNTNUTB6)
          bundle.putString("INFNTNUTC6",INFNTNUTC6)
          bundle.putString("INFNTNUTD6",INFNTNUTD6)

          bundle.putString("INFNTNUTA7",INFNTNUTA7)
          bundle.putString("INFNTNUTB7",INFNTNUTB7)
          bundle.putString("INFNTNUTC7",INFNTNUTC7)
          bundle.putString("INFNTNUTD7",INFNTNUTD7)

          // get content from the list 9
          bundle.putString("CONFCA1",CONFCA1)
          bundle.putString("CONFCB1",CONFCB1)
          bundle.putString("CONFCC1",CONFCC1)
          bundle.putString("CONFCD1",CONFCD1)

          bundle.putString("CONFCA2",CONFCA2)
          bundle.putString("CONFCB2",CONFCB2)
          bundle.putString("CONFCC2",CONFCC2)
          bundle.putString("CONFCD2",CONFCD2)

          bundle.putString("CONFCA3",CONFCA3)
          bundle.putString("CONFCB3",CONFCB3)
          bundle.putString("CONFCC3",CONFCC3)
          bundle.putString("CONFCD3",CONFCD3)

          bundle.putString("CONFCA4",CONFCA4)
          bundle.putString("CONFCB4",CONFCB4)
          bundle.putString("CONFCC4",CONFCC4)
          bundle.putString("CONFCD4",CONFCD4)

          bundle.putString("CONFCA5",CONFCA5)
          bundle.putString("CONFCB5",CONFCB5)
          bundle.putString("CONFCC5",CONFCC5)
          bundle.putString("CONFCD5",CONFCD5)

          bundle.putString("CONFCA6",CONFCA6)
          bundle.putString("CONFCB6",CONFCB6)
          bundle.putString("CONFCC6",CONFCC6)
          bundle.putString("CONFCD6",CONFCD6)

          bundle.putString("CONFCA7",CONFCA7)
          bundle.putString("CONFCB7",CONFCB7)
          bundle.putString("CONFCC7",CONFCC7)
          bundle.putString("CONFCD7",CONFCD7)

          // get content from the list 10
          bundle.putString("OTHERSA1",OTHERSA1)
          bundle.putString("OTHERSB1",OTHERSB1)
          bundle.putString("OTHERSC1",OTHERSC1)
          bundle.putString("OTHERSD1",OTHERSD1)

          bundle.putString("OTHERSA2",OTHERSA2)
          bundle.putString("OTHERSB2",OTHERSB2)
          bundle.putString("OTHERSC2",OTHERSC2)
          bundle.putString("OTHERSD2",OTHERSD2)

          bundle.putString("OTHERSA3",OTHERSA3)
          bundle.putString("OTHERSB3",OTHERSB3)
          bundle.putString("OTHERSC3",OTHERSC3)
          bundle.putString("OTHERSD3",OTHERSD3)

          bundle.putString("OTHERSA4",OTHERSA4)
          bundle.putString("OTHERSB4",OTHERSB4)
          bundle.putString("OTHERSC4",OTHERSC4)
          bundle.putString("OTHERSD4",OTHERSD4)

          bundle.putString("OTHERSA5",OTHERSA5)
          bundle.putString("OTHERSB5",OTHERSB5)
          bundle.putString("OTHERSC5",OTHERSC5)
          bundle.putString("OTHERSD5",OTHERSD5)

          // get content from the list 11
          bundle.putString("BDATOPIC1",BDATOPIC1)
          bundle.putString("BDATOPIC2",BDATOPIC2)
          bundle.putString("BDATOPIC3",BDATOPIC3)
          bundle.putString("BDATOPIC4",BDATOPIC4)
          bundle.putString("BDATOPIC5",BDATOPIC5)
          bundle.putString("BDATOPIC6",BDATOPIC6)
          bundle.putString("BDATOPIC7",BDATOPIC7)

          bundle.putString("BDAA1",BDAA1)
          bundle.putString("BDAB1",BDAB1)
          bundle.putString("BDAC1",BDAC1)
          bundle.putString("BDAD1",BDAD1)

          bundle.putString("BDAA2",BDAA2)
          bundle.putString("BDAB2",BDAB2)
          bundle.putString("BDAC2",BDAC2)
          bundle.putString("BDAD2",BDAD2)

          bundle.putString("BDAA3",BDAA3)
          bundle.putString("BDAB3",BDAB3)
          bundle.putString("BDAC3",BDAC3)
          bundle.putString("BDAD3",BDAD3)

          bundle.putString("BDAA4",BDAA4)
          bundle.putString("BDAB4",BDAB4)
          bundle.putString("BDAC4",BDAC4)
          bundle.putString("BDAD4",BDAD4)

          bundle.putString("BDAA5",BDAA5)
          bundle.putString("BDAB5",BDAB5)
          bundle.putString("BDAC5",BDAC5)
          bundle.putString("BDAD5",BDAD5)

          bundle.putString("BDAA6",BDAA6)
          bundle.putString("BDAB6",BDAB6)
          bundle.putString("BDAC6",BDAC6)
          bundle.putString("BDAD6",BDAD6)

          bundle.putString("BDAA7",BDAA7)
          bundle.putString("BDAB7",BDAB7)
          bundle.putString("BDAC7",BDAC7)
          bundle.putString("BDAD7",BDAD7)

          DMCSnextFRAG.arguments = bundle


      val commit = requireActivity().supportFragmentManager.beginTransaction()
          .replace(R.id.frame_layout, DMCSnextFRAG, "findThisFragment")
          .addToBackStack(null)
          .commit()

    }


  return v
  }



}