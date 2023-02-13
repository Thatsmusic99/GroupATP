rootProject.name = "GroupATP"

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories.maven("https://repo.racci.dev/releases") { mavenContent { releasesOnly() } }

    versionCatalogs.create("libMinix") {
        val build: String by settings
        val kotlinVersion: String by settings
        val conventions = "$kotlinVersion-$build"
        from("dev.racci:catalog:$conventions")
    }
}