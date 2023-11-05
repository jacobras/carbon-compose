package dev.gabrieldrn.carbon.uishell

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.gabrieldrn.carbon.CarbonDesignSystem
import dev.gabrieldrn.carbon.foundation.color.LocalCarbonTheme
import dev.gabrieldrn.carbon.foundation.color.Theme
import dev.gabrieldrn.carbon.foundation.spacing.SpacingScale
import dev.gabrieldrn.carbon.foundation.text.CarbonTypography

@Composable
public fun UiShellHeader(
    headerName: String,
    modifier: Modifier = Modifier,
    @DrawableRes menuIconRes: Int = 0,
    onMenuIconPressed: () -> Unit = {},
    windowInsets: WindowInsets = WindowInsets.statusBars.only(WindowInsetsSides.Top),
    inlineTheme: Theme = CarbonDesignSystem.inlineTheme,
) {
    CarbonDesignSystem(inlineTheme) {
        Box(
            modifier = modifier
                .background(LocalCarbonTheme.current.background)
                .windowInsetsPadding(windowInsets)
                .height(48.dp),
            contentAlignment = Alignment.BottomStart,
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (menuIconRes != 0) {
                    MenuButton(
                        onMenuIconPressed = onMenuIconPressed,
                        menuIconRes = menuIconRes
                    )
                    Spacer(modifier = Modifier.width(SpacingScale.spacing03))
                } else {
                    Spacer(modifier = Modifier.width(SpacingScale.spacing05))
                }

                BasicText(
                    text = headerName,
                    style = CarbonTypography.headingCompact02.copy(
                        color = LocalCarbonTheme.current.textPrimary
                    ),
                    modifier = Modifier
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(LocalCarbonTheme.current.borderSubtle00)
            )
        }
    }
}

@Composable
private fun MenuButton(
    onMenuIconPressed: () -> Unit,
    menuIconRes: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clickable(onClick = onMenuIconPressed),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = menuIconRes),
            contentDescription = "Back",
            colorFilter = ColorFilter.tint(LocalCarbonTheme.current.textPrimary),
            modifier = Modifier
                .size(24.dp)
        )
    }
}

@Preview
@Composable
private fun UiShellHeaderPreview() {
    CarbonDesignSystem {
        UiShellHeader(
            headerName = "Carbon Design System",
        )
    }
}
