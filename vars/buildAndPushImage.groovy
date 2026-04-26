def call(Map config = [:]) {
    // Validate required keys
    if (!config.name) {
        error("buildAndPushImage step requires a 'name' parameter.")
    }
    if (!config.tag) {
        error("buildAndPushImage step requires a 'tag' parameter.")
    }

    echo "Preparing to build and push container: ${config.name}:${config.tag}"
    
    // Call the OOP class we built earlier to do the heavy lifting
    def dockerHelper = new org.devops.DockerHelper(this)
    
    dockerHelper.buildImage(config.name, config.tag)
    dockerHelper.pushImage(config.name, config.tag)
}
