package com.example.ucu2024_android_lazylayouts_leccion1.models

import java.util.UUID
import com.example.ucu2024_android_lazylayouts_leccion1.R

class Contacto private constructor(
    val Nombre: String,
    val Id: UUID = UUID.randomUUID(),
) {
    var ImagenPerfil: Int? = null
        get() = field?:R.drawable.profile

    constructor(
        nombre: String,
        imagenPerfil: Int,
    ) : this(Nombre = nombre) {
        this.ImagenPerfil = imagenPerfil
    }

    private constructor(
        id: UUID,
        nombre: String,
        imagenPerfil: Int?,
    ) : this(Nombre = nombre, Id = id) {
        ImagenPerfil = imagenPerfil
    }

    fun Clonar(): Contacto {
        return Contacto(id = this.Id, nombre = this.Nombre, imagenPerfil = this.ImagenPerfil)
    }
}