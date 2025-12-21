package fr.clem.tp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform