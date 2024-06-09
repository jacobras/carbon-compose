package carbon.compose.dropdown

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import carbon.compose.Carbon
import carbon.compose.dropdown.base.DropdownColors
import carbon.compose.dropdown.base.DropdownField
import carbon.compose.dropdown.base.DropdownInteractiveState
import carbon.compose.dropdown.base.DropdownPlaceholderText
import carbon.compose.dropdown.base.DropdownSize
import carbon.compose.dropdown.base.DropdownStateIcon
import carbon.compose.foundation.color.CarbonLayer
import carbon.compose.foundation.color.Layer
import carbon.compose.foundation.spacing.SpacingScale

private class DropdownLayerPreviewParameterProvider : PreviewParameterProvider<Layer> {
    override val values: Sequence<Layer> = Layer
        .values()
        .filterNot { it == Layer.Layer03 }
        .asSequence()
}

@Preview(showBackground = true)
@Composable
private fun DropdownFieldPreview(
    @PreviewParameter(DropdownLayerPreviewParameterProvider::class)
    layer: Layer
) {
    var state by remember {
        mutableStateOf<DropdownInteractiveState>(DropdownInteractiveState.Enabled)
    }
    val expandedStates = remember { MutableTransitionState(false) }
    val transition = updateTransition(expandedStates, "Dropdown")

    CarbonLayer(layer = layer) {
        val colors = DropdownColors.colors()
        DropdownField(
            state = state,
            dropdownSize = DropdownSize.Large,
            transition = transition,
            expandedStates = expandedStates,
            colors = colors,
            onExpandedChange = { expandedStates.targetState = it },
            fieldContent = {
                DropdownPlaceholderText(
                    placeholderText = "Placeholder",
                    state = state,
                    colors = colors
                )

                DropdownStateIcon(state = state)
            },
            modifier = Modifier
                .background(color = Carbon.theme.containerColor(Carbon.layer))
                .padding(SpacingScale.spacing03)
        )
    }
}
