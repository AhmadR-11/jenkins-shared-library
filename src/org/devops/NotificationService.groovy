package org.devops

class NotificationService implements Serializable {
    // The 'script' object holds the Jenkins pipeline execution context
    def script

    // Constructor receives the Jenkins script object
    NotificationService(script) {
        this.script = script
    }

    // Method to send a Slack message
    void sendSlack(String message) {
        script.echo("Attempting to send Slack Notification...")
        
        // This safely uses the curl method we used earlier, assuming SLACK_WEBHOOK_URL is in the environment
        script.sh """
            if [ -n "\${SLACK_WEBHOOK_URL}" ]; then
                curl -X POST -H 'Content-type: application/json' --data "{\\"text\\":\\"${message}\\"}" \${SLACK_WEBHOOK_URL}
            else
                echo "[Slack Notification] ${message}"
            fi
        """
    }

    // Method to send an Email
    void sendEmail(String to, String subject, String body) {
        script.echo("Preparing email for ${to}...")
        // Uses the standard Jenkins mailer plugin command
        script.mail(to: to, subject: subject, body: body)
    }
}
