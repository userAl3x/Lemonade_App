# 🍋 Lemonade App

**Desarrollado por:** Alex Jimenez

## 📱 Descripción

Aplicación interactiva de Android desarrollada en Kotlin con Jetpack Compose que simula el proceso completo de hacer limonada: desde recoger los limones del árbol hasta beberla y valorarla.

## ✨ Características

- **Interfaz intuitiva:** Navegación paso a paso con imágenes y textos descriptivos
- **Interacción mediante clics:** Sistema de clicks aleatorios para exprimir limones
- **Sistema de valoración:** Calificación con estrellas (1-5) de la limonada preparada
- **Experiencia personalizada:** Uso del nombre del usuario a lo largo de toda la app
- **Feedback visual:** Toasts informativos en cada etapa del proceso

## 🎮 Funcionamiento

### Paso 1: Bienvenida
- Pantalla de introducción donde el usuario introduce su nombre
- TextField para capturar el nombre
- Botón "Començar" para iniciar la experiencia

### Paso 2: Recoger limón del árbol
- Imagen del limonero
- Texto: "Agafa una llimona [nombre]"
- Click en el árbol para obtener un limón

### Paso 3: Exprimir el limón
- Imagen del limón
- Texto: "Esprem la llimona [nombre]"
- Sistema de clicks aleatorios (1-10 clicks necesarios)
- Contador visual de progreso: "Clics: X / Y"

### Paso 4: Beber y valorar la limonada
- Imagen del vaso con limonada
- Texto: "Beu-te-la [nombre]"
- TextField numérico para introducir valoración (1-5)
- Visualización en tiempo real con iconos de estrellas
- Botón "Valorar" para confirmar

### Paso 5: Finalizar y reiniciar
- Imagen del vaso vacío
- Texto: "Comença de nou [nombre]"
- Muestra la valoración final con estrellas
- Botón "Començar de nou" para repetir el proceso

## 🛠️ Tecnologías utilizadas

- **Lenguaje:** Kotlin
- **Framework UI:** Jetpack Compose
- **Componentes principales:**
  - Material3 (Material Design 3)
  - Compose Foundation
  - Navigation state management con `remember`
  - Random number generation para clicks aleatorios

## 📦 Estructura del proyecto
Lemonade_App/
├── app/
│ ├── src/
│ │ └── main/
│ │ ├── java/com/example/lemonade_app/
│ │ │ └── MainActivity.kt
│ │ ├── res/
│ │ │ └── drawable/
│ │ │ ├── lemon_tree.xml
│ │ │ ├── lemon_squeeze.xml
│ │ │ ├── lemon_drink.xml
│ │ │ └── lemon_restart.xml
│ │ └── AndroidManifest.xml
│ └── build.gradle.kts
└── README.md