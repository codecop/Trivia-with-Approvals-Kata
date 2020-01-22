package com.adaptionsoft.games.uglytrivia

open class Logger {
    val logs = ArrayList<String>()
    fun log(message: String) {
        println(message)
        logs.add(message)
    }

    fun logsAsString(): String {
        return logs.reduce { acc, s -> "$acc\n$s" }
    }
}