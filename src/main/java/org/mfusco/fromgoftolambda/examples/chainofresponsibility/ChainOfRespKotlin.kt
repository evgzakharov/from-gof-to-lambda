package org.mfusco.fromgoftolambda.examples.chainofresponsibility

import org.mfusco.fromgoftolambda.examples.chainofresponsibility.File.Type.*

fun parseText(file: File) = if (file.type == TEXT) "Text file: ${file.content}" else null
fun parsePresentation(file: File) = if (file.type == PRESENTATION) "Presentation file: ${file.content}" else null
fun parseAudio(file: File) = if (file.type == AUDIO) "Audio file: ${file.content}" else null
fun parseVideo(file: File) = if (file.type == VIDEO) "Video file: ${file.content}" else null

fun main(args: Array<String>) {
    val file = File(AUDIO, "Dream Theater  - The Astonishing")

    println(listOf(::parseText, ::parsePresentation, ::parseVideo, ::parseAudio)
            .mapNotNull { it(file) }
            .firstOrNull() ?: RuntimeException("Unknown file $file"))
}
