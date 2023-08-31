package com.test.information.fragments

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.test.information.DatabaseHandler
import com.test.information.R



class HomeFragment : Fragment() {

    lateinit var salesmanresult: TextView
    lateinit var btn_coachingbutton: ImageView
    lateinit var btn_checkandact: ImageView
    lateinit var tv_proflename: TextView

  lateinit var tv_CName: TextView
  lateinit var tv_Position: TextView
  lateinit var tv_CompanyName: TextView
  lateinit var profileImage: ImageView

  lateinit var mypic : Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    @SuppressLint("CommitTransaction")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var  v: View = inflater.inflate(R.layout.fragment_dashboard, container, false)

      salesmanresult = v.findViewById(R.id.tv_salesmanprofileresult)
      btn_coachingbutton = v.findViewById(R.id.btn_coachingformdashboard)
      btn_checkandact = v.findViewById(R.id.btn_checkandactdashboard)
      tv_proflename = v.findViewById(R.id.tv_cnameprofile)

      // Initiate your UI elements here
      tv_Position = v.findViewById(R.id.tv_positionprofile)
      tv_CompanyName = v.findViewById(R.id.tv_companynameprofile)
      profileImage = v.findViewById(R.id.Profile_pic)

      //Query the database to retrieve profile data and image
      val context = this
      val db = DatabaseHandler(this.requireActivity())
      val profileData = db.retrieveProfileData()
      tv_proflename.text = "Lee Jong Suk"
      tv_Position.text = ""
      tv_CompanyName.text = ""

      for (i in 0 until profileData.size) {
        tv_proflename.text = profileData[i].name
        tv_Position.text = profileData[i].position
        tv_CompanyName.text = profileData[i].company

        val bitmap = BitmapFactory.decodeByteArray(profileData.last().ownerImage, 0, profileData.last().ownerImage.size)
        profileImage.setImageBitmap(bitmap) // Set the profile image

      }




      var nameprofile = tv_proflename.text.toString()
      var nameprofileswitching = "Lee Jong Suk"
      if (nameprofile == nameprofileswitching){
        Toast.makeText(this.activity, "First Use Setup Page", Toast.LENGTH_SHORT).show()

        val setupprofile = profilecreation()
        val commit = requireActivity().supportFragmentManager.beginTransaction()
          .replace(R.id.frame_layout, setupprofile, "findThisFragment")
          .addToBackStack(null)
          .commit()

      }
                v.translationX = 1000f // Initial position for the animation
                v.animate()
                .translationX(0f) // Final position
                .setDuration(1500) // Adjust the duration as needed
                .start()



        btn_coachingbutton.setOnClickListener(){
            val coachingForm = AddentryFragment()
            val commit = requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, coachingForm, "findThisFragment")
                .addToBackStack(null)
                .commit()
        }
        btn_checkandact.setOnClickListener(){
            val checkandact = dmcs_checkandact_formFragment()
            val commit = requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, checkandact, "findThisFragment")
                .addToBackStack(null)
                .commit()
        }






//        ++++++++++++++++++++++++++++++++++++++++++
//        READ DATA FROM DATABASE SALESMAN RESULT
//        ++++++++++++++++++++++++++++++++++++++++++++++

//        val context = this
//        val db = DatabaseHandler(this.requireActivity())
//        var data = db.salesmanResultDB()
//
//            for (i in 0 until data.size) {
//                salesmanresult.text = data[i].firstRowGrade
//                salesmanresult.text = data[i].secondRowGrade
//                salesmanresult.text = data[i].finalGrade
//                db.close()
//            }





        // END ON CREATEVIEW MUST USE RETURN V
        return v
    }


}