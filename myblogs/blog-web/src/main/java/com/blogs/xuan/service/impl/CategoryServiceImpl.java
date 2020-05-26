package com.blogs.xuan.service.impl;

import com.blogs.xuan.entity.Category;
import com.blogs.xuan.mapper.CategoryMapper;
import com.blogs.xuan.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 9527
 * @since 2020-05-26
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
