# GitHub-Profile-Search-App
This is a Jetpack Compose-based Android application that allows users to search for GitHub profiles and display their repositories. The app integrates the GitHub API, fetches repository data, caches responses using Room, and presents them in a lazy list (Jetpack Compose equivalent of RecyclerView). Users can click on a repository to view its details in a WebView.

Features
✅ Jetpack Compose UI – Fully built with modern declarative UI.
✅ Search GitHub Profiles – Fetch repositories for a given user.
✅ Network Requests with Retrofit/OkHttp – Efficient API calls with error handling.
✅ Data Caching with Room/Realm – Stores responses locally to reduce network load.
✅ LazyColumn for Listing Repositories – Displays repository name, user, and ID.
✅ WebView for Repo URLs – Opens repository details within the app.
✅ Local Search Functionality – Allows filtering by ID or name.
✅ Material 3 UI – Follows Google’s Material Design 3 guidelines.
✅ Handles Network Failures Gracefully – Displays messages for errors or offline mode.
