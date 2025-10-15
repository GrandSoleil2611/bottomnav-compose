# bottomnav-compose

A lightweight Jetpack Compose Bottom Navigation library that deliberately avoids internal navigation
or NavController dependency. The host app controls navigation using selectedId and onItemSelected.

### Features

* Simple API: ComposableBottomNav(items, selectedId, onItemSelected, modifier)
* NavItem model with id, label, icon, optional badgeCount and accessibility contentDescription
* Host-driven navigation: the composable only reports selection
* Badge support, theming compatibility, and basic animations
* No backstack or NavController manipulation

### Quick start

1. Add module dependency to your Gradle settings or include via Maven/JitPack as described below.
    <pre>dependencies {
        implementation ("com.github.GrandSoleil2611:bottomnav-compose:v1.0.0")
    }</pre>
2. Use the API:

<pre>var selectedId by remember { mutableStateOf("home") }

val items = listOf(
  NavItem("home","Home", Icons.Default.Home),
  NavItem("search","Search", Icons.Default.Search, badgeCount = 3),
  NavItem("profile","Profile", Icons.Default.Person)
)

ComposableBottomNav(
  items = items,
  selectedId = selectedId,
  onItemSelected = { id ->
    selectedId = id
    when (id) {
      "home" -> navigateHome()
      "profile" -> navigateProfile()
      "search" -> openSearch()
    }
  }
)</pre>

### Accessibility

* contentDescription is provided via NavItem.contentDescription or label.

### Customization

* Theme colors come from MaterialTheme; override via CompositionLocal or MaterialTheme.

### Sample

* The sample module demonstrates state hoisting and host navigation with when.

### License

* Choose a license for your repo.

