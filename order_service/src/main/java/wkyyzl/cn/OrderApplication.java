package wkyyzl.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 使用spring提供的RestTemplate发送http请求到商品服务
     *      1.创建RestTemplate对象交给容器管理
     *      2.在使用的时候,调用其方法完成操作 (getXX,postxxx)
     * * @LoadBalanced : 是ribbon提供的负载均衡的注解
     */
    //@LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
