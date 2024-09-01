package com.example.ucu2024_android_lazylayouts_leccion1.models

import androidx.compose.ui.util.fastMap
import java.time.Instant
import java.util.Date
import java.util.UUID

class Conversacion private constructor(miembros: MutableList<Contacto>) {
    private val _mensajes: MutableList<Mensaje> = mutableListOf()
    private var _tipo: TiposConversacion? = null
    private val _contactos: MutableMap<UUID, Contacto> = mutableMapOf()
    private val _lecturas: MutableMap<UUID, Date> = mutableMapOf()

    val Contactos: MutableList<Contacto>
        get() = mutableListOf( *_contactos.map { it.value.Clonar() }.toTypedArray() )


    init {
        miembros.forEach { _lecturas[it.Id] = Date.from(Instant.now()) }
    }

    constructor(first: Contacto, second: Contacto) : this(mutableListOf(first, second)) {
        _getNombre = { consultor: UUID ->
            _contactos.filter { it.key != consultor }.values.randomOrNull()?.Nombre?:"Desconocido"
        }
        _tipo = TiposConversacion.Privado
    }

    constructor(miembros: MutableList<Contacto>, nombre: String) : this(miembros) {
        if (miembros.count() < 2)
            throw IllegalArgumentException("Grupo debe contener 2 o mas miembros.")

        _getNombre = { consultor: UUID -> nombre }
        _tipo = TiposConversacion.Grupal
    }


    fun GetNombre(consultor: UUID): String {
        return _getNombre(consultor)
    }

    private var _getNombre: (consultor: UUID) -> String = {
        throw UninitializedPropertyAccessException("Grupo no inicializado.")
    }

    fun EnviarMensaje(mensaje: Mensaje): Unit {
        _mensajes.add(mensaje)
        _lecturas[mensaje.Emisor] = Date.from(Instant.now())
    }

    fun GetMensajes(consultor: UUID): MutableMap<Mensaje, Boolean> {
        _lecturas[consultor] = Date.from(Instant.now())
        return mutableMapOf( *_mensajes.fastMap { it.Clonar() to (it.Enviado > _lecturas[it.Emisor]) }.toTypedArray() )
    }

    fun GetUltimoMensaje(): Mensaje {
        return _mensajes.last().Clonar()
    }

    fun GetMensajesNuevos(consultor: UUID): Int {
        return _mensajes.filter { it.Enviado > _lecturas[consultor] }.count()
    }
}

enum class TiposConversacion {
    Privado, Grupal
}