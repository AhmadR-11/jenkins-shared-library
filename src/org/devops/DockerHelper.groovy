package org.devops

class DockerHelper implements Serializable {
    // The 'script' object holds the Jenkins pipeline execution context
    def script

    // Constructor receives the Jenkins script object
    DockerHelper(script) {
        this.script = script
    }

    // Method to build a Docker image
    void buildImage(String name, String tag) {
        script.echo("Building Docker image: ${name}:${tag}...")
        script.sh "docker build -t ${name}:${tag} ."
    }

    // Method to push a Docker image to a registry
    void pushImage(String name, String tag) {
        script.echo("Pushing Docker image: ${name}:${tag}...")
        // Assuming the pipeline has already authenticated with Docker Hub / ECR
        script.sh "docker push ${name}:${tag}"
    }
}
