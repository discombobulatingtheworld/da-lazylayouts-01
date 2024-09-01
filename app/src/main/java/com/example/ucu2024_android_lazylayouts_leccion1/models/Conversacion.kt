package com.example.ucu2024_android_lazylayouts_leccion1.models

class Conversacion(
    val Contacto: Contacto,
) {
    val Mensajes: MutableList<Mensaje> = mutableListOf()
}