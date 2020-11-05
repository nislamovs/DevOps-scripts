import net.logstash.logback.appender.LogstashTcpSocketAppender
import net.logstash.logback.encoder.LogstashEncoder
//import org.springframework.core.io.ClassPathResource
//import org.yaml.snakeyaml.Yaml

String appName = "elkexample"
String profile = "dafault"

//def bootstrap = new ClassPathResource("bootstrap.yml")
//def application = new ClassPathResource("application.yml")
//def resource = bootstrap.exists() ? bootstrap :
//        application.exists() ? application : null
//if (resource) {
//    def yaml = new Yaml()
//    appName = yaml.load(resource.inputStream).spring.application.name
//}

def LOGSTASH_SERVER = "logstash:5000"

println "=" * 80
println """    APP NAME          : $appName
    APP PROFILE       : $profile
    LOGSTASH SERVER   : $LOGSTASH_SERVER
    LOGGING FILE      : logback.groovy"""
println "=" * 80

def appenders = []
//if (LOGSTASH_SERVER) {
appender("TCP", LogstashTcpSocketAppender.class) {
    destination = LOGSTASH_SERVER
    encoder(LogstashEncoder) {
        customFields = """{"project_name" : "$appName", "profile" : "$profile"}"""
    }
}
appenders += "TCP"
//}

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = '%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger{36}.%M - %msg%n'
    }
}
appenders += "STDOUT"
appenders += "TCP"

root(INFO, appenders)