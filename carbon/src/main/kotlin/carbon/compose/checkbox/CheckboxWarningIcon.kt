package carbon.compose.checkbox

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val checkboxWarningIcon: ImageVector
    get() = ImageVector.Builder(
        name = "CheckboxWarningIcon",
        defaultWidth = checkboxWarningIconWidth,
        defaultHeight = checkboxWarningIconHeight,
        viewportWidth = checkboxWarningIconWidth.value,
        viewportHeight = checkboxWarningIconHeight.value
    ).apply {
        path(fill = SolidColor(Color(0xFF000000))) {
            moveTo(30.9f, 32f)
            horizontalLineTo(1.1f)
            curveTo(0.5f, 32f, 0f, 31.5f, 0f, 30.9f)
            curveTo(0f, 30.7f, 0f, 30.5f, 0.1f, 30.5f)
            lineTo(15f, 1.8f)
            curveTo(15.3f, 1.2f, 15.9f, 1f, 16.4f, 1.3f)
            curveTo(16.6f, 1.4f, 16.8f, 1.6f, 16.9f, 1.8f)
            lineTo(31.8f, 30.4f)
            curveTo(32.1f, 31f, 31.9f, 31.7f, 31.3f, 32f)
            curveTo(31.2f, 32f, 31.1f, 32f, 31f, 32f)
            close()
        }
    }.build()

internal val checkboxWarningInnerIcon: ImageVector
    get() = ImageVector.Builder(
        name = "CheckboxWarningInnerIcon",
        defaultWidth = checkboxWarningIconWidth,
        defaultHeight = checkboxWarningIconHeight,
        viewportWidth = checkboxWarningIconWidth.value,
        viewportHeight = checkboxWarningIconHeight.value
    ).apply {
        path(fill = SolidColor(Color(0xFF000000))) {
            moveTo(16f, 28f)
            curveTo(15.1f, 28f, 14.3f, 27.2f, 14.3f, 26.3f)
            curveTo(14.3f, 25.4f, 15.1f, 24.6f, 16f, 24.6f)
            curveTo(16.9f, 24.6f, 17.7f, 25.4f, 17.7f, 26.3f)
            curveTo(17.7f, 27.2f, 16.9f, 28f, 16f, 28f)
            close()

            moveTo(14.7f, 11.4f)
            horizontalLineTo(17.2f)
            verticalLineTo(21.7f)
            horizontalLineTo(14.7f)
            verticalLineTo(11.4f)
            close()
        }
    }.build()

internal val checkboxWarningIconWidth = 32f.dp
internal val checkboxWarningIconHeight = 32f.dp