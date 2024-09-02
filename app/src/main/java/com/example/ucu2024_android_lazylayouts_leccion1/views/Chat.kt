package com.example.ucu2024_android_lazylayouts_leccion1.views

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ucu2024_android_lazylayouts_leccion1.R
import com.example.ucu2024_android_lazylayouts_leccion1.models.Contacto
import com.example.ucu2024_android_lazylayouts_leccion1.models.Conversacion
import com.example.ucu2024_android_lazylayouts_leccion1.models.TiposConversacion
import com.example.ucu2024_android_lazylayouts_leccion1.ui.theme.alt.Ucu2024androidlazylayoutsleccion1Theme
import com.example.ucu2024_android_lazylayouts_leccion1.utils.ContactosPrecarga
import com.example.ucu2024_android_lazylayouts_leccion1.utils.PrecargarDatos
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


@Composable
fun ChatView(innerPadding: PaddingValues) {
    val precargaDeDatos: MutableState<ContactosPrecarga> = remember { mutableStateOf(PrecargarDatos()) }

    val usuarioActivo: Contacto = precargaDeDatos.value.Usuario
    val conversaciones: MutableList<Conversacion> = precargaDeDatos.value.Conversaciones
    val conversacionesNoLeidas: Int = precargaDeDatos.value.ConversacionesNoLeidas

    val conversacionesItems: MutableState<List<ConversacionesItem>> = remember { mutableStateOf(
        conversaciones.map { ConversacionesItem(
            it.GetImagen(usuarioActivo.Id),
            it.GetNombre(usuarioActivo.Id),
            it.GetUltimoMensaje()?.Contenido,
            it.GetMensajesNuevos(usuarioActivo.Id),
            it.GetUltimoMensaje()?.Enviado,
            it.tipo!!,
        ) }
    ) }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface),
    ) {
        HeaderComponent()
        TabSelectorComponent(conversacionesNoLeidas)
        ChatContentsWrapper(usuarioActivo, conversacionesItems.value)
    }
}

@Composable
internal fun HeaderComponent() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = "Chaldea's Chat",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .align(Alignment.CenterVertically)
        )
        Row {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.outline_photo_camera_24), contentDescription = "Camara", tint = MaterialTheme.colorScheme.onSurface)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.outline_search_24), contentDescription = "Búsqueda", tint = MaterialTheme.colorScheme.onSurface)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.outline_more_vert_24), contentDescription = "Opciones", tint = MaterialTheme.colorScheme.onSurface)
            }
        }
    }
}

internal data class TabItem(
    val index: Int,
    val label: String?,
    val icon: Int?,
    val indicator: String?,
)

@Composable
internal fun TabSelectorComponent(conversacionesNoLeidas: Int) {
    var tabIndex = 1
    val tabs: List<TabItem> = listOf(
        TabItem(0, null, R.drawable.baseline_groups_24, null),
        TabItem(1, "Chats", null, "$conversacionesNoLeidas"),
        TabItem(2, "Status", null,
            null),
        TabItem(3, "Calls", null, null),
    )

    TabRow(
        selectedTabIndex = tabIndex,
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
//        indicator = @Composable { tabPositions ->
//            TabRowDefaults.SecondaryIndicator(
//                Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
//                color = MaterialTheme.colorScheme.onSurface,
//                height = 3.dp,
//            )
//        },
    ) {
        tabs.forEach {
            TabItemComponent(it, tabIndex == it.index)
        }
    }
}

@Composable
internal fun TabItemComponent(tabItem: TabItem, selected: Boolean) {
    Tab(
        selected = selected,
        onClick = { /* TODO */ },
        modifier = Modifier
            .padding(10.dp),
    ) {
        if (tabItem.icon != null)
            Icon(
                painter = painterResource(id = tabItem.icon),
                contentDescription = "${tabItem.label}",
                tint = MaterialTheme.colorScheme.onSurface,
            )
        else if (tabItem.label != null && tabItem.indicator != null) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = tabItem.label,
                    style = MaterialTheme.typography.titleMedium,
                )
                Badge(
                    containerColor = MaterialTheme.colorScheme.onSurface,
                    contentColor = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                        .padding(start = (5 + 0.8 * tabItem.indicator.length).dp),
                ) {
                    Text(text = tabItem.indicator)
                }
            }
        }
        else if (tabItem.label != null)
            Text(
                text = tabItem.label,
                style = MaterialTheme.typography.titleMedium,
            )
    }
}

internal data class ConversacionesItem(
    val imagen: Int,
    val nombre: String,
    val ultimoMensaje: String?,
    val noLeidos: Int,
    val ultimaActividad: ZonedDateTime?,
    val tipo: TiposConversacion,
)

@Composable
internal fun ChatContentsWrapper(usuario: Contacto, conversaciones: List<ConversacionesItem>) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .fillMaxSize(),
    ) {
        ChatContents(usuario, conversaciones)
        FloatingActionButton(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(25.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_chat_24),
                contentDescription = "New chat",
            )
        }
    }
}

@Composable
internal fun ChatContents(usuario: Contacto, conversaciones: List<ConversacionesItem>) {
    LazyColumn(
        modifier = Modifier
            //.background(MaterialTheme.colorScheme.surfaceContainer)
            .fillMaxSize(),
    ) {
        item {
            ChatContentsItemGeneral(texto = "Locked chats", icono = R.drawable.outline_lock_24, indicador = null)
        }
        item {
            ChatContentsItemGeneral(texto = "Archived", icono = R.drawable.outline_lock_24, indicador = "8")
        }
        items(conversaciones) {
            ChatContentsItemConversacion(it)
        }
    }
}

@Composable
internal fun ChatContentsItemGeneral(texto: String, icono: Int, indicador: String?) {
    TextButton(
        onClick = { /*TODO*/ },
        shape = RectangleShape
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight(),
            ) {
                Icon(
                    painter = painterResource(id = icono),
                    contentDescription = texto,
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .padding(start = 10.dp, end = 25.dp)
                        .width(30.dp)
                        .height(30.dp),
                )
                Text(
                    text = texto,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                )
            }
            if (indicador != null)
                Badge(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                ) {
                    Text(text = indicador)
                }
        }
    }
}

@Composable
internal fun ChatContentsItemConversacion(conversacion: ConversacionesItem) {
    val today: LocalDateTime = LocalDate.now().atStartOfDay()
    val yesterday: LocalDateTime = today.minusDays(1)
    val thisWeek: LocalDateTime = today.minusDays(7)
    val thisYear: LocalDateTime = today.withDayOfYear(1)

    val timeStamp: String =
        if (conversacion.ultimaActividad == null)
            "Never"
        else if (conversacion.ultimaActividad.toLocalDateTime().isAfter(today))
            conversacion.ultimaActividad.toLocalDateTime().format(DateTimeFormatter.ofPattern("HH:mm"))
        else if (conversacion.ultimaActividad.toLocalDateTime().isAfter(yesterday))
            "Yesterday"
        else if (conversacion.ultimaActividad.toLocalDateTime().isAfter(thisWeek))
            conversacion.ultimaActividad.toLocalDateTime().format(DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH)).replaceFirstChar { chr -> chr.uppercaseChar() }
        else if (conversacion.ultimaActividad.toLocalDateTime().isAfter(thisYear))
            conversacion.ultimaActividad.toLocalDateTime().format(DateTimeFormatter.ofPattern("L d", Locale.ENGLISH))
        else
            conversacion.ultimaActividad.toLocalDateTime().format(DateTimeFormatter.ofPattern("d/M/y"))

    TextButton(
        onClick = { /*TODO*/ },
        shape = RectangleShape,
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Image(
                painter = painterResource(id = conversacion.imagen),
                contentDescription = conversacion.nombre,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(65.dp)
                    .height(50.dp)
                    .padding(end = 15.dp)
                    .border(
                        width = 0.dp,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(25.dp),
                    )
                    .clip(CircleShape),
            )

            Column(
                modifier = Modifier
                    .padding(end = 10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = conversacion.nombre,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        overflow = TextOverflow.Ellipsis,
                        softWrap = false,
                    )
                    Text(
                        text = timeStamp,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .alpha(0.7f),
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = conversacion.ultimoMensaje?:"No messages.",
                        style = MaterialTheme.typography.bodyMedium,
                        fontStyle = if (conversacion.ultimoMensaje == null) FontStyle.Italic else null,
                        color = MaterialTheme.colorScheme.onSurface,
                        overflow = TextOverflow.Ellipsis,
                        softWrap = false,
                        modifier = Modifier
                            .alpha(0.7f)
                            .weight(1f),
                    )
                    if (conversacion.noLeidos > 0)
                        Badge(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .padding(start = 5.dp)
                        ) {
                            Text(text = "${conversacion.noLeidos}")
                        }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatViewPreview() {
    Ucu2024androidlazylayoutsleccion1Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ChatView(innerPadding)
        }
    }
}