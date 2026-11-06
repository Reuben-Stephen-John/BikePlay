# BikePlay — motorcycle CarPlay receiver

**BikePlay** is a fork of [DiPlay](https://github.com/shihabal3amri/DiPlay) for **motorcycles** (road riding), not bicycle-only paths. It keeps the same CarPlay receiver core while tuning setup and controls for a phone on the handlebars and an iPhone in your pocket.

This is **not an Apple-certified** CarPlay product. See [DiPlay compatibility notes](COMPATIBILITY.md) and [third-party notices](THIRD_PARTY_NOTICES.md).

## Hardware setup

| Role | Device | Notes |
| --- | --- | --- |
| **Display / receiver** | Android phone on the **handlebar mount** | Install the `:mobile` APK (`com.shihab.diplay` today). Portrait or landscape bar mount; keep USB power connected on long rides. |
| **CarPlay source** | **iPhone in a pocket** (or tank bag) | Maps, music, Siri — same as in a car. |
| **Link** | **Wireless CarPlay** (primary) or USB | Pair once in DiPlay/BikePlay connection setup. Wi‑Fi Direct, phone hotspot, or Existing Wi‑Fi / Same LAN at home works the same as upstream DiPlay. |

Install and connect steps: [INSTALL.md](INSTALL.md). Wireless tuning: [SMOOTH_WIRELESS.md](SMOOTH_WIRELESS.md), [EXISTING_WIFI.md](EXISTING_WIFI.md).

## Navigation and maps

- **Google Maps on CarPlay** uses **driving** mode. For motorcycles that is usually correct (unlike bicycle mode on a bike computer).
- Optional iPhone apps (Kurviger, Calimoto, Scenic, etc.) still route on the phone; CarPlay shows what those apps expose.
- Turn on **Report location to iPhone** (Settings → Overview quick settings or Navigation) so the mount phone’s GPS feeds CarPlay — better speed and tunnel behavior than a stale zero.

## Display, volume, and readability

Use **Settings → Display** for CarPlay picture and performance:

| Goal | Where in DiPlay/BikePlay |
| --- | --- |
| **Largest CarPlay icons and text** | Display → resolution / icon size slider (up to **160%**) |
| **Larger menus on the Android app** | Display → **Interface size** (e.g. **150%** — does not scale CarPlay itself) |
| **Smoother old mount phones** | Display → **Frame rate** → **30 fps**; keep **HEVC** off unless you know the phone handles it |
| **Sun / gloves** | Home **Ride controls** card: **Screen brightness** and **Media volume**; grant **Modify system settings** if brightness should stick system-wide |

**Ride preset** (home screen **Ride controls** card — apply before connecting):

- CarPlay icon/text size **160%**
- Interface size **150%**
- **30 fps**, **HEVC off**

Reconnect CarPlay after changing display negotiation (use **Reconnect now** when prompted).

## Audio

- **Settings → Audio** — media vs navigation streams, buffering, navigation attenuation.
- Helmet Bluetooth may change which stream is audible; use the in-app test tones if guidance is too quiet.

## Build and upstream credit

BikePlay is derived from:

- [shihabal3amri/DiPlay](https://github.com/shihabal3amri/DiPlay) (GPL-3.0 receiver lineage from [xcertplay](https://github.com/shilapi/xcertplay))
- DiAuto-derived UI (AGPL-3.0 — see [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md))

When you ship binaries, preserve license notices and offer corresponding source per GPL/AGPL.

Build: [BUILD.md](BUILD.md) — select the **`mobile`** module for the receiver APK.

## Safety

Mount the phone where you can glance legally and safely. Local laws on phone use while riding vary. Prefer audio navigation when moving; configure video and overlays while stopped.
