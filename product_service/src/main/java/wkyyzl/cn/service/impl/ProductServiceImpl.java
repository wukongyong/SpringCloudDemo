package wkyyzl.cn.service.impl;

import wkyyzl.cn.bean.Product;
import wkyyzl.cn.mapper.ProductMapper;
import wkyyzl.cn.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wukongyong
 * @since 2023-02-18
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
