package compose.ui.bottomnav.ui

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object BottomNavDefaults {
    val animationSpecFloat = tween<Float>(durationMillis = 260, easing = FastOutSlowInEasing)
    val animationSpecDp = tween<Dp>(durationMillis = 260, easing = FastOutSlowInEasing)
    val animationSpecColor: AnimationSpec<Color> = tween(
        durationMillis = 260,
        easing = FastOutSlowInEasing
    )

    val height = 64.dp
    val badgeBackgroundColor: Color
        @Composable get() = MaterialTheme.colorScheme.error
    val badgeTextColor: Color
        @Composable get() = MaterialTheme.colorScheme.onError
}