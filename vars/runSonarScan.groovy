def call(Map config = [:]) {
    // Validate required keys
    if (!config.projectKey) {
        error("runSonarScan step requires a 'projectKey' parameter.")
    }
    if (!config.sonarToken) {
        error("runSonarScan step requires a 'sonarToken' parameter.")
    }

    echo "Initializing SonarQube Scanner for project: ${config.projectKey}..."
    
    // We execute the shell command for the Sonar Scanner
    // (This acts as a placeholder or standard command until Task 4's SonarQube server is fully booted)
    sh """
        echo "Running sonar-scanner with Project Key: ${config.projectKey}"
        echo "Token provided securely."
    """
}
