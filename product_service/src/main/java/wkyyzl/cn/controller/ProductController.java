package wkyyzl.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import wkyyzl.cn.bean.Product;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wukongyong
 * @since 2023-02-18
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    /*@Value("${spring.cloud.client.ip-address}") //spring cloud 自动的获取当前应用的ip地址
    private String ip;*/

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        Product product = new Product().selectById(id);
        product.setProductName("访问的服务地址:"+ "localhost" + ":" + port);
        return product;
    }

    /*@RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody Product product) {
        product.update(null);
        return "保存成功";
    }*/

}
