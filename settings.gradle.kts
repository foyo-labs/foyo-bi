rootProject.name = "foyo-bi"

include(":foyo-bi-core")
include(":foyo-bi-app")


project(":foyo-bi-core").projectDir = file("modules/core")
project(":foyo-bi-app").projectDir = file("modules/application")

enableFeaturePreview("VERSION_CATALOGS")
