package com.example.ucu2024_android_lazylayouts_leccion1.models

import java.time.Instant
import java.util.Date
import java.util.UUID

class Mensaje(
    contenido: String,
    val Emisor: UUID,
    val Enviado: Date,
) {
    var Contenido: String = contenido
        private set

    var Modificado: Date? = null
        private set

    var Eliminado: Boolean = false
        private set


    constructor(contenido: String, emisor: UUID) : this(
        contenido = contenido,
        Emisor = emisor,
        Enviado = Date.from(Instant.now())
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
            Modificado = Date.from(Instant.now())
        }
        else throw IllegalStateException("El mensaje ha sido eliminado.")
    }

    fun ToggleEliminado() {
        Eliminado = !Eliminado
        Modificado = Date.from(Instant.now())
    }

    fun Clonar(): Mensaje {
        return Mensaje(original = this)
    }
}