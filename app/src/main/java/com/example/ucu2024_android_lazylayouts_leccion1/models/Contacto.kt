package com.example.ucu2024_android_lazylayouts_leccion1.models

import java.util.UUID
import com.example.ucu2024_android_lazylayouts_leccion1.R

class Contacto(
    val Nombre: String,
) {
    val Id: UUID = UUID.randomUUID()
    private var ImagenPerfil: Int? = null
        get() = field?:R.drawable.profile

    constructor(
        nombre: String,
        imagenPerfil: Int
    ) : this(nombre) {
        this.ImagenPerfil = imagenPerfil
    }
}