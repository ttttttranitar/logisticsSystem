package com.service;

import com.entity.Transfer;

import java.util.List;

public interface TransferService {
    //新增
    int save(Transfer transfer);
    //查询
    Transfer getTransferByID(int id);
    //列表
    List<Transfer> getTransferList(int page,int pageSize);
    //总记录数
    int getTransferCount();
}
