package wkyyzl.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;
import wkyyzl.cn.entity.Product;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 注入DiscoveryClient :
     *  springcloud提供的获取原数组的工具类
     *      调用方法获取服务的元数据信息
     *
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 基于ribbon的形式调用远程微服务
     *  1.使用@LoadBalanced声明RestTemplate
     *  2.使用服务名称替换ip地址
     */
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        Product product = null;
        //服务名称不能用下划线"_",要用"-"
        product = restTemplate.getForObject("http://service-product/product/1", Product.class);
        return product;
    }

    /**
     * 参数:商品id
     *  通过订单系统,调用商品服务根据id查询商品信息
     *      1.需要配置商品对象
     *      2.需要调用商品服务
     *  使用java中的urlconnection,httpclient,okhttp
     */
	/*@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		//调用discoveryClient方法
		//已调用服务名称获取所有的元数据
		//使用ip直接调用时，初始化RestTemplate不能加@LoadBalanced注解，去掉即可
		List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
		//获取唯一的一个元数据
		ServiceInstance instance = instances.get(0);
		//根据元数据中的主机地址和端口号拼接请求微服务的URL
		Product product = null;
		//如何调用商品服务?
		product = restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/1",Product.class);
		return product;
	}*/


}
