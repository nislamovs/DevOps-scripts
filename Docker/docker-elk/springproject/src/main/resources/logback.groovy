import net.logstash.logback.appender.LogstashTcpSocketAppender
import net.logstash.logback.encoder.LogstashEncoder

String appName = "elkexample"
String profile = "dafault"
def LOGSTASH_SERVER = "logstash:5000"

println "=" * 80
println """    APP NAME          : $appName
    APP PROFILE       : $profile
    LOGSTASH SERVER   : $LOGSTASH_SERVER
    LOGGING FILE      : logback.groovy"""
println "=" * 80

def appenders = []
appender("TCP", LogstashTcpSocketAppender.class) {
    destination = LOGSTASH_SERVER
    encoder(LogstashEncoder) {
        customFields = """{"project_name" : "$appName", "profile" : "$profile"}"""
    }
}
appenders += "TCP"

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = '%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger{36}.%M - %msg%n'
    }
}
appenders += "STDOUT"
appenders += "TCP"

root(INFO, appenders)