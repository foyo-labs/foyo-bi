rootProject.name = "foyo-bi"

include(":foyo-bi-ignite")
include(":foyo-bi-app")

//ignite驱动包，用于独立计算，尽量不依赖第三方包，编译时可使用ignite中自带的库
project(":foyo-bi-ignite").projectDir = file("modules/ignite-driver")

//主程序包
project(":foyo-bi-app").projectDir = file("modules/application")

