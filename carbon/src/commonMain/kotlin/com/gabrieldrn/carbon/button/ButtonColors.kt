/*
 * Copyright 2024 Gabriel Derrien
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gabrieldrn.carbon.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.gabrieldrn.carbon.Carbon
import com.gabrieldrn.carbon.foundation.color.Theme

@Immutable
internal class ButtonColors private constructor(
    private val theme: Theme,
    private val buttonType: ButtonType,
    private val isIconButton: Boolean,
) {

    private val componentColors = theme.buttonColors

    val containerColor: Color = when (buttonType) {
        ButtonType.Primary -> componentColors.buttonPrimary
        ButtonType.Secondary -> componentColors.buttonSecondary
        ButtonType.PrimaryDanger -> componentColors.buttonDangerPrimary
        ButtonType.Tertiary,
        ButtonType.TertiaryDanger,
        ButtonType.Ghost,
        ButtonType.GhostDanger -> Color.Transparent
    }

    val containerBorderColor: Color = when (buttonType) {
        ButtonType.Tertiary -> componentColors.buttonTertiary
        ButtonType.TertiaryDanger -> componentColors.buttonDangerSecondary
        else -> Color.Transparent
    }

    val containerBorderDisabledColor: Color = when (buttonType) {
        ButtonType.Tertiary,
        ButtonType.TertiaryDanger -> componentColors.buttonDisabled
        else -> Color.Transparent
    }

    val containerActiveColor: Color = when (buttonType) {
        ButtonType.Primary -> componentColors.buttonPrimaryActive
        ButtonType.Secondary -> componentColors.buttonSecondaryActive
        ButtonType.Tertiary -> componentColors.buttonTertiaryActive
        ButtonType.Ghost -> theme.backgroundActive
        ButtonType.PrimaryDanger,
        ButtonType.TertiaryDanger,
        ButtonType.GhostDanger -> componentColors.buttonDangerActive
    }

    val containerHoverColor: Color = when (buttonType) {
        ButtonType.Primary -> componentColors.buttonPrimaryHover
        ButtonType.Secondary -> componentColors.buttonSecondaryHover
        ButtonType.Tertiary -> componentColors.buttonTertiaryHover
        ButtonType.Ghost -> theme.backgroundHover
        ButtonType.PrimaryDanger,
        ButtonType.TertiaryDanger,
        ButtonType.GhostDanger -> componentColors.buttonDangerHover
    }

    val containerDisabledColor: Color = when (buttonType) {
        ButtonType.Primary,
        ButtonType.Secondary,
        ButtonType.PrimaryDanger,
        ButtonType.TertiaryDanger,
        ButtonType.GhostDanger -> componentColors.buttonDisabled
        ButtonType.Tertiary,
        ButtonType.Ghost -> Color.Transparent
    }

    val labelColor: Color = when (buttonType) {
        ButtonType.Tertiary -> componentColors.buttonTertiary
        ButtonType.Ghost -> theme.linkPrimary
        ButtonType.TertiaryDanger,
        ButtonType.GhostDanger -> componentColors.buttonDangerSecondary
        else -> theme.textOnColor
    }

    val labelActiveColor: Color = when (buttonType) {
        ButtonType.Tertiary -> theme.textInverse
        ButtonType.Ghost -> theme.linkPrimary
        ButtonType.TertiaryDanger,
        ButtonType.GhostDanger -> theme.textOnColor
        else -> theme.textOnColor
    }

    val labelHoverColor: Color = when (buttonType) {
        ButtonType.Tertiary,
        ButtonType.TertiaryDanger,
        ButtonType.GhostDanger -> theme.textOnColor
        ButtonType.Ghost -> theme.linkPrimaryHover
        else -> theme.textOnColor
    }

    val labelDisabledColor: Color = when (buttonType) {
        ButtonType.Tertiary,
        ButtonType.Ghost,
        ButtonType.TertiaryDanger,
        ButtonType.GhostDanger -> theme.textDisabled
        else -> theme.textOnColorDisabled
    }

    val iconColor: Color = when (buttonType) {
        ButtonType.Tertiary -> componentColors.buttonTertiary
        ButtonType.Ghost -> if (isIconButton) theme.iconPrimary else theme.linkPrimary
        ButtonType.PrimaryDanger -> theme.iconOnColor
        ButtonType.TertiaryDanger,
        ButtonType.GhostDanger -> componentColors.buttonDangerSecondary
        else -> theme.iconOnColor
    }

    val iconActiveColor: Color = if (isIconButton) {
        theme.iconPrimary
    } else {
        when (buttonType) {
            ButtonType.Tertiary -> theme.iconInverse
            ButtonType.Ghost -> if (isIconButton) theme.iconPrimary else theme.linkPrimary
            else -> theme.iconOnColor
        }
    }

    val iconHoverColor: Color = if (isIconButton) {
        theme.iconPrimary
    } else {
        when (buttonType) {
            ButtonType.Tertiary -> theme.iconInverse
            ButtonType.Ghost -> if (isIconButton) theme.iconPrimary else theme.linkPrimaryHover
            else -> theme.iconOnColor
        }
    }

    val iconDisabledColor: Color = when (buttonType) {
        ButtonType.Primary,
        ButtonType.Secondary,
        ButtonType.PrimaryDanger -> theme.iconOnColorDisabled
        else -> theme.iconDisabled
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ButtonColors) return false

        if (theme != other.theme) return false
        if (buttonType != other.buttonType) return false
        if (isIconButton != other.isIconButton) return false

        return true
    }

    override fun hashCode(): Int {
        var result = theme.hashCode()
        result = 31 * result + buttonType.hashCode()
        result = 31 * result + isIconButton.hashCode()
        return result
    }

    companion object {

        @Composable
        fun colors(
            buttonType: ButtonType,
            isIconButton: Boolean,
        ): ButtonColors = ButtonColors(Carbon.theme, buttonType, isIconButton)
    }
}
