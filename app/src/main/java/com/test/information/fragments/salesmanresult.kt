package com.test.information.fragments

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.test.information.DatabaseHandler
import com.test.information.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class salesmanresult : Fragment() {

    lateinit var tv_CName: TextView
    lateinit var tv_Position: TextView
    lateinit var tv_CompanyName: TextView
    lateinit var profileImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v: View = inflater.inflate(R.layout.fragment_coacher_signature, container, false)
//
//        // Initiate your UI elements here
//        tv_CName = v.findViewById(R.id.tv_cnameprofile)
//        tv_Position = v.findViewById(R.id.tv_positionprofile)
//        tv_CompanyName = v.findViewById(R.id.tv_companynameprofile)
//        profileImage = v.findViewById(R.id.Profile_pic)
//
//        //Query the database to retrieve profile data and image
//        val dbhandler = DatabaseHandler(requireContext())
//        val profileData = dbhandler.retrieveProfileData()
//
//        // Set retrieved data in UI elements
//        if (profileData != null) {
//            // Set retrieved data in UI elements
//            tv_CName.text = profileData.name
//            tv_Position.text = profileData.position
//            tv_CompanyName.text = profileData.company
//
//            // Convert the ByteArray to Bitmap
//            val bitmap = BitmapFactory.decodeByteArray(profileData.ownerImage, 0, profileData.ownerImage.size)
//            profileImage.setImageBitmap(bitmap) // Set the profile image
//        } else {
//            // Handle the case where profile data is not available
//        }

        return v
    }

}