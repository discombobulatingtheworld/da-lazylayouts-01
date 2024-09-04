package com.example.ucu2024_android_lazylayouts_leccion1.utils

import com.example.ucu2024_android_lazylayouts_leccion1.R
import com.example.ucu2024_android_lazylayouts_leccion1.models.Contacto
import com.example.ucu2024_android_lazylayouts_leccion1.models.Conversacion
import com.example.ucu2024_android_lazylayouts_leccion1.models.Mensaje
import java.time.ZoneId
import java.time.ZonedDateTime


data class ContactosPrecarga internal constructor(
    val Usuario: Contacto,
    val Contactos: MutableList<Contacto>,
    val Conversaciones: MutableList<Conversacion>,
    val ConversacionesNoLeidas: Int,
)

internal fun GetContactos(): MutableMap<String, Contacto> {
    val contactos: MutableMap<String, Contacto> = mutableMapOf(
        "Merlin" to Contacto("Merlin", R.drawable.profiles_merlin),
        "Artoria Pendragon" to Contacto("Seiba", R.drawable.profiles_artoria),
        "Asterios" to Contacto("Asterios", R.drawable.profiles_asterios),
        "Heracles" to Contacto("Basaka", R.drawable.profiles_heracles),
        "Tamamo Cat" to Contacto("Cat", R.drawable.profiles_cat),
        "Cú Chulainn" to Contacto("Cú", R.drawable.profiles_cu),
        "Elizabeth Bathory" to Contacto("Elly", R.drawable.profiles_elly),
        "Emiya" to Contacto("Emiya", R.drawable.profiles_emiya),
        "Euryale" to Contacto("Euryale", R.drawable.profiles_euryale),
        "Gilgamesh" to Contacto("Gilgamesh", R.drawable.profiles_gil),
        "Hans Christian Andersen" to Contacto("Hans Christian Andersen", R.drawable.profiles_hans),
        "Kiyohime" to Contacto("Kiyokiyo", R.drawable.profiles_kiyo),
        "Jeanne D'Arc" to Contacto("Jeanne", R.drawable.profiles_jeanne),
        "Jeanne D'Arc Alter" to Contacto("Jalter", R.drawable.profiles_jalter),
        "Jeanne D'Arc Alter Lily" to Contacto("Janta", R.drawable.profiles_janta),
        "Tiamat" to Contacto("Tiamom", R.drawable.profiles_tiamat),
        "Ishtar" to Contacto("Ishtar", R.drawable.profiles_ishtar),
        "Solomon" to Contacto("Solomon", R.drawable.profiles_solomon),
        "Tamamo no Mae" to Contacto("Tamamo", R.drawable.profiles_tamamo),
        "William Shakespeare" to Contacto("William Shakespeare", R.drawable.profiles_shakespeare),
        "Ritsuka Fujimaru" to Contacto("Gudako", R.drawable.profiles_gudako),
    )

    return contactos
}

internal fun GetConversaciones(contactos: MutableMap<String, Contacto>, usuario: Contacto): MutableList<Conversacion> {
    val conversaciones: Map<String, Conversacion> = mapOf(
        "fishing_trip" to Conversacion(mutableListOf(
            usuario,
            contactos["Cú Chulainn"]!!,
            contactos["Emiya"]!!,
            contactos["Gilgamesh"]!!,
        ), "Fishing Trip", R.drawable.group_fishing),
        "helicopter_mom" to Conversacion(usuario, contactos["Tiamat"]!!),
        "sister_trio" to Conversacion(mutableListOf(
            usuario,
            contactos["Jeanne D'Arc"]!!,
            contactos["Jeanne D'Arc Alter"]!!,
            contactos["Jeanne D'Arc Alter Lily"]!!,
        ), "Sisterhood of Jeanne", R.drawable.group_sisters),
        "idol_concert_prep" to Conversacion(mutableListOf(
            usuario,
            contactos["Elizabeth Bathory"]!!,
            contactos["Kiyohime"]!!,
        ), "Elly's Halloween Show Prep!!", R.drawable.group_elly),
        "book_club" to Conversacion(mutableListOf(
            usuario,
            contactos["Hans Christian Andersen"]!!,
            contactos["William Shakespeare"]!!,
            contactos["Jeanne D'Arc Alter"]!!,
        ), "Book Club", R.drawable.group_bookclub),
        "maid_service" to Conversacion(usuario, contactos["Tamamo Cat"]!!),
        "kings_conference" to Conversacion(mutableListOf(
            usuario,
            contactos["Artoria Pendragon"]!!,
            contactos["Solomon"]!!,
            contactos["Gilgamesh"]!!,
        ), "Conference of Kings", R.drawable.group_kings),
        "merlins_batsignal" to Conversacion(usuario, contactos["Merlin"]!!),
        "tea_party" to Conversacion(mutableListOf(
            usuario,
            contactos["Asterios"]!!,
            contactos["Euryale"]!!,
        ), "Friday Afternoon Tea", R.drawable.group_tea),
        "heracles_tries_texting" to Conversacion(usuario, contactos["Heracles"]!!),
        "red_line" to Conversacion(mutableListOf(
            usuario,
            contactos["Gilgamesh"]!!,
            contactos["Ishtar"]!!,
        ), "Red Phone - Mesopotamia", R.drawable.group_mesopotamia),
        *contactos.filter { !listOf("Tiamat", "Tamamo Cat", "Merlin", "Heracles", "Ritsuka Fujimaru").contains(it.key) }.map {
            it.key.lowercase().replace(regex = Regex("[\\s\']"), replacement = "_") to Conversacion(usuario, contactos[it.key]!!)
        }.toTypedArray()
    )

    val zone: ZoneId = ZoneId.of("America/Montevideo")

    // All dummy data generated with ChatGPT 4o. Praise be its automated holiness.
    // Prompt and conversation log can be obtained here: https://chatgpt.com/share/70227f87-e30b-4aae-b9c8-6389ab403522

    conversaciones["fishing_trip"]?.EnviarMensaje(Mensaje("Well then, mongrels, who's ready for a fishing trip worthy of a king? I’ll bring the finest rods from Uruk.", contactos["Gilgamesh"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(459)))
    conversaciones["fishing_trip"]?.EnviarMensaje(Mensaje("Fishing, huh? Sounds like a good time. I’ll bring the bait. You guys better be ready for some serious competition.", contactos["Cú Chulainn"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(450)))
    conversaciones["fishing_trip"]?.EnviarMensaje(Mensaje("I’ll handle the food. Freshly caught fish will make for a great meal. I can prepare something on-site.", contactos["Emiya"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(435)))
    conversaciones["fishing_trip"]?.EnviarMensaje(Mensaje("Hmph, as if mere mortals could surpass the King in anything, even fishing. But very well, prepare yourselves.", contactos["Gilgamesh"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(410)))
    conversaciones["fishing_trip"]?.EnviarMensaje(Mensaje("Is that a challenge, Goldie? I’ve got the luck of the Irish on my side.", contactos["Cú Chulainn"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(409)))
    conversaciones["fishing_trip"]?.EnviarMensaje(Mensaje("We’ll see who lands the biggest catch. Just don’t forget to relax and enjoy it, you two.", contactos["Emiya"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(408)))
    conversaciones["fishing_trip"]?.EnviarMensaje(Mensaje("As if I could be outdone. To the lake, then! The King leads the way.", contactos["Gilgamesh"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(405)))
    conversaciones["fishing_trip"]?.EnviarMensaje(Mensaje("Just don’t fall in, Goldie. Wouldn’t want to have to fish you out.", contactos["Cú Chulainn"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(403)))
    conversaciones["fishing_trip"]?.EnviarMensaje(Mensaje("This will be interesting. Let’s meet at dawn.", contactos["Emiya"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(386)))

    conversaciones["sister_trio"]?.EnviarMensaje(Mensaje("I've been thinking... we should have a place just for us sisters to talk. What do you think?", contactos["Jeanne D'Arc"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusMinutes(1345)))

    conversaciones["sister_trio"]?.EnviarMensaje(Mensaje("Sisters, huh? I don't mind. But if this gets too sappy, I’m out.", contactos["Jeanne D'Arc Alter"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusMinutes(1320)))

    conversaciones["sister_trio"]?.EnviarMensaje(Mensaje("Sisters!! Yay! This sounds like so much fun! Let’s talk all the time!", contactos["Jeanne D'Arc Alter Lily"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusMinutes(1290)))

    conversaciones["sister_trio"]?.EnviarMensaje(Mensaje("I’m glad you’re both on board. We’ll make this group our little sanctuary.", contactos["Jeanne D'Arc"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusMinutes(1250)))

    conversaciones["sister_trio"]?.EnviarMensaje(Mensaje("Fine. Just don’t expect me to be all sunshine and rainbows, alright?", contactos["Jeanne D'Arc Alter"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusMinutes(1230)))

    conversaciones["sister_trio"]?.EnviarMensaje(Mensaje("Hehe, that’s what makes you special, Alter. We’ll all get along just fine!", contactos["Jeanne D'Arc Alter Lily"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusMinutes(1200)))

    conversaciones["sister_trio"]?.EnviarMensaje(Mensaje("Thank you, Ritsuka, for setting this up. I feel like we’ll grow even closer.", contactos["Jeanne D'Arc"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusMinutes(1150)))

    conversaciones["sister_trio"]?.EnviarMensaje(Mensaje("I'm happy to help. You three deserve a place to connect.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusMinutes(1130)))

    // ----------

    conversaciones["helicopter_mom"]?.EnviarMensaje(Mensaje("Ritsuka, did you eat your breakfast this morning? Don’t lie.", contactos["Tiamat"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(30)))

    conversaciones["helicopter_mom"]?.EnviarMensaje(Mensaje("Yes, mom. I had a full meal. No need to worry.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(28)))

    conversaciones["helicopter_mom"]?.EnviarMensaje(Mensaje("Good. Make sure it stays that way. Have you taken any breaks? Overworking yourself is unacceptable.", contactos["Tiamat"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(20)))

    conversaciones["helicopter_mom"]?.EnviarMensaje(Mensaje("I’ve been taking breaks, I promise. I know better than to ignore your advice.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(15)))

    conversaciones["helicopter_mom"]?.EnviarMensaje(Mensaje("See that you do. You won’t be effective if you’re exhausted. Remember that.", contactos["Tiamat"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(10)))

    conversaciones["helicopter_mom"]?.EnviarMensaje(Mensaje("Understood. Thanks!", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusMinutes(5)))

    // ------------

    conversaciones["idol_concert_prep"]?.EnviarMensaje(Mensaje("Everyone, it’s time! I’m planning my annual Halloween concert, and it’s going to be the best one yet!", contactos["Elizabeth Bathory"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusHours(4).minusMinutes(240)))

    conversaciones["idol_concert_prep"]?.EnviarMensaje(Mensaje("Elly, I’m sure it’ll be great, but… does that mean we’re involved again?", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusHours(4).minusMinutes(230)))

    conversaciones["idol_concert_prep"]?.EnviarMensaje(Mensaje("Of course, Master! I need your support, and you too, Kiyohime! You both have the perfect energy for my backup dancers!", contactos["Elizabeth Bathory"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusHours(4).minusMinutes(215)))

    conversaciones["idol_concert_prep"]?.EnviarMensaje(Mensaje("If it pleases you, Master, I shall obey. But I must warn you, Elizabeth, if anything disturbs Master, there will be consequences.", contactos["Kiyohime"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusHours(4).minusMinutes(190)))

    conversaciones["idol_concert_prep"]?.EnviarMensaje(Mensaje("No need to get worked up, Kiyohime. I’m sure it’ll be fine. Right, Elly?", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusHours(4).minusMinutes(160)))

    conversaciones["idol_concert_prep"]?.EnviarMensaje(Mensaje("Oh, don’t worry! Everything will be perfectly spooky and fabulous! We’re going to blow everyone away with this performance!", contactos["Elizabeth Bathory"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusHours(4).minusMinutes(140)))

    conversaciones["idol_concert_prep"]?.EnviarMensaje(Mensaje("Alright… but if Kiyohime starts breathing fire, I’m out.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusHours(4).minusMinutes(120)))

    conversaciones["idol_concert_prep"]?.EnviarMensaje(Mensaje("I assure you, Master, I will remain composed… as long as Elizabeth’s plans are flawless.", contactos["Kiyohime"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusHours(4).minusMinutes(110)))

    conversaciones["idol_concert_prep"]?.EnviarMensaje(Mensaje("Perfect! We’re going to have so much fun! Let’s get started with rehearsals soon!", contactos["Elizabeth Bathory"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusHours(4).minusMinutes(90)))

    // -----

    conversaciones["book_club"]?.EnviarMensaje(Mensaje("Welcome, everyone, to our latest book club meeting. Today, we’ll be diving into the depths of literary genius once again!", contactos["William Shakespeare"]!!.Id,
        ZonedDateTime.now(zone).minusDays(6).minusHours(6).minusMinutes(360)))

    conversaciones["book_club"]?.EnviarMensaje(Mensaje("Genius, you say? Let’s not get ahead of ourselves, Shakespeare. We’re here to dissect, not indulge in self-congratulation.", contactos["Hans Christian Andersen"]!!.Id,
        ZonedDateTime.now(zone).minusDays(6).minusHours(6).minusMinutes(345)))

    conversaciones["book_club"]?.EnviarMensaje(Mensaje("Why am I here again? This has nothing to do with manga…", contactos["Jeanne D'Arc Alter"]!!.Id,
        ZonedDateTime.now(zone).minusDays(6).minusHours(6).minusMinutes(320)))

    conversaciones["book_club"]?.EnviarMensaje(Mensaje("You’re here because literature comes in many forms, even the fiery pages of your manga, dear Alter.", contactos["William Shakespeare"]!!.Id,
        ZonedDateTime.now(zone).minusDays(6).minusHours(6).minusMinutes(300)))

    conversaciones["book_club"]?.EnviarMensaje(Mensaje("It’s true, manga is a form of storytelling, and we should discuss it too. Though I understand why you might feel out of place, Jeanne Alter.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(6).minusHours(6).minusMinutes(275)))

    conversaciones["book_club"]?.EnviarMensaje(Mensaje("I’d rather burn the pages than read half of what you call literature, but fine. I’m not quitting.", contactos["Jeanne D'Arc Alter"]!!.Id,
        ZonedDateTime.now(zone).minusDays(6).minusHours(6).minusMinutes(250)))

    conversaciones["book_club"]?.EnviarMensaje(Mensaje("Ah, the passion of youth! Such delightful fury! I see a tragic heroine in the making.", contactos["William Shakespeare"]!!.Id,
        ZonedDateTime.now(zone).minusDays(6).minusHours(6).minusMinutes(230)))

    conversaciones["book_club"]?.EnviarMensaje(Mensaje("Save the drama for your next play, Shakespeare. Let’s get started already. I’m not here to waste time.", contactos["Hans Christian Andersen"]!!.Id,
        ZonedDateTime.now(zone).minusDays(6).minusHours(6).minusMinutes(210)))

    conversaciones["book_club"]?.EnviarMensaje(Mensaje("Agreed. The sooner we start, the sooner I can leave.", contactos["Jeanne D'Arc Alter"]!!.Id,
        ZonedDateTime.now(zone).minusDays(6).minusHours(6).minusMinutes(190)))

    conversaciones["book_club"]?.EnviarMensaje(Mensaje("Fine, fine. Let’s get to it. Today’s discussion: the art of tragedy and its impact on modern storytelling.", contactos["William Shakespeare"]!!.Id,
        ZonedDateTime.now(zone).minusDays(6).minusHours(6).minusMinutes(180)))

    // --------

    conversaciones["kings_conference"]?.EnviarMensaje(Mensaje("As the King of Knights, I must insist that nothing surpasses a well-prepared roast. It is the epitome of a banquet centerpiece.", contactos["Artoria Pendragon"]!!.Id,
        ZonedDateTime.now(zone).minusDays(4).minusHours(14).minusMinutes(840)))

    conversaciones["kings_conference"]?.EnviarMensaje(Mensaje("Hmph, a mere roast? How primitive. The finest dish must be something that reflects true grandeur—like the divine dishes of Uruk. Nothing less than the best is acceptable.", contactos["Gilgamesh"]!!.Id,
        ZonedDateTime.now(zone).minusDays(4).minusHours(14).minusMinutes(820)))

    conversaciones["kings_conference"]?.EnviarMensaje(Mensaje("Both of you lack vision. The true essence of a banquet lies in its balance. A combination of flavors, textures, and aromas, orchestrated to perfection. My vote goes to an exquisite spread of diverse dishes, each representing the pinnacle of its kind.", contactos["Solomon"]!!.Id,
        ZonedDateTime.now(zone).minusDays(4).minusHours(14).minusMinutes(800)))

    conversaciones["kings_conference"]?.EnviarMensaje(Mensaje("I feel like I should remind you all that we're here to discuss, not to argue. Let’s keep the swords and magecraft at bay, alright?", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(4).minusHours(14).minusMinutes(780)))

    conversaciones["kings_conference"]?.EnviarMensaje(Mensaje("Very well, but I stand by my choice. A feast is defined by the majesty of its main course, and nothing is more majestic than a roast.", contactos["Artoria Pendragon"]!!.Id,
        ZonedDateTime.now(zone).minusDays(4).minusHours(14).minusMinutes(760)))

    conversaciones["kings_conference"]?.EnviarMensaje(Mensaje("Roast, main course, bah! A true king’s feast must impress with its splendor, its extravagance. Let them witness the wealth of Uruk in every bite.", contactos["Gilgamesh"]!!.Id,
        ZonedDateTime.now(zone).minusDays(4).minusHours(14).minusMinutes(740)))

    conversaciones["kings_conference"]?.EnviarMensaje(Mensaje("Perhaps the real solution lies in a combination. A roast as the centerpiece, surrounded by dishes from across the ages. A royal table worthy of legends.", contactos["Solomon"]!!.Id,
        ZonedDateTime.now(zone).minusDays(4).minusHours(14).minusMinutes(720)))

    conversaciones["kings_conference"]?.EnviarMensaje(Mensaje("Now that sounds like a plan. Maybe this conference won’t end in disaster after all.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(4).minusHours(14).minusMinutes(700)))

    // -------

    conversaciones["merlins_batsignal"]?.EnviarMensaje(Mensaje("Merlin, I hate to say this, but the world’s about to end. Again. We need your help.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(7).minusMinutes(5)))

    conversaciones["merlins_batsignal"]?.EnviarMensaje(Mensaje("Ah, Ritsuka! Always so dramatic. Are you sure it’s really that bad this time?", contactos["Merlin"]!!.Id,
        ZonedDateTime.now(zone).minusDays(7).minusMinutes(4)))

    conversaciones["merlins_batsignal"]?.EnviarMensaje(Mensaje("Yes, it is. Minor singularity, cascading into a potential apocalypse. So, could you stop joking around and help?", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(7).minusMinutes(3)))

    conversaciones["merlins_batsignal"]?.EnviarMensaje(Mensaje("Alright, alright. I suppose I can spare a moment to save the world. Again. You really should learn to handle these things on your own, you know.", contactos["Merlin"]!!.Id,
        ZonedDateTime.now(zone).minusDays(7).minusMinutes(2)))

    conversaciones["merlins_batsignal"]?.EnviarMensaje(Mensaje("I’ll keep that in mind while the world isn’t ending. Now hurry up before we run out of time.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(7).minusMinutes(1)))

    conversaciones["merlins_batsignal"]?.EnviarMensaje(Mensaje("Relax, I’ve got this under control. You worry too much, Ritsuka. Now, let’s fix this mess, shall we?", contactos["Merlin"]!!.Id,
        ZonedDateTime.now(zone).minusDays(7)))

    // -----

    conversaciones["tea_party"]?.EnviarMensaje(Mensaje("Ritsuka, you're joining us for tea on Friday, right? Not that I care or anything, but Asterios likes having you around.", contactos["Euryale"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusMinutes(30)))

    conversaciones["tea_party"]?.EnviarMensaje(Mensaje("Of course, I’d love to join! What are we planning for the menu this time?", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusMinutes(28)))

    conversaciones["tea_party"]?.EnviarMensaje(Mensaje("I… um, I was thinking of some scones and maybe those little sandwiches you like. Asterios enjoys them too.", contactos["Euryale"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusMinutes(25)))

    conversaciones["tea_party"]?.EnviarMensaje(Mensaje("Sandwiches… good. Ritsuka makes good sandwiches.", contactos["Asterios"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusMinutes(20)))

    conversaciones["tea_party"]?.EnviarMensaje(Mensaje("Thanks, Asterios! I’ll make sure to bring plenty. Should we add something sweet? Maybe some pastries or cake?", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusMinutes(18)))

    conversaciones["tea_party"]?.EnviarMensaje(Mensaje("Cake sounds… nice. Asterios likes sweets.", contactos["Asterios"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusMinutes(15)))

    conversaciones["tea_party"]?.EnviarMensaje(Mensaje("Fine, cake it is. But it better not be too sweet! I don’t want to hear any complaints about it being too sugary.", contactos["Euryale"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusMinutes(10)))

    conversaciones["tea_party"]?.EnviarMensaje(Mensaje("Don’t worry, Euryale. I’ll make sure it’s just right. Looking forward to Friday!", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(3).minusMinutes(5)))

    // ------

    conversaciones["heracles_tries_texting"]?.EnviarMensaje(Mensaje("Ritsuka... it's... Hercals... Illya... said... I should... try... this.", contactos["Heracles"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusHours(4).minusMinutes(240)))

    conversaciones["heracles_tries_texting"]?.EnviarMensaje(Mensaje("Hey, Heracles! It’s great to hear from you. How’s it going?", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusHours(4).minusMinutes(230)))

    conversaciones["heracles_tries_texting"]?.EnviarMensaje(Mensaje("Big... fngers... hard... to tipe... but... tryig.", contactos["Heracles"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusHours(4).minusMinutes(215)))

    conversaciones["heracles_tries_texting"]?.EnviarMensaje(Mensaje("You’re doing great! Don’t worry about mistakes. Just take your time.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusHours(4).minusMinutes(200)))

    conversaciones["heracles_tries_texting"]?.EnviarMensaje(Mensaje("Thnks... Ritskua... Illya... said... it helps... with words... stil... hard... but... beter.", contactos["Heracles"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusHours(4).minusMinutes(180)))

    conversaciones["heracles_tries_texting"]?.EnviarMensaje(Mensaje("I’m really proud of you for trying this, Heracles. You can message me anytime. We’ll get through it together.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusHours(4).minusMinutes(150)))

    conversaciones["heracles_tries_texting"]?.EnviarMensaje(Mensaje("I... wil... thnks... Ritsuka... for... undrstanding.", contactos["Heracles"]!!.Id,
        ZonedDateTime.now(zone).minusDays(2).minusHours(4).minusMinutes(120)))

    // ---------

    conversaciones["red_line"]?.EnviarMensaje(Mensaje("Ishtar, what have you done this time? The treasury of Uruk is not your personal playground!", contactos["Gilgamesh"]!!.Id,
        ZonedDateTime.now(zone).minusHours(1).minusMinutes(60)))

    conversaciones["red_line"]?.EnviarMensaje(Mensaje("Oh, come on, Gil. It was just a little investment! I was going to double the treasury in no time!", contactos["Ishtar"]!!.Id,
        ZonedDateTime.now(zone).minusHours(1).minusMinutes(55)))

    conversaciones["red_line"]?.EnviarMensaje(Mensaje("Investment? You call that disaster an investment? You’ve squandered Uruk’s wealth on foolish schemes!", contactos["Gilgamesh"]!!.Id,
        ZonedDateTime.now(zone).minusHours(1).minusMinutes(50)))

    conversaciones["red_line"]?.EnviarMensaje(Mensaje("Alright, both of you, calm down. Ishtar, you need to return whatever you took and stop with these get-rich-quick plans.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusHours(1).minusMinutes(45)))

    conversaciones["red_line"]?.EnviarMensaje(Mensaje("I was just trying to help! If it worked, we’d all be rich by now! But fine, I’ll return it.", contactos["Ishtar"]!!.Id,
        ZonedDateTime.now(zone).minusHours(1).minusMinutes(40)))

    conversaciones["red_line"]?.EnviarMensaje(Mensaje("Help? You’ve caused nothing but losses! The next time you even think about ‘investing’ Uruk’s treasures, I’ll...!", contactos["Gilgamesh"]!!.Id,
        ZonedDateTime.now(zone).minusHours(1).minusMinutes(35)))

    conversaciones["red_line"]?.EnviarMensaje(Mensaje("Gilgamesh, let’s focus on fixing this without any threats, alright? Ishtar, just return everything, and we’ll figure out how to make things right.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusHours(1).minusMinutes(30)))

    conversaciones["red_line"]?.EnviarMensaje(Mensaje("Fine, fine. I’ll return it all. But my plan could’ve worked if the market hadn’t crashed!", contactos["Ishtar"]!!.Id,
        ZonedDateTime.now(zone).minusHours(1).minusMinutes(20)))

    conversaciones["red_line"]?.EnviarMensaje(Mensaje("Good. And as for you, Ishtar, this is your last warning. Test my patience again, and even Ritsuka won’t be able to save you.", contactos["Gilgamesh"]!!.Id,
        ZonedDateTime.now(zone).minusHours(1).minusMinutes(15)))

    conversaciones["red_line"]?.EnviarMensaje(Mensaje("I’ll make sure she stays in line, Gilgamesh. Let’s just get back to our duties. We’ve got enough to deal with without adding more chaos.", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusHours(1).minusMinutes(10)))

    conversaciones["red_line"]?.EnviarMensaje(Mensaje("Hmph, very well. But know that my eyes are on you, Ishtar.", contactos["Gilgamesh"]!!.Id,
        ZonedDateTime.now(zone).minusHours(1).minusMinutes(5)))

    conversaciones["red_line"]?.EnviarMensaje(Mensaje("Yeah, yeah. Whatever. You’ll miss me when I’m not around!", contactos["Ishtar"]!!.Id,
        ZonedDateTime.now(zone)))

    // ------

    conversaciones["maid_service"]?.EnviarMensaje(Mensaje("Master! It’s Cat! How about I become your personal chef? I can cook all your favorite meals!", contactos["Tamamo Cat"]!!.Id,
        ZonedDateTime.now(zone).minusDays(1).minusHours(4).minusMinutes(240)))

    conversaciones["maid_service"]?.EnviarMensaje(Mensaje("Master? Are you there? Did you see my message? I promise my cooking is the best!", contactos["Tamamo Cat"]!!.Id,
        ZonedDateTime.now(zone).minusDays(1).minusHours(4).minusMinutes(220)))

    conversaciones["maid_service"]?.EnviarMensaje(Mensaje("Master... you’re not ignoring me, are you? I’ll make the tastiest dishes! You won’t regret it!", contactos["Tamamo Cat"]!!.Id,
        ZonedDateTime.now(zone).minusDays(1).minusHours(4).minusMinutes(200)))

    conversaciones["maid_service"]?.EnviarMensaje(Mensaje("Master... please respond! I’m really good at cooking, I swear! Please let me be your chef!", contactos["Tamamo Cat"]!!.Id,
        ZonedDateTime.now(zone).minusDays(1).minusHours(4).minusMinutes(180)))

    conversaciones["maid_service"]?.EnviarMensaje(Mensaje("Master... are you mad at me? I can cook anything you want! Just give me a chance!", contactos["Tamamo Cat"]!!.Id,
        ZonedDateTime.now(zone).minusDays(1).minusHours(4).minusMinutes(150)))

    conversaciones["maid_service"]?.EnviarMensaje(Mensaje("Master... *sniff*... I just wanted to help... I’m sorry if I bothered you...", contactos["Tamamo Cat"]!!.Id,
        ZonedDateTime.now(zone).minusDays(1).minusHours(4).minusMinutes(120)))

    conversaciones["maid_service"]?.EnviarMensaje(Mensaje("Sorry, Cat! I was busy. I’d love to have you as my personal chef!", contactos["Ritsuka Fujimaru"]!!.Id,
        ZonedDateTime.now(zone).minusDays(1).minusHours(4).minusMinutes(100)))

    conversaciones["maid_service"]?.EnviarMensaje(Mensaje("Really?! Yay! I promise I’ll make the best meals ever! Let’s start planning the menu right now! What would you like first, Master?!", contactos["Tamamo Cat"]!!.Id,
        ZonedDateTime.now(zone).minusDays(1).minusHours(4).minusMinutes(80)))


    return conversaciones.values.sortedByDescending { it.GetUltimoMensaje()?.Enviado }.toMutableList()
}

fun PrecargarDatos(): ContactosPrecarga {
    val contactosMap: MutableMap<String, Contacto> = GetContactos()

    val contactos: MutableList<Contacto> = contactosMap.values.toMutableList()
    val usuario: Contacto = contactosMap["Ritsuka Fujimaru"]!!
    val conversaciones: MutableList<Conversacion> = GetConversaciones(contactosMap, usuario)

    return ContactosPrecarga(
        Usuario = usuario,
        Contactos = contactos,
        Conversaciones = conversaciones,
        ConversacionesNoLeidas = conversaciones.count { it.GetMensajesNuevos(usuario.Id) > 0 },
    )
}