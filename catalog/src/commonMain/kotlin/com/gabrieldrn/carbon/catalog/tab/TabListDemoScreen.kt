/*
 * Copyright 2025 Gabriel Derrien
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

package com.gabrieldrn.carbon.catalog.tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gabrieldrn.carbon.Carbon
import com.gabrieldrn.carbon.catalog.common.LayerSelectionDropdown
import com.gabrieldrn.carbon.dropdown.Dropdown
import com.gabrieldrn.carbon.dropdown.base.DropdownOption
import com.gabrieldrn.carbon.dropdown.base.toDropdownOptions
import com.gabrieldrn.carbon.foundation.color.CarbonLayer
import com.gabrieldrn.carbon.foundation.color.Layer
import com.gabrieldrn.carbon.foundation.color.containerBackground
import com.gabrieldrn.carbon.foundation.spacing.SpacingScale
import com.gabrieldrn.carbon.tab.TabItem
import com.gabrieldrn.carbon.tab.TabList
import com.gabrieldrn.carbon.tab.TabVariant

@Composable
internal fun TabListDemoScreen(modifier: Modifier = Modifier) {
    var layer by rememberSaveable { mutableStateOf(Layer.Layer00) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .containerBackground()
            .verticalScroll(state = rememberScrollState())
            .padding(WindowInsets.navigationBars.asPaddingValues())
    ) {
        var variantState by rememberSaveable {
            mutableStateOf(TabVariant.Line)
        }

        CarbonLayer(layer = layer) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .containerBackground()
                    .padding(SpacingScale.spacing05),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                var selectedTab by remember { mutableStateOf(demoTabs[0]) }

                TabList(
                    tabs = demoTabs,
                    selectedTab = selectedTab,
                    onTabSelected = { selectedTab = it },
                    variant = variantState
                )
            }
        }

        CarbonLayer {
            Column(
                modifier = Modifier
                    .padding(SpacingScale.spacing05)
                    .containerBackground()
                    .padding(SpacingScale.spacing05),
                verticalArrangement = Arrangement.spacedBy(SpacingScale.spacing04)
            ) {
                BasicText(
                    text = "Configuration",
                    style = Carbon.typography.heading02.copy(color = Carbon.theme.textPrimary)
                )

                Dropdown(
                    placeholder = "Choose option",
                    label = "TabList variant",
                    options = tabVariants,
                    selectedOption = variantState,
                    onOptionSelected = { variantState = it }
                )

                LayerSelectionDropdown(
                    layers = layersOptions,
                    selectedLayer = layer,
                    onLayerSelected = { layer = it },
                    modifier = Modifier.padding(top = SpacingScale.spacing03)
                )
            }
        }
    }
}

private val demoTabs = listOf(
    TabItem(label = "Dashboard"),
    TabItem(label = "Monitoring"),
    TabItem(label = "Activity"),
    TabItem(label = "Disabled", enabled = false)
)
private val layersOptions =
    Layer.entries.associateWith { DropdownOption(it.toString(), enabled = it != Layer.Layer03) }
private val tabVariants = TabVariant.entries.toDropdownOptions()
