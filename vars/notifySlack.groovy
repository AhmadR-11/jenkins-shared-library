def call(Map config = [:]) {
    // Validate required keys
    if (!config.message) {
        error("notifySlack step requires a 'message' parameter.")
    }
    
    // Use optional defaults if not provided
    def channel = config.channel ?: '#general'
    
    echo "Starting Slack notification process for channel ${channel}..."
    
    // Here is the magic: We can actually use the OOP class we built in the previous step!
    def service = new org.devops.NotificationService(this)
    service.sendSlack(config.message)
}
