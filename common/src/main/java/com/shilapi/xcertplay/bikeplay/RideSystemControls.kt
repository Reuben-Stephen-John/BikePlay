// SPDX-License-Identifier: AGPL-3.0-only
package com.shilapi.xcertplay.bikeplay

import android.app.Activity
import android.content.Context
import android.media.AudioManager
import android.provider.Settings

/** System brightness and media volume for the mount phone (BikePlay home panel). */
object RideSystemControls {
    val brightnessSteps: List<Int> = (0..255 step 17).toList().let { steps ->
        if (steps.last() != 255) steps + 255 else steps
    }

    fun readBrightness(context: Context): Int = runCatching {
        Settings.System.getInt(context.contentResolver, Settings.System.SCREEN_BRIGHTNESS)
    }.getOrDefault(128).coerceIn(0, 255)

    /** @return true when the value was written to system brightness. */
    fun writeBrightness(context: Context, value: Int): Boolean {
        val clamped = value.coerceIn(0, 255)
        if (Settings.System.canWrite(context)) {
            Settings.System.putInt(context.contentResolver, Settings.System.SCREEN_BRIGHTNESS, clamped)
            return true
        }
        (context as? Activity)?.window?.let { window ->
            val attrs = window.attributes
            attrs.screenBrightness = clamped / 255f
            window.attributes = attrs
        }
        return false
    }

    fun mediaVolumeSteps(audio: AudioManager): List<Int> =
        (0..audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC)).toList()

    fun readMediaVolume(audio: AudioManager): Int =
        audio.getStreamVolume(AudioManager.STREAM_MUSIC)

    fun writeMediaVolume(audio: AudioManager, value: Int) {
        val max = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        audio.setStreamVolume(
            AudioManager.STREAM_MUSIC,
            value.coerceIn(0, max),
            0,
        )
    }
}
