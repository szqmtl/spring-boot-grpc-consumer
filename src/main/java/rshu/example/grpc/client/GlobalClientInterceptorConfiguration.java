package rshu.example.grpc.client;

import net.devh.boot.grpc.client.interceptor.GlobalClientInterceptorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order()
@Configuration
public class GlobalClientInterceptorConfiguration {
    @Bean
    public GlobalClientInterceptorConfigurer globalClientInterceptorConfigurerAdapter(){
        return registry -> registry.addClientInterceptors(new LogGrpcInterceptor());
    }

}
