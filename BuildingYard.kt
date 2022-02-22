package com.coroutines

import kotlinx.coroutines.*
import java.lang.Exception

class BuildingYard {

    private val scope = CoroutineScope(Dispatchers.Default)

    suspend fun startProject(name: String, floors: Int): Deferred<Building> {
        return scope.async {

//        val startTime = System.currentTimeMillis()
//        val building= Building(name)
//       val building =withContext(Dispatchers.Default) {
            val building = Building(name, scope = this)
            val cores = Runtime.getRuntime().availableProcessors()
            building.speakThroughBullHorn(
                "The building of $name is started with $cores building machines engaged"
            )
            //if found != ready nothing else go on
            building.makeFoundation().join()

            (1..floors).forEach {
                var floorNum = 0
                try {
                    //a floor should be raised b4 decorating
                    floorNum = building.buildFloor(it)
                } catch (e: Exception) {
                    building.speakThroughBullHorn(e.message ?: "")

                }

//               these decorations can be made at same time
                building.placeWindows(it)
                building.installDoors(it)
                building.provideElectric(it)
                building.fitOut(it)
            }
            building.buildRoof().join()
            building.speakThroughBullHorn("${building.name} is ready")

            building
        }
//       if (building.floors ==floors ) {
//
//       }


//        building.speakThroughBullHorn("${building.name} is ready in ${System.currentTimeMillis() - startTime}!")
    }
}
