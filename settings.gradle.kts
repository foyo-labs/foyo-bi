rootProject.name = "foyo-bi"

include(":foyo-bi-ignite")
include(":foyo-bi-app")

project(":foyo-bi-ignite").projectDir = file("modules/ignite-driver")
project(":foyo-bi-app").projectDir = file("modules/application")
