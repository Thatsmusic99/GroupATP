
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("java")
    alias(libMinix.plugins.shadow)
    alias(libMinix.plugins.slimjar)
    alias(libMinix.plugins.minecraft.pluginYML)
}

group = "io.github.thatsmusic99"
version = project.version.toString()

repositories {
    mavenCentral()
    maven("https://ci.pluginwiki.us/plugin/repository/everything/")
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://maven.enginehub.org/repo/")
    maven("https://repo.racci.dev/releases") { mavenContent { releasesOnly() }}
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {

    implementation(libMinix.slimjar)

    slim(libMinix.adventure.api)
    slim(libMinix.adventure.minimessage)
    slim(libMinix.adventure.platform.bukkit)
    slim(libMinix.cloud.minecraft.bukkit)

    compileOnly("io.github.niestrat99:AdvancedTeleport-Bukkit:v5.6.5")
    compileOnly("com.sk89q.worldedit:worldedit-bukkit:7.2.9")
    compileOnly("org.spigotmc:spigot-api:1.19.3-R0.1-SNAPSHOT")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

bukkit {
    main = "io.github.thatsmusic99.groupatp.GroupATP"
    apiVersion = "1.19"
    version = project.version.toString().substring(if (project.version.toString().startsWith("v")) 1 else 0)
    author = "Thatsmusic99"
    depend = listOf("WorldEdit", "AdvancedTeleport")
}