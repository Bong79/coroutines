package com.coroutines

import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.EmptyCoroutineContext

class Building(val name: String, var floors: Int = 0, private val scope: CoroutineScope) {

    val random = Random()

    suspend fun makeFoundation() = scope.launch {
        delay(300)
        speakThroughBullHorn("[${Thread.currentThread().name}] The foundation is ready")
    }

    suspend fun buildFloor(floor: Int) = withContext(scope.coroutineContext) {
        delay(100)

        if (random.nextBoolean()) {
            throw Exception("[${Thread.currentThread().name} Something went wrong on $floor'th floor")
        }
        speakThroughBullHorn("[${Thread.currentThread().name}] The $floor'th floor is raised")
        ++floors
    }

    suspend fun placeWindows(floor: Int) = scope.launch {
        delay(100)
        speakThroughBullHorn("[${Thread.currentThread().name}] Windows are place on $floor'th floor")
    }

    suspend fun installDoors(floor: Int) = scope.launch {
        delay(100)
        speakThroughBullHorn("[${Thread.currentThread().name}] doors install on $floor'th floor")
    }

    suspend fun provideElectric(floor: Int) = scope.launch {
        delay(100)
        speakThroughBullHorn("[${Thread.currentThread().name}] Electric provided on floor num $floor")
    }

    suspend fun buildRoof() = scope.launch {
        delay(200)
        speakThroughBullHorn("[${Thread.currentThread().name}] The roof is ready")
    }

    suspend fun fitOut(floor: Int) = scope.launch {
        delay(200)
        speakThroughBullHorn("[${Thread.currentThread().name}] floor num $floor  is furnished")
    }

    fun speakThroughBullHorn(message: String) = println(message)
}
