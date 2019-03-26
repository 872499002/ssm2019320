package com.nuesoft.service.impl;

import com.nuesoft.dao.BookInfoMapper;
import com.nuesoft.po.BookInfo;
import com.nuesoft.po.BookInfoExample;
import com.nuesoft.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Autowired
    private BookInfoMapper bookInfoDao;

    @Override
    public int deleteByPrimaryKey(Integer bookId) {
        return bookInfoDao.deleteByPrimaryKey(bookId);
    }

    @Override
    public int insert(BookInfo record) {
        return bookInfoDao.insert(record);
    }

    @Override
    public int insertSelective(BookInfo record) {
        return bookInfoDao.insertSelective(record);
    }

    @Override
    public List<BookInfo> selectByExample(BookInfoExample example) {
        return bookInfoDao.selectByExample(example);
    }

    @Override
    public BookInfo selectByPrimaryKey(Integer bookId) {
        return bookInfoDao.selectByPrimaryKey(bookId);
    }

    @Override
    public int updateByPrimaryKeySelective(BookInfo record) {
        return bookInfoDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BookInfo record) {
        return bookInfoDao.updateByPrimaryKey(record);
    }

    @Override
    public BookInfo selectById(Integer bookId) {
        return bookInfoDao.selectById(bookId);
    }

    @Override
    public List<BookInfo> selectAll() {
        return bookInfoDao.selectAll();
    }

    @Override
    public int delectByIds(String[] ids) {
        return bookInfoDao.delectByIds(ids);
    }


}
