package com.example.ucu2024_android_lazylayouts_leccion1.models

import androidx.compose.ui.util.fastMap
import com.example.ucu2024_android_lazylayouts_leccion1.R
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.UUID

class Conversacion private constructor(miembros: MutableList<Contacto>, val id: UUID) {
    private val _mensajes: MutableList<Mensaje> = mutableListOf()
    private val _contactos: MutableMap<UUID, Contacto> = mutableMapOf()
    private val _lecturas: MutableMap<UUID, ZonedDateTime> = mutableMapOf()

    var tipo: TiposConversacion? = null
        private set

    val Contactos: MutableList<Contacto>
        get() = mutableListOf( *_contactos.map { it.value.Clonar() }.toTypedArray() )


    init {
        miembros.forEach {
            _lecturas[it.Id] = ZonedDateTime.now(ZoneId.of("America/Montevideo"))
            _contactos[it.Id] = it
        }
    }

    constructor(first: Contacto, second: Contacto) : this(mutableListOf(first, second), UUID.randomUUID()) {
        _getNombre = { consultor: UUID ->
            _contactos.filter { it.key != consultor }.values.randomOrNull()?.Nombre?:"Desconocido"
        }
        _getImagen = { consultor: UUID ->
            _contactos.filter { it.key != consultor }.values.randomOrNull()?.ImagenPerfil?: R.drawable.profile
        }
        tipo = TiposConversacion.Privado
    }

    constructor(miembros: MutableList<Contacto>, nombre: String, imagen: Int) : this(miembros, UUID.randomUUID()) {
        if (miembros.count() < 2)
            throw IllegalArgumentException("Grupo debe contener 2 o mas miembros.")

        _getNombre = { _: UUID -> nombre }
        _getImagen = { _: UUID -> imagen }
        tipo = TiposConversacion.Grupal
    }


    fun GetNombre(consultor: UUID): String {
        return _getNombre(consultor)
    }

    fun GetImagen(consultor: UUID): Int {
        return _getImagen(consultor)
    }

    private var _getNombre: (consultor: UUID) -> String = {
        throw UninitializedPropertyAccessException("Conversación no inicializada.")
    }

    private var _getImagen: (consultor: UUID) -> Int = {
        throw UninitializedPropertyAccessException("Conversación no inicializada.")
    }

    fun EnviarMensaje(mensaje: Mensaje): Unit {
        _mensajes.add(mensaje)
        _lecturas[mensaje.Emisor] = mensaje.Enviado
    }

    fun GetMensajes(consultor: UUID): MutableMap<Mensaje, Boolean> {
        _lecturas[consultor] = ZonedDateTime.now(ZoneId.of("America/Montevideo"))
        return mutableMapOf( *_mensajes.fastMap { it.Clonar() to (it.Enviado > _lecturas[it.Emisor]) }.toTypedArray() )
    }

    fun GetUltimoMensaje(): Mensaje? {
        return _mensajes.lastOrNull()?.Clonar()
    }

    fun GetMensajesNuevos(consultor: UUID): Int {
        return _mensajes.count { it.Enviado > _lecturas[consultor] }
    }
}

enum class TiposConversacion {
    Privado, Grupal
}