package com.layman.test.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.layman.mapper.TbItemMapper;
import com.layman.pojo.TbItem;
import com.layman.pojo.TbItemExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPageHelper {

    @Test
    public void testHelper(){

        //1. 设置分页信息

        //2. 初始化Spring容器

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");

        //3. 获取mapper的代理对象
         TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
        //4. 调用mapper的方法查询
        PageHelper.startPage(1,3);//3行  紧跟着的第一个查询才会被分页
        TbItemExample example = new TbItemExample(); //设置查询条件
        List<TbItem> list1 = itemMapper.selectByExample(example);
        List<TbItem> list2 = itemMapper.selectByExample(example);

        // 去分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(list1);

        System.out.println("第一个分页的list的集合长度"+list1.size());
        System.out.println("第一个分页的list的集合长度"+list2.size());

        //5.  遍历结果
        System.out.println("查询的总记录书："+pageInfo.getTotal());

        for (TbItem tbItem: list1) {
            System.out.println(tbItem.getId()+">>>>mingch>>>>>" + tbItem.getTitle() );
        }
    }
}
