## Liquid Glass Compose

<img src="screenshots/button_example.png" width="350"/>

# 🚧 Experimental Release: 0.1.0

**This is an experimental version (0.1.0) of Liquid Glass Compose!**

You can download this version via the [Releases](https://github.com/Mortd3kay/liquid-glass-compose/releases) tab.

---

If the community shows real interest, the plan is to build a full-featured design system with optimized glassmorphism components. 

**If you like the idea — star the repo and follow the updates! ⭐**

---

Glass morphism effects demonstration project in Jetpack Compose with support for Android API 21+.
<img src="screenshots/button.gif" width="350"/>

<img src="screenshots/card.gif" width="350"/>


## 🎯 Features

- ✨ Realistic glass morphism effects
- 📱 Support for Android API 21+ (Android 5.0 and above)
- 🔄 Automatic fallback for older Android versions
- 🎨 Real-time customizable parameters
- 🚀 High performance using AGSL shaders

## 📱 Version Support

### Android 13+ (API 33+)
- Full support with AGSL shaders
- All effects work at hardware level
- Maximum performance

<img src="screenshots/tinted_glass.png" width="350"/>

### Android 5.0 - 12 (API 21-32)
- Fallback implementation using standard Compose modifiers
- Glass effect simulation using gradients and transparency
- No blur support (blur only available with AGSL shaders)

<img src="screenshots/fallback.png" width="350"/>

## 🏗️ Project Structure

```
liquid-glass-compose/
├── app/                    # Demo application
│   └── src/main/java/
│       └── com/mrtdk/liquid_glass/
│           └── MainActivity.kt
└── glass/                  # Glass library
    ├── build.gradle.kts
    ├── README.md          # Library documentation
    └── src/main/java/
        └── com/mrtdk/glass/
            └── GlassBox.kt
```

## 🚀 Usage

### Basic Example

```kotlin
GlassContainer(
    modifier = Modifier.fillMaxSize(),
    content = {
        // Your main content (background of glass)
        Image(...)
    }
) {
    GlassBox(
        modifier = Modifier
            .size(200.dp)
            .align(Alignment.Center),
        blur = 0.5f,
        scale = 0.3f,
        shape = RoundedCornerShape(16.dp)
    ) {
        Text("Glass Effect")
    }
}
```

### Advanced Parameters

- `blur` (0.0-1.0) - Blur intensity
- `scale` (0.0-1.0) - Magnification/lens effect  
- `centerDistortion` (0.0-1.0) - Lens distortion (like fisheye)
- `elevation` - Shadow
- `tint` - Glass color tint
- `darkness` (0.0-1.0) - Edge darkening
- `warpEdges` (0.0-1.0) - Edges distortion

<img src="screenshots/clear_lens.png" width="350"/>

## 🛠️ Build

```bash
# Build library
./gradlew :glass:build

# Build demo app
./gradlew :app:build

# Run application
./gradlew :app:installDebug
```

## 📲 Demo Application

Try the interactive demo app included in this repository! The demo lets you:
- See real-time glass morphism effects on cards and buttons
- Experiment with all parameters: blur, scale, distortion, elevation, tint, darkness, warp edges
- Instantly preview changes and rendering modes (AGSL or fallback)

<img src="screenshots/demo_app.png" width="350"/>
<img src="screenshots/settings.png" width="350"/>

---

## 🔧 Technical Implementation

### Android 13+ (AGSL Shaders)
- Uses `RuntimeShader` with custom AGSL code
- GPU hardware acceleration
- Support for up to 10 glass elements simultaneously in one GlassContainer
- Realistic effects: blur, distortion, shadows, reflections

### Android 5.0-12 (Fallback)
- Gradient backgrounds to simulate glass
- No blur support (blur only works with AGSL shaders)
- Transparency and scaling effects

## 📋 Requirements

- Android API 21+ (Android 5.0)
- Jetpack Compose BOM 2024.09.00+
- Kotlin 2.0.21+
- Gradle 8.10.0+



## 🤝 Contributing

If you want to contribute to the project:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📞 Contact

If you have questions or suggestions, please create an Issue in the repository. 