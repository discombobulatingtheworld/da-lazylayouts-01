package com.example.ucu2024_android_lazylayouts_leccion1.models

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.Date
import java.util.UUID

class Mensaje(
    contenido: String,
    val Emisor: UUID,
    val Enviado: ZonedDateTime,
) {
    var Contenido: String = contenido
        private set

    var Modificado: ZonedDateTime? = null
        private set

    var Eliminado: Boolean = false
        private set


    constructor(contenido: String, emisor: UUID) : this(
        contenido = contenido,
        Emisor = emisor,
        Enviado = ZonedDateTime.now(ZoneId.of("America/Montevideo"))
    )

    private constructor(original: Mensaje) : this(
        contenido = original.Contenido,
        Emisor = original.Emisor,
        Enviado = original.Enviado
    ) {
        Modificado = original.Modificado
        Eliminado = original.Eliminado
    }


    fun Editar(contenido: String) {
        if (!Eliminado) {
            Contenido = contenido
            Modificado = ZonedDateTime.now(ZoneId.of("America/Montevideo"))
        }
        else throw IllegalStateException("El mensaje ha sido eliminado.")
    }

    fun ToggleEliminado() {
        Eliminado = !Eliminado
        Modificado = ZonedDateTime.now(ZoneId.of("America/Montevideo"))
    }

    fun Clonar(): Mensaje {
        return Mensaje(original = this)
    }
}