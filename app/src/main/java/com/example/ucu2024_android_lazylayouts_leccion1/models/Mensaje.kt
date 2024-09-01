package com.example.ucu2024_android_lazylayouts_leccion1.models

import java.time.Instant
import java.util.Date

class Mensaje(
    contenido: String,
    val Enviado: Date,
) {
    var Contenido: String = contenido
        set(value) {
            if (!Eliminado) {
                field = value
                Modificado = Date.from(Instant.now())
            }
            else throw IllegalStateException("El mensaje ha sido eliminado.")
        }

    var Modificado: Date? = null
        private set(value) { field = value }

    var Eliminado: Boolean = false
        private set(value) {
            field = value
            Modificado = Date.from(Instant.now())
        }

    constructor(contenido: String) : this(contenido, Date.from(Instant.now()))

    val ToggleEliminado: () -> Unit = { Eliminado = !Eliminado }
}