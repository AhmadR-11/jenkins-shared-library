def call(Map config = [:]) {
    // Validate required keys
    if (!config.projectKey) {
        error("runSonarScan step requires a 'projectKey' parameter.")
    }

    echo "Initializing SonarQube Scanner for project: ${config.projectKey}..."
    
    // Automatically uses the SonarQube server and token we registered in Jenkins System settings!
    withSonarQubeEnv('sonarqube-server') {
        sh "npx sonarqube-scanner -Dsonar.projectKey=${config.projectKey} -Dsonar.sources=. -Dsonar.javascript.lcov.reportPaths=coverage/lcov.info"
    }
}
