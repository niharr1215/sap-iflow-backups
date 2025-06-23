import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonOutput

def Message processData(Message message) {
    def filename = "PrepareGitHubPayload.groovy"
    def githubPayload = [
        message: "Hardcoded upload via iFlow",
        content: "SGVsbG8gV29ybGQ=", // base64 for "Hello World"
        branch: "main" // Change to "master" if needed
    ]

    if (!message.getProperty("filename")) {
        message.setProperty("filename", filename)
    }
    message.setProperty("githubPayload", JsonOutput.toJson(githubPayload))

    return message
}


