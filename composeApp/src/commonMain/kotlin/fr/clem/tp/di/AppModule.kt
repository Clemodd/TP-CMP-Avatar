package fr.clem.tp.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.mp.KoinPlatformTools

fun initKoin(config: KoinAppDeclaration? = null) {
    if (KoinPlatformTools.defaultContext().getOrNull() != null) return

    val modulesList = mutableListOf(
        globalModule,
        navigationModule,
        platformModule,
    )

    startKoin {
        config?.invoke(this)
        modules(modulesList)
    }
}