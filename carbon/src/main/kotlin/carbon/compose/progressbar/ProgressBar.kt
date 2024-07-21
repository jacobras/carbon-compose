package carbon.compose.progressbar

import androidx.annotation.FloatRange
import androidx.compose.foundation.progressSemantics
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

/**
 * # Progress Bar | Determinate
 *
 * A progress bar provides feedback about the duration and progression of a process, such as a
 * download, file transfer, or installation, to indicate how long a user will be waiting.
 *
 * Determinate progress bars are used when the loading progress can be tracked and translated into a
 * bar indicator which fills the track from 0% to 100% and never decreases in value or resets.
 *
 * (From [Progress bar documentation](https://carbondesignsystem.com/components/progress-bar/usage))
 *
 * @param value The progress value, between 0 and 1.
 * @param modifier The modifier to apply to this composable.
 * @param labelText The text label on top of the progress bar.
 * @param helperText The helper text below the progress bar.
 * @param indented Whether to indent the label and helper texts.
 * @param inlined When true, sets the label text inlined with the progress bar. In this case the
 * helper text is not displayed.
 * @param state The state of the progress bar.
 * @param size The size type of the progress bar.
 */
@Composable
public fun ProgressBar(
    @FloatRange(from = 0.0, to = 1.0) value: Float,
    modifier: Modifier = Modifier,
    labelText: String? = null,
    helperText: String? = null,
    indented: Boolean = false,
    inlined: Boolean = false,
    state: ProgressBarState = ProgressBarState.Active,
    size: ProgressBarSize = ProgressBarSize.Big,
) {
    ProgressBarRootLayout(
        labelText = labelText,
        helperText = helperText,
        inlined = inlined,
        indented = indented,
        modifier = modifier.progressSemantics(value = value, valueRange = 0f..1f),
        state = state,
        trackContent = {
            ProgressBarTrack(
                size = size,
                value = value,
                state = state,
                modifier = Modifier.testTag(ProgressBarTestTags.TRACK)
            )
        }
    )
}

/**
 * # Progress Bar | Indeterminate
 *
 * A progress bar provides feedback about the duration and progression of a process, such as a
 * download, file transfer, or installation, to indicate how long a user will be waiting.
 *
 * Indeterminate progress bars are used when the loading progress is unknown or the amount of wait
 * time can’t be calculated.
 *
 * (From [Progress bar documentation](https://carbondesignsystem.com/components/progress-bar/usage))
 *
 * @param modifier The modifier to apply to this composable.
 * @param labelText The text label on top of the progress bar.
 * @param helperText The helper text below the progress bar.
 * @param indented Whether to indent the label and helper texts.
 * @param inlined When true, sets the label text inlined with the progress bar. In this case the
 * helper text is not displayed.
 * @param size The size type of the progress bar.
 */
@Composable
public fun IndeterminateProgressBar(
    modifier: Modifier = Modifier,
    labelText: String? = null,
    helperText: String? = null,
    indented: Boolean = false,
    inlined: Boolean = false,
    state: ProgressBarState = ProgressBarState.Active,
    size: ProgressBarSize = ProgressBarSize.Big,
) {
    ProgressBarRootLayout(
        labelText = labelText,
        helperText = helperText,
        inlined = inlined,
        indented = indented,
        modifier = modifier.progressSemantics(),
        state = state,
        trackContent = {
            IndeterminateProgressBarTrack(
                size = size,
                modifier = Modifier.testTag(ProgressBarTestTags.TRACK)
            )
        }
    )
}