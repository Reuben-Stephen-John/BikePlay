package com.shilapi.xcertplay.bikeplay

import com.shilapi.xcertplay.AirPlayPersistence
import com.shilapi.xcertplay.InterfaceSize
import com.shilapi.xcertplay.airplay.CarPlayDisplayScale
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33], manifest = Config.NONE)
class BikePlayRidePresetTest {
    private val context get() = RuntimeEnvironment.getApplication()

    @Before
    fun reset() {
        AirPlayPersistence.saveDisplayScalePercent(context, 100)
        AirPlayPersistence.saveFps(context, 60)
        AirPlayPersistence.saveHevcEnabled(context, true)
        InterfaceSize.save(context, InterfaceSize.AUTO)
    }

    @Test
    fun applySetsRideDefaultsAndReportsInterfaceChange() {
        assertTrue(BikePlayRidePreset.apply(context))
        assertTrue(BikePlayRidePreset.isActive(context))
    }

    @Test
    fun isActiveWhenAlreadyAtRideDefaults() {
        BikePlayRidePreset.apply(context)
        InterfaceSize.save(context, BikePlayRidePreset.INTERFACE_SIZE_PERCENT)
        assertFalse(BikePlayRidePreset.apply(context))
        assertTrue(BikePlayRidePreset.isActive(context))
    }

    @Test
    fun inactiveWhenDisplayScaleDiffers() {
        BikePlayRidePreset.apply(context)
        AirPlayPersistence.saveDisplayScalePercent(context, CarPlayDisplayScale.MAX_PERCENT - 10)
        assertFalse(BikePlayRidePreset.isActive(context))
    }
}
