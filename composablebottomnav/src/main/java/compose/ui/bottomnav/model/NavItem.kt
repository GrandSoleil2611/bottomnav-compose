package compose.ui.bottomnav.model

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Immutable representation of a bottom nav item.
 * - id: unique string identifier
 * - label: visible label
 * - icon: ImageVector used for icon
 * - contentDescription: optional accessibility text; falls back to label
 * - badgeCount: optional non-negative number to show a numeric badge; 0 or null hides badge
 */
data class NavItem(
    val id: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String? = null,
    val badgeCount: Int? = null
)