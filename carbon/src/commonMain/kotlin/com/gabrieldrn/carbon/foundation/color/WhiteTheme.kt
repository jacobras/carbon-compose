// ----------------------------------
// /!\ Generated code. Do not modify.
// ----------------------------------
package com.gabrieldrn.carbon.foundation.color

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.gabrieldrn.carbon.foundation.color.ai.AiColors
import com.gabrieldrn.carbon.foundation.color.ai.WhiteAiColors
import com.gabrieldrn.carbon.foundation.color.button.ButtonColors
import com.gabrieldrn.carbon.foundation.color.button.WhiteButtonColors
import com.gabrieldrn.carbon.foundation.color.chat.ChatColors
import com.gabrieldrn.carbon.foundation.color.chat.WhiteChatColors
import com.gabrieldrn.carbon.foundation.color.notification.NotificationColors
import com.gabrieldrn.carbon.foundation.color.notification.WhiteNotificationColors
import com.gabrieldrn.carbon.foundation.color.tag.TagColors
import com.gabrieldrn.carbon.foundation.color.tag.WhiteTagColors
import kotlin.Suppress

/**
 * One of the default _light_ themes available in Carbon.
 *
 * This theme uses White as the global background color and is layered first with components using
 * Gray 10 backgrounds.
 *
 * The second layer uses White and the third layer used Gray 10.
 */
@Immutable
@Suppress("UndocumentedPublicProperty")
public object WhiteTheme : Theme() {
    override val background: Color = Color(0xFFFFFFFF)

    override val backgroundActive: Color = Color(0x7F8D8D8D)

    override val backgroundBrand: Color = Color(0xFF0F62FE)

    override val backgroundHover: Color = Color(0x1E8D8D8D)

    override val backgroundInverse: Color = Color(0xFF393939)

    override val backgroundInverseHover: Color = Color(0xFF474747)

    override val backgroundSelected: Color = Color(0x338D8D8D)

    override val backgroundSelectedHover: Color = Color(0x518D8D8D)

    override val borderDisabled: Color = Color(0xFFC6C6C6)

    override val borderInteractive: Color = Color(0xFF0F62FE)

    override val borderInverse: Color = Color(0xFF161616)

    override val borderStrong01: Color = Color(0xFF8D8D8D)

    override val borderStrong02: Color = Color(0xFF8D8D8D)

    override val borderStrong03: Color = Color(0xFF8D8D8D)

    override val borderSubtle00: Color = Color(0xFFE0E0E0)

    override val borderSubtle01: Color = Color(0xFFC6C6C6)

    override val borderSubtle02: Color = Color(0xFFE0E0E0)

    override val borderSubtle03: Color = Color(0xFFC6C6C6)

    override val borderSubtleSelected01: Color = Color(0xFFC6C6C6)

    override val borderSubtleSelected02: Color = Color(0xFFC6C6C6)

    override val borderSubtleSelected03: Color = Color(0xFFC6C6C6)

    override val borderTile01: Color = Color(0xFFC6C6C6)

    override val borderTile02: Color = Color(0xFFA8A8A8)

    override val borderTile03: Color = Color(0xFFC6C6C6)

    override val field01: Color = Color(0xFFF4F4F4)

    override val field02: Color = Color(0xFFFFFFFF)

    override val field03: Color = Color(0xFFF4F4F4)

    override val fieldHover01: Color = Color(0xFFE8E8E8)

    override val fieldHover02: Color = Color(0xFFE8E8E8)

    override val fieldHover03: Color = Color(0xFFE8E8E8)

    override val focus: Color = Color(0xFF0F62FE)

    override val focusInset: Color = Color(0xFFFFFFFF)

    override val focusInverse: Color = Color(0xFFFFFFFF)

    override val highlight: Color = Color(0xFFD0E2FF)

    override val iconDisabled: Color = Color(0x3F161616)

    override val iconInteractive: Color = Color(0xFF0F62FE)

    override val iconInverse: Color = Color(0xFFFFFFFF)

    override val iconOnColor: Color = Color(0xFFFFFFFF)

    override val iconOnColorDisabled: Color = Color(0xFF8D8D8D)

    override val iconPrimary: Color = Color(0xFF161616)

    override val iconSecondary: Color = Color(0xFF525252)

    override val interactive: Color = Color(0xFF0F62FE)

    override val layer01: Color = Color(0xFFF4F4F4)

    override val layer02: Color = Color(0xFFFFFFFF)

    override val layer03: Color = Color(0xFFF4F4F4)

    override val layerAccent01: Color = Color(0xFFE0E0E0)

    override val layerAccent02: Color = Color(0xFFE0E0E0)

    override val layerAccent03: Color = Color(0xFFE0E0E0)

    override val layerAccentActive01: Color = Color(0xFFA8A8A8)

    override val layerAccentActive02: Color = Color(0xFFA8A8A8)

    override val layerAccentActive03: Color = Color(0xFFA8A8A8)

    override val layerAccentHover01: Color = Color(0xFFD1D1D1)

    override val layerAccentHover02: Color = Color(0xFFD1D1D1)

    override val layerAccentHover03: Color = Color(0xFFD1D1D1)

    override val layerActive01: Color = Color(0xFFC6C6C6)

    override val layerActive02: Color = Color(0xFFC6C6C6)

    override val layerActive03: Color = Color(0xFFC6C6C6)

    override val layerHover01: Color = Color(0xFFE8E8E8)

    override val layerHover02: Color = Color(0xFFE8E8E8)

    override val layerHover03: Color = Color(0xFFE8E8E8)

    override val layerSelected01: Color = Color(0xFFE0E0E0)

    override val layerSelected02: Color = Color(0xFFE0E0E0)

    override val layerSelected03: Color = Color(0xFFE0E0E0)

    override val layerSelectedDisabled: Color = Color(0xFF8D8D8D)

    override val layerSelectedHover01: Color = Color(0xFFD1D1D1)

    override val layerSelectedHover02: Color = Color(0xFFD1D1D1)

    override val layerSelectedHover03: Color = Color(0xFFD1D1D1)

    override val layerSelectedInverse: Color = Color(0xFF161616)

    override val linkInverse: Color = Color(0xFF78A9FF)

    override val linkInverseActive: Color = Color(0xFFF4F4F4)

    override val linkInverseHover: Color = Color(0xFFA6C8FF)

    override val linkInverseVisited: Color = Color(0xFFBE95FF)

    override val linkPrimary: Color = Color(0xFF0F62FE)

    override val linkPrimaryHover: Color = Color(0xFF0043CE)

    override val linkSecondary: Color = Color(0xFF0043CE)

    override val linkVisited: Color = Color(0xFF8A3FFC)

    override val overlay: Color = Color(0x7F161616)

    override val shadow: Color = Color(0x4C000000)

    override val skeletonBackground: Color = Color(0xFFE8E8E8)

    override val skeletonElement: Color = Color(0xFFC6C6C6)

    override val supportCautionMajor: Color = Color(0xFFFF832B)

    override val supportCautionMinor: Color = Color(0xFFF1C21B)

    override val supportCautionUndefined: Color = Color(0xFF8A3FFC)

    override val supportError: Color = Color(0xFFDA1E28)

    override val supportErrorInverse: Color = Color(0xFFFA4D56)

    override val supportInfo: Color = Color(0xFF0043CE)

    override val supportInfoInverse: Color = Color(0xFF4589FF)

    override val supportSuccess: Color = Color(0xFF24A148)

    override val supportSuccessInverse: Color = Color(0xFF42BE65)

    override val supportWarning: Color = Color(0xFFF1C21B)

    override val supportWarningInverse: Color = Color(0xFFF1C21B)

    override val textDisabled: Color = Color(0x3F161616)

    override val textError: Color = Color(0xFFDA1E28)

    override val textHelper: Color = Color(0xFF6F6F6F)

    override val textInverse: Color = Color(0xFFFFFFFF)

    override val textOnColor: Color = Color(0xFFFFFFFF)

    override val textOnColorDisabled: Color = Color(0xFF8D8D8D)

    override val textPlaceholder: Color = Color(0x66161616)

    override val textPrimary: Color = Color(0xFF161616)

    override val textSecondary: Color = Color(0xFF525252)

    override val toggleOff: Color = Color(0xFF8D8D8D)

    override val aiColors: AiColors = WhiteAiColors

    override val buttonColors: ButtonColors = WhiteButtonColors

    override val chatColors: ChatColors = WhiteChatColors

    override val notificationColors: NotificationColors = WhiteNotificationColors

    override val tagColors: TagColors = WhiteTagColors
}
