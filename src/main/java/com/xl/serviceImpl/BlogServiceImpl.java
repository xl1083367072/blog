package com.xl.serviceImpl;

import com.xl.mapper.BlogMapper;
import com.xl.pojo.Blog;
import com.xl.pojo.BlogExample;
import com.xl.service.BlogService;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private HttpSolrServer solrServer;

    @Override
    public List<Blog> list(Map<String, Object> map) {
        return blogMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return blogMapper.getTotal(map);
    }

    @Override
    public List<Blog> countList() {
        return blogMapper.countList();
    }

    @Override
    public Blog findById(Integer id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public Blog lastBlog(Integer id) {
        return blogMapper.lastBlog(id);
    }

    @Override
    public Blog nextBlog(Integer id) {
        return blogMapper.nextBlog(id);
    }

    @Override
    public void update(Blog blog) {
        blogMapper.updateByPrimaryKeySelective(blog);
    }

    @Override
    public int save(Blog blog) {
        return blogMapper.insertSelective(blog);
    }

    @Override
    public List<Blog> findAll() {
        return blogMapper.selectByExample(null);
    }

    @Override
    public void removeBlogById(Integer id) {
        blogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 删除该博客类型下的所有博客
     * @param typeId
     */
    @Override
    public void removeByTypeId(Integer typeId) {
        BlogExample example = new BlogExample();
        example.createCriteria().andType_idEqualTo(typeId);
        List<Blog> blogs = blogMapper.selectByExample(example);
        try {
            for (Blog blog:blogs) {
                blogMapper.deleteByPrimaryKey(blog.getId());
                solrServer.deleteById(String.valueOf(blog.getId()));
            }
            solrServer.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
