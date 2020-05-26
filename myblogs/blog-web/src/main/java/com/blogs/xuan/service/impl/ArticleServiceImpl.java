package com.blogs.xuan.service.impl;

import com.blogs.xuan.entity.Article;
import com.blogs.xuan.mapper.ArticleMapper;
import com.blogs.xuan.service.IArticleService;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
