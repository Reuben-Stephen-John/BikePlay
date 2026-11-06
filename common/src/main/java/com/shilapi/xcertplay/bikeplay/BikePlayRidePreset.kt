// SPDX-License-Identifier: AGPL-3.0-only
package com.shilapi.xcertplay.bikeplay

import android.content.Context
import com.shilapi.xcertplay.AirPlayPersistence
import com.shilapi.xcertplay.InterfaceSize
import com.shilapi.xcertplay.airplay.CarPlayDisplayScale

/** Outdoor motorcycle defaults: largest CarPlay text/icons, large DiPlay UI, 30 fps, HEVC off. */
object BikePlayRidePreset {
    const val INTERFACE_SIZE_PERCENT = 150
    const val FRAME_RATE = 30

    fun isActive(context: Context): Boolean =
        AirPlayPersistence.loadDisplayScalePercent(context) == CarPlayDisplayScale.MAX_PERCENT &&
            InterfaceSize.preference(context) == INTERFACE_SIZE_PERCENT &&
            AirPlayPersistence.loadFps(context) == FRAME_RATE &&
            !AirPlayPersistence.loadHevcEnabled(context)

    /** @return true when the activity should recreate for interface-size scaling. */
    fun apply(context: Context): Boolean {
        val interfaceChanged = InterfaceSize.preference(context) != INTERFACE_SIZE_PERCENT
        AirPlayPersistence.saveDisplayScalePercent(context, CarPlayDisplayScale.MAX_PERCENT)
        AirPlayPersistence.saveFps(context, FRAME_RATE)
        AirPlayPersistence.saveHevcEnabled(context, false)
        InterfaceSize.save(context, INTERFACE_SIZE_PERCENT)
        return interfaceChanged
    }
}
