package com.mcit.scala.ReadWriteServices

import com.mcit.scala.Entities.{Calender, Routes, Trips}

import scala.io.Source

/**
 * @author sahilgogna on 2020-02-02
 * This class is responsible for reading the data from the data files and storing them to the data structures
 */
class DataReader{

  val filePathRoutes = "/Users/sahilgogna/Documents/Big Data College/Course 2/Assignments/Scala Project/routes.txt"
  val filePathCalender = "/Users/sahilgogna/Documents/Big Data College/Course 2/Assignments/Scala Project/calendar.txt"
  val filePathTrips = "/Users/sahilgogna/Documents/Big Data College/Course 2/Assignments/Scala Project/trips.txt"

  /**
   * method to get the route list
   * @return List of routes
   */
  def getRouteList:List[Routes] = {
    val source = Source.fromFile(filePathRoutes)
    val input = source.getLines().drop(1)
      .map(line => line.split(","))
      .map(a => Routes(a(0).toInt, a(1), a(2), a(3), a(4), a(5), a(6))).toList
    source.close()
    input
  }

  /**
   * method to get the calendar list
   * @return List of calendar
   */
  def getCalenderList: List[Calender] = {
    val source = Source.fromFile(filePathCalender)
    val input = source.getLines().drop(1)
      .map(line => line.split(","))
      .map(a => Calender(a(0), a(1), a(2), a(3), a(4), a(5), a(6), a(7), a(8), a(9))).toList
    source.close()
    input
  }

  /**
   * method to get the trip list
   * @return List of trips
   */
  def getTripList: List[Trips] = {
    val source = Source.fromFile(filePathTrips)
    val input = source.getLines().drop(1)
      .map(line => line.split(","))
      .map(a => Trips(a(0).toInt, a(1), a(2), a(3), a(4), a(5), a(6))).toList
    source.close()
    input
  }
}