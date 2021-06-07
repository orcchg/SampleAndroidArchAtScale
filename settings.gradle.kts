dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "SampleAndroidArchAtScale"

include(":androidUtil")
include(":app")
include(":base")
include(":core:context:api")
include(":core:context:impl")
include(":core:di")
include(":core:model")
include(":core:network:api")
include(":core:network:impl")
include(":core:schedulers:api")
include(":core:schedulers:impl")
include(":core:ui_core_lib")
include(":design")
include(":feature:main:demo")
include(":feature:main:ui")
include(":feature:search:api")
include(":feature:search:demo")
include(":feature:search:impl")
include(":feature:search:ui")
include(":feature:stock_details:api")
include(":feature:stock_details:data:api")
include(":feature:stock_details:data:fake")
include(":feature:stock_details:data:real")
include(":feature:stock_details:data:wiring")
include(":feature:stock_details:demo")
include(":feature:stock_details:fake")
include(":feature:stock_details:impl")
include(":feature:stock_details:stock_details_main")
include(":feature:stock_details:ui")
include(":feature:stock_list:api")
include(":feature:stock_list:data:api")
include(":feature:stock_list:data:fake")
include(":feature:stock_list:data:real")
include(":feature:stock_list:data:wiring")
include(":feature:stock_list:demo")
include(":feature:stock_list:fake")
include(":feature:stock_list:impl")
include(":feature:stock_list:ui")
include(":feature:stock_list:ui_fake")
include(":navigation")
include(":util")