package com.mcit.scala.ReadWriteServices

import com.mcit.scala.Entities.{Calender, Routes, Trips}

import scala.io.{BufferedSource, Source}

/**
 * @author sahilgogna on 2020-02-02
 */
class DataReader{

  val filePathRoutes = "/Users/sahilgogna/Documents/Big Data College/Course 2/Assignments/Scala Project/routes.txt"
  val filePathCalender = "/Users/sahilgogna/Documents/Big Data College/Course 2/Assignments/Scala Project/calendar.txt"
  val filePathTrips = "/Users/sahilgogna/Documents/Big Data College/Course 2/Assignments/Scala Project/trips.txt"

  def getRouteList:List[Routes] = {
      Source.fromFile(filePathRoutes).getLines().drop(1)
      .map(line => line.split(","))
      .map(a => Routes(a(0).toInt, a(1), a(2), a(3), a(4), a(5), a(6))).toList
  }

  def getCalenderList: List[Calender] = {
    Source.fromFile(filePathCalender).getLines().drop(1)
      .map(line => line.split(","))
      .map(a => Calender(a(0), a(1), a(2), a(3), a(4), a(5), a(6), a(7), a(8), a(9))).toList
  }

  def getTripList: List[Trips] = {
    Source.fromFile(filePathTrips).getLines().drop(1)
      .map(line => line.split(","))
      .map(a => Trips(a(0).toInt, a(1), a(2), a(3), a(4), a(5), a(6))).toList
  }
}