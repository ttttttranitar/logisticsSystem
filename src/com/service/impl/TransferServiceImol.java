package com.service.impl;

import com.dao.impl.TransferDaoImpl;
import com.entity.Transfer;
import com.service.TransferService;

import java.sql.SQLException;
import java.util.List;

public class TransferServiceImol implements TransferService {
    @Override
    public int save(Transfer transfer) {
        try {
            return new TransferDaoImpl().save(transfer);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Transfer getTransferByID(int id) {
        try {
            return new TransferDaoImpl().getTransferByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Transfer> getTransferList(int page, int pageSize) {
        try {
            return new TransferDaoImpl().getTransferList(page,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getTransferCount() {
        try {
            return new TransferDaoImpl().getTransferCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
