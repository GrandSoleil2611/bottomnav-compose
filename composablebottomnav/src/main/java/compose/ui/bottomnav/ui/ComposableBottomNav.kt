package compose.ui.bottomnav.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import compose.ui.bottomnav.model.NavItem

@Composable
fun ComposableBottomNav(
    items: List<NavItem>,
    selectedId: String,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        tonalElevation = 4.dp,
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
            .height(BottomNavDefaults.height)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val itemWeight = 1f / items.size
            items.forEach { item ->
                BottomNavItemView(
                    item = item,
                    selected = item.id == selectedId,
                    onClick = { onItemSelected(item.id) },
                    modifier = Modifier
                        .weight(itemWeight)
                )
            }
        }
    }
}

@Composable
private fun BottomNavItemView(
    item: NavItem,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val activeColor = MaterialTheme.colorScheme.primary
    val inactiveColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.60f)
    val iconTint = animateColorAsState(
        if (selected) activeColor else inactiveColor,
        animationSpec = BottomNavDefaults.animationSpecColor
    )
    animateDpAsState(
        if (selected) 1.dp else 0.dp,
        animationSpec = BottomNavDefaults.animationSpecDp
    )

    Column(
        modifier = modifier
            .clickable(onClick = onClick)
            .semantics { contentDescription = item.contentDescription ?: item.label }
            .padding(vertical = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (item.badgeCount != null && item.badgeCount > 0) {
            BadgedBox(
                badge = {
                    Badge(
                        containerColor = BottomNavDefaults.badgeBackgroundColor,
                        contentColor = BottomNavDefaults.badgeTextColor
                    ) {
                        val badgeText =
                            if (item.badgeCount > 99) "99+" else item.badgeCount.toString()
                        Text(badgeText, style = MaterialTheme.typography.labelSmall)
                    }
                }
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = iconTint.value,
                    modifier = Modifier.size(24.dp)
                )
            }
        } else {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = iconTint.value,
                modifier = Modifier.size(24.dp)
            )
        }

        Text(
            text = item.label,
            color = iconTint.value,
            style = MaterialTheme.typography.labelSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(top = 2.dp)
                .alpha(if (selected) 1f else 0.9f)
        )
    }
}