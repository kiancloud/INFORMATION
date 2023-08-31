package com.test.information

class Dashboard {
  var ID: Int = 0
  var liname: String = ""
  var lmanagerposition: String = ""
  var sName: String = ""
  var pName: String = ""
  var firstRowGrade: String = ""
  var secondRowGrade: String = ""
  var finalGrade: String = ""
  var dateTime: String = ""

  constructor
      (
          liname: String,
          lmanagerposition: String,
          sName: String,
          pName: String,
          firstRowGrade: String,
          secondRowGrade: String,
          finalGrade: String,
          dateTime: String,
      )
      {
        this.liname = liname
        this.lmanagerposition = lmanagerposition
        this.sName = sName
        this.pName = pName
        this.firstRowGrade = firstRowGrade
        this.secondRowGrade = secondRowGrade
        this.finalGrade = finalGrade
        this.dateTime = dateTime
      }
  constructor()

}