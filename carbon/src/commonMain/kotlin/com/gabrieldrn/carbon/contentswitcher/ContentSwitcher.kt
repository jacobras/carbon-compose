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

package com.gabrieldrn.carbon.contentswitcher

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gabrieldrn.carbon.Carbon
import com.gabrieldrn.carbon.button.ButtonFocusIndication
import com.gabrieldrn.carbon.button.ButtonType
import com.gabrieldrn.carbon.foundation.motion.Motion
import com.gabrieldrn.carbon.foundation.spacing.SpacingScale

@Composable
public fun ContentSwitcher(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    require(options.size >= 2) { "ContentSwitcher requires at least two options" }

    val colors = ContentSwitcherColors.colors()

    val selectedOptionIndex by remember(options, selectedOption) {
        mutableStateOf(options.indexOf(selectedOption))
    }

    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Carbon.theme.borderInverse,
                shape = RoundedCornerShape(4.dp)
            )
            .clip(shape = RoundedCornerShape(4.dp))
            .height(height = SpacingScale.spacing08)
            .width(IntrinsicSize.Min) // By default, use only the minimum width needed.
    ) {
        options.forEachIndexed { index, option ->
            key(index, option) {
                val interactionSource = remember { MutableInteractionSource() }

                val isSelected by remember(selectedOptionIndex) {
                    mutableStateOf(index == selectedOptionIndex)
                }

                val displayDivider by remember(selectedOptionIndex, isSelected) {
                    mutableStateOf(
                        !isSelected && index - 1 != selectedOptionIndex
                    )
                }

                ContentSwitcherButton(
                    isSelected = isSelected,
                    displayDivider = displayDivider,
                    text = option,
                    colors = colors,
                    interactionSource = interactionSource,
                    onClick = { onOptionSelected(option) },
                    modifier = Modifier
                        // Make all buttons the same width as the widest button.
                        .width(IntrinsicSize.Max)
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

private fun <T : Any> getTransitionSpec() = tween<T>(
    durationMillis = Motion.Duration.fast02,
    easing = Motion.Entrance.expressiveEasing
)

@Composable
private fun ContentSwitcherButton(
    isSelected: Boolean,
    displayDivider: Boolean,
    text: String,
    colors: ContentSwitcherColors,
    interactionSource: MutableInteractionSource,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val transition = updateTransition(isSelected)

    Box(
        modifier = modifier
            .selectable(
                selected = isSelected,
                onClick = onClick,
                interactionSource = interactionSource,
                indication = ButtonFocusIndication(Carbon.theme, ButtonType.Primary)
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        val dividerTransition = updateTransition(displayDivider)

        val dividerColor by dividerTransition.animateColor(
            transitionSpec = { snap() }
        ) {
            if (it) colors.dividerColor else Color.Transparent
        }

        val containerSelectedBackgroundHeight by transition.animateFloat(
            transitionSpec = { getTransitionSpec() }
        ) {
            if (it) 0f else 1f
        }

        val textColor by transition.animateColor(
            transitionSpec = { getTransitionSpec() }
        ) {
            if (it) colors.labelSelectedColor else colors.labelUnselectedColor
        }

        // Divider
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = SpacingScale.spacing04)
                .width(width = 1.dp)
                .background(color = dividerColor)
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .drawBehind {
                    // Unselected color background
                    drawRect(colors.containerUnselectedColor)
                    // Animated selected color background
                    drawLine(
                        color = colors.containerSelectedColor,
                        start = Offset(x = size.width / 2, y = size.height),
                        end = Offset(
                            x = size.width / 2,
                            y = size.height * containerSelectedBackgroundHeight
                        ),
                        strokeWidth = this.size.width
                    )
                }
        ) {
            BasicText(
                text = text,
                style = Carbon.typography.bodyCompact01.merge(
                    color = textColor,
                ),
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart)
                    .padding(horizontal = SpacingScale.spacing05)
            )
        }
    }
}
