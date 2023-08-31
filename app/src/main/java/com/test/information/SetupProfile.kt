package com.test.information

import android.graphics.Bitmap

class SetupProfile {
  var ID:Int = 0
  var name: String = ""
  var position: String = ""
  var company: String = ""
  var ownerImage: ByteArray = byteArrayOf()


  constructor(
    name: String,
    position: String,
    company: String,
    ownerImage: ByteArray
  ) {
    this.name = name
    this.position = position
    this.company = company
    this.ownerImage = ownerImage
  }
}