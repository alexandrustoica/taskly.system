package taskly.system.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import taskly.system.notification.NotificationAspect

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = ["taskly.system.notification"])
class AspectConfiguration {

    @Bean
    fun testAspect(): NotificationAspect {
        return NotificationAspect()
    }
}