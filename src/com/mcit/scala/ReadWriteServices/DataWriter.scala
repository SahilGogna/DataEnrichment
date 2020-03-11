package com.mcit.scala.ReadWriteServices

import java.io.{File, FileWriter}
import com.mcit.scala.Entities.EnrichedTrip
import com.opencsv._

/**
 * @author sahilgogna on 2020-02-08
 * This class writes the data in form of csv file
 */
class DataWriter(enrichedList: List[EnrichedTrip]) {


  val outputPath = "/Users/sahilgogna/Documents/Big Data College/Course 2/Assignments/Scala Project/enrichedOutput.csv"
  var file: File = new File(outputPath)
  val output: FileWriter = new FileWriter(file)
  val writer: CSVWriter = new CSVWriter(output)

  val csvSchema: Array[String] = Array("Route Id", "Service Id", "Trip Id", "Trip Head Sign", "Direction Id",
    "Shape Id", "Wheelchair accessible", "Note_FR", "Note En", "Agency Id",
    "Route Short Name", "Route Long Name", "Route Type", "Route Url", "Route Colour",
    "Monday")

  def writeData(): Unit = {
    writer.writeNext(csvSchema)
    enrichedList.foreach(element => {
      val data = Array(element.tripRoute.routes.route_id.toString, element.calender.service_id.toString,
        element.tripRoute.trips.trip_id.toString, element.tripRoute.trips.trip_headsign.toString,
        element.tripRoute.trips.direction_id.toString, element.tripRoute.trips.shape_id.toString,
        element.tripRoute.trips.wheelchair_accessible.toString, element.tripRoute.trips.note_fr.toString,
        element.tripRoute.trips.note_en.toString, element.tripRoute.routes.agency_id.toString,
        element.tripRoute.routes.route_short_name.toString, element.tripRoute.routes.route_long_name.toString,
        element.tripRoute.routes.route_type.toString, element.tripRoute.routes.route_url.toString,
        element.tripRoute.routes.route_color.toString, element.calender.monday.toString,
      )
      writer.writeNext(data)
    })
    // closing writer connection
    writer.close()

  }


}
