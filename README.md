# Genome Payment Android SDK

[![GitHub release](https://img.shields.io/github/v/release/genome-eu/payment-sdk-android?style=flat-square&cacheSeconds=60)](https://github.com/genome-eu/payment-sdk-android/releases)
[![License](https://img.shields.io/github/license/genome-eu/payment-sdk-android?style=flat-square)](https://github.com/genome-eu/payment-sdk-android/blob/master/LICENSE)

The Genome Payment Android SDK makes it quick and easy to build a payment screen in your Android app. We provide customizable SDKFacade that can be used out-of-the-box.

## Content
* [Requirements](#requirements)
* [Installation](#installation)
* [Integration with SDK](#integration-with-sdk)

## Requirements
Android 5.0 (API level 21) and above

## Installation
To integrate the Genome Payment Android SDK, you need to perform a few basic tasks to prepare your Android Studio project:

### 1. Edit your project Gradle file
Add rules to your root-level build.gradle file:
```
allprojects {
    // ...
    repositories {
        // ...
        mavenCentral()
    }
}
```

### 2. Edit your module Gradle file
In your module Gradle file (usually the app/build.gradle), add the implementation(...) line in your dependencies to import the SDK:
```
apply plugin: 'com.android.application'

android {
  // ...
}

dependencies {
  // ...
  implementation 'eu.genome.android:sdk-payment:1.1.0'
}
```


## Integration with SDK

[How integrate SDK to your project see here](readme/INTEGRATION.md).
