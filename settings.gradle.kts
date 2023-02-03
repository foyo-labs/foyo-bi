rootProject.name = "foyo-bi"

include(":foyo-bi-driver")
include(":foyo-bi-app")
include(":foyo-bi-sdk")

//驱动包, InMemory/Spark/Ignite/Flink
project(":foyo-bi-driver").projectDir = file("modules/driver")
project(":foyo-bi-sdk").projectDir = file("modules/sdk")

//主程序包
project(":foyo-bi-app").projectDir = file("modules/application")

