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

package com.gabrieldrn.carbon.catalog.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
actual fun getGridBreakpoint(): GridBreakpoint =
    when (LocalConfiguration.current.screenWidthDp.dp) {
        in 0.dp..<GridBreakpoint.Small.value -> GridBreakpoint.Small
        in GridBreakpoint.Small.value..<GridBreakpoint.Medium.value -> GridBreakpoint.Medium
        in GridBreakpoint.Medium.value..<GridBreakpoint.Large.value -> GridBreakpoint.Large
        in GridBreakpoint.Large.value..<GridBreakpoint.XLarge.value -> GridBreakpoint.XLarge
        else -> GridBreakpoint.Max
    }
