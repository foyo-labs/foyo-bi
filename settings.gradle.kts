rootProject.name = "foyo-bi"

include(":foyo-bi-sdk")
include(":foyo-bi-core")
include(":foyo-bi-app")


project(":foyo-bi-sdk").projectDir = file("modules/sdk")
project(":foyo-bi-core").projectDir = file("modules/core")
project(":foyo-bi-app").projectDir = file("modules/application")

enableFeaturePreview("VERSION_CATALOGS")
