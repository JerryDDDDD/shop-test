package com.layman.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.layman.mapper.TbItemMapper;
import com.layman.pojo.EasyUIDataGridResult;
import com.layman.pojo.TbItem;
import com.layman.pojo.TbItemExample;
import com.layman.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public EasyUIDataGridResult getItenList(Integer page, Integer rows) {
        // 1. 设置分页的信息使用pageHelper
        if (page == null) page = 1;
        if (rows == null) rows = 30;
        PageHelper.startPage(page,rows);
        // 2. 注入mapper
        // 3. 创建example 对象不需要设置查询条件
        TbItemExample example = new TbItemExample();
        // 4. 根据mapper调用所查询的方法
        List<TbItem> list = tbItemMapper.selectByExample(example);
        // 5. 获取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        // 6. 封装到EasyUIDataGrideResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int) pageInfo.getTotal());
        result.setRows(pageInfo.getList());
        // 7. 返回
        return result;
    }
}
