package com.mcit.scala.AppStarter
import com.mcit.scala.Entities.{Calender, EnrichedTrip, Routes, TripRoute, Trips}
import com.mcit.scala.ReadWriteServices.{DataReader, DataWriter}
import com.mcit.scala.Mapping.{CalendarLookup, RouteLookup}

/**
 * @author sahilgogna on 2020-02-08
 */
object EntryPoint extends App {

  val readData : DataReader = new DataReader

  val tripList: List[Trips] = readData.getTripList
  val routeList: List[Routes] = readData.getRouteList
  val calanderList: List[Calender] = readData.getCalenderList

  val routeLookup = new RouteLookup(routeList)
  val calenderLookUp = new CalendarLookup(calanderList)

  val enrichedTripRoute: List[TripRoute] = tripList.map(trip => TripRoute(trip,
                                                    routeLookup.lookup(trip.route_id))).toList

  val enrichedTrip: List[EnrichedTrip] = enrichedTripRoute.map(tripRoute => EnrichedTrip(tripRoute,
                                                    calenderLookUp.lookup(tripRoute.trips.service_id))).toList

//  enrichedTrip.foreach( element => println(s" TripId: ${element.tripRoute.trips.trip_id} RouteId: ${element.tripRoute.routes.route_id} ServiceId: ${element.calender.service_id}"))

  val writer = new DataWriter(enrichedTrip)
  writer.writeData
}
