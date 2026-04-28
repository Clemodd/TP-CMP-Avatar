package fr.clem.tp.common.spec

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGRectMake
import platform.UIKit.UIApplication
import platform.UIKit.UIFont
import platform.UIKit.UILabel
import platform.UIKit.UIView
import platform.UIKit.UIColor
import platform.UIKit.UIWindow
import platform.UIKit.NSTextAlignmentCenter
import platform.UIKit.UISelectionFeedbackGenerator
import platform.darwin.DISPATCH_TIME_NOW
import platform.darwin.dispatch_after
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_time

@OptIn(ExperimentalForeignApi::class)
actual class HapticFeedback {

    actual fun vibrateLight() {
        val generator = UISelectionFeedbackGenerator()
        generator.prepare()
        generator.selectionChanged()
        showToast("📳 Haptic: vibrateLight")
    }

    private fun showToast(message: String) {
        val window = UIApplication.sharedApplication.windows
            .filterIsInstance<UIWindow>()
            .firstOrNull { it.isKeyWindow() } ?: return

        val label = UILabel()
        label.text = message
        label.textColor = UIColor.whiteColor
        label.backgroundColor = UIColor.blackColor.colorWithAlphaComponent(0.75)
        label.textAlignment = NSTextAlignmentCenter
        label.layer.cornerRadius = 14.0
        label.layer.masksToBounds = true
        label.font = UIFont.systemFontOfSize(14.0)
        label.alpha = 0.0

        val bounds = window.bounds
        val width = 220.0
        val height = 44.0
        val x = bounds.useContents { (size.width - width) / 2.0 }
        val y = bounds.useContents { size.height - height - 100.0 }
        label.setFrame(CGRectMake(x, y, width, height))

        window.addSubview(label)
        UIView.animateWithDuration(0.3) { label.alpha = 1.0 }

        // Disparaît après 1.5 s
        dispatch_after(
            dispatch_time(DISPATCH_TIME_NOW, 1_500_000_000L),
            dispatch_get_main_queue()
        ) {
            UIView.animateWithDuration(0.4, animations = { label.alpha = 0.0 }) { _ ->
                label.removeFromSuperview()
            }
        }
    }
}
