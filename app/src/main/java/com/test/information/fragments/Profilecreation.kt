package com.test.information.fragments

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.test.information.DatabaseHandler
//import com.test.information.Manifest
import com.test.information.R
import java.io.ByteArrayOutputStream
import android.Manifest
import com.test.information.SetupProfile


class profilecreation : Fragment() {

  lateinit var btn_profileSave: Button
  lateinit var et_setuppagename: EditText
  lateinit var et_setupposition: EditText
  lateinit var et_setupcompany: EditText
  lateinit var profileImage: ImageView


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {

    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    var v:View =  inflater.inflate(R.layout.fragment_profilecreation, container, false)

    btn_profileSave = v.findViewById(R.id.btn_profilecreationsave)
    et_setuppagename = v.findViewById(R.id.et_setuppage_cname)
    et_setupposition = v.findViewById(R.id.et_setuppage_position)
    et_setupcompany = v.findViewById(R.id.et_setuppage_companyname)
    profileImage = v.findViewById(R.id.profile_image) // Initialize profileImage ImageView


//    val profileImage1 = v.findViewById<ImageView>(R.id.profile_image)

    profileImage.setOnClickListener() {
      if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
        == PackageManager.PERMISSION_GRANTED) {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(requireActivity().packageManager) != null) {
          startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
      } else {
        requestCameraPermission()
      }
    }

    v.translationX = 1000f // Initial position for the animation
    v.animate()
      .translationX(0f) // Final position
      .setDuration(1500) // Adjust the duration as needed
      .start()

    btn_profileSave.setOnClickListener {

      val blankname = et_setuppagename.text.toString()
      val blankposition = et_setupposition.text.toString()
      val blankcompany = et_setupcompany.text.toString()

      val blank1 =""
      val blank2 = " "
      if (blank1 == blankname || blank2 == blankname ){
        Toast.makeText(activity,"NAME EMPTY",Toast.LENGTH_SHORT).show()
      }
      if (blankposition == blank1 || blankposition == blank2 ){
        Toast.makeText(activity,"POSITION EMPTY",Toast.LENGTH_SHORT).show()
      }
      if (blankcompany == blank1 || blankcompany == blank2 ){
        Toast.makeText(activity,"COMPANY EMPTY",Toast.LENGTH_SHORT).show()
      }

      else {

        try {
          // Retrieve data from edit text
          val name = et_setuppagename.text.toString()
          val position = et_setupposition.text.toString()
          val company = et_setupcompany.text.toString()

//         Convert Bitmap to byte array
          val imageBitmap = (profileImage.drawable as BitmapDrawable).bitmap
          val imageByteArray = ByteArrayOutputStream()
          imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, imageByteArray)
          val imageBytes = imageByteArray.toByteArray()

          // Create a SetupProfile object
          val setupProfile = SetupProfile(name, position, company, imageBytes)
          // Save data to Database
          val dbhandler = DatabaseHandler(requireContext())
          dbhandler.insertDataP(setupProfile)
          // Optionally, you can add a log to indicate successful save
          Toast.makeText(activity, "SUCCESS", Toast.LENGTH_SHORT).show()
          val homefragment = HomeFragment()
          val commit = requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, homefragment, "findThisFragment")
            .addToBackStack(null)
            .commit()


        } catch (e: Exception) {
          Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT).show()
          Log.e("ProfileCreationFragment", "Error saving data: ${e.message}")
          e.printStackTrace()
          Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT).show()
        }
      }

    }



    return v
  }

  companion object {
    private const val REQUEST_IMAGE_CAPTURE = 1
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
      val imageBitmap = data?.extras?.get("data") as Bitmap?
      if (imageBitmap != null) {
        // Set the captured image to the profile image view
        profileImage.setImageBitmap(imageBitmap)
      }
    }
  }

  private fun requestCameraPermission() {
    val permission = Manifest.permission.CAMERA
    val requestCode = 1 // You can choose any unique value
    ActivityCompat.requestPermissions(requireActivity(), arrayOf(permission), requestCode)
  }


}