# SampleAndroidArchAtScale
Sample project that demonstrates Android Architecture at scale in 2021-th

[Medium Article](https://alovmax.medium.com/scalable-android-architecture-2021-92208e95c0ad)

The main idea of the Architecture is the statement that any product feature (or core library)
could have its functionality separated from the UI and shared with the others within the whole
project. This allows us to reuse features’ functionality flexibly, test it in isolation using
demo apps, and write tests easier. Separation of the UI and the logic in different modules also
simplifies usage of Android dynamic features and increases a degree of the project’s modularity,
which is good for build performance and dependency management. The Architecture follows the principles
of Clean Arch, but the presentation layer is still open to extension or alter: it’s possible to
choose between MVP, MVI or MVVM, though the latter is preferred due to ubiquitous usage of Jetpack.
An explicit separation between API and implementation is good when we need to have multiple implementations.
It is also good for testing and for better clarity. The Architecture is scalable: every feature has the
same structure and usage, and there is no systematic debt that could accumulate over time as the project
grows. And last, but not least, DI is also an important foundation of Architecture.
Thanks to Dagger 2, it’s compile-time safe.
