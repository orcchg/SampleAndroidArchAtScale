plugins {
    id("kotlin")
}

dependencies {
    api(project(":core:di"))
    api(project(":feature:stock_details:api"))
}
