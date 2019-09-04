package com.dao;

import com.entity.Cost;
import com.entity.Transfer;

import java.sql.SQLException;
import java.util.List;

public interface TransferDao {
    //新增
    int save(Transfer transfer)throws SQLException;
    //查询
    Transfer getTransferByID(int id)throws  SQLException;
    //带分页的list
    List<Transfer> getTransferList(int page, int pageSize)throws SQLException;
    //总记录数
    int getTransferCount() throws  SQLException;
}
