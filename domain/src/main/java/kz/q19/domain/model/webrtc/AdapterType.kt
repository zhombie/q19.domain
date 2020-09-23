@file:Suppress("unused")

package kz.q19.domain.model.webrtc

enum class AdapterType(val bitMask: Int) {
    UNKNOWN(0),
    ETHERNET(1),
    WIFI(2),
    CELLULAR(4),
    VPN(8),
    LOOPBACK(16),
    ADAPTER_TYPE_ANY(32);
}