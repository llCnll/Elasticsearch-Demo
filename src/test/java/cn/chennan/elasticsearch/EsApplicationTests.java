package cn.chennan.elasticsearch;

import cn.chennan.elasticsearch.po.EsBlog;
import cn.chennan.elasticsearch.po.dao.EsBlogDao;
import cn.chennan.elasticsearch.repository.EsBlogRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EsApplicationTests {

    @Autowired
    EsBlogRepository esBlogRepository;

    @Autowired
    EsBlogDao esBlogDao;

    @Before
    public void initRepositoryData(){
        esBlogRepository.deleteAll();

        List<EsBlog> esBlogs = esBlogDao.listAll();
        esBlogs.forEach(blog-> {
            System.out.println(blog);
            esBlogRepository.save(blog);
        });
        System.out.println();
        /*//单机
        esBlogRepository.save(new EsBlog("登黄鹤楼", "王之涣的登黄鹤楼", "白日依山尽,黄河入海流.欲穷千里目,更上一层路."));
        esBlogRepository.save(new EsBlog("相思", "王维的相思", "红豆生南国,春来发几枝.愿君多采撷,此物最相思."));
        esBlogRepository.save(new EsBlog("静夜思", "李白的静夜思", "床前明月光,疑是地上霜.举头望明月,低头思故乡."));*/
    }

    @Test
    public void testEsBlogRepository() {
        Pageable pageable = new PageRequest(0,20);
        String title = "思";
        String summary = "相思";
        String content = "相思";
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);

        page.forEach(p->System.out.println(p));
    }

}
