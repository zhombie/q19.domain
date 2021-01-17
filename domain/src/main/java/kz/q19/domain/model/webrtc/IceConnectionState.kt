package kz.q19.domain.model.webrtc

import androidx.annotation.Keep

@Keep
enum class IceConnectionState {
    NEW,
    CHECKING,
    CONNECTED,
    COMPLETED,
    FAILED,
    DISCONNECTED,
    CLOSED;
}