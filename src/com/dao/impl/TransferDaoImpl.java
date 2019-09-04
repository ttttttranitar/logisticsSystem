package com.dao.impl;

import com.dao.TransferDao;
import com.entity.Transfer;
import com.util.DButil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransferDaoImpl extends DButil implements TransferDao {

        //新增
    @Override
    public int save(Transfer transfer) throws SQLException {
        String sql="insert into `transfer`(`city`,`companyName`,`linkPhone`,`detailAddress`) values(?,?,?,?)";
        return updateDB(sql,transfer.getCity(),transfer.getCompanyName(),transfer.getLinkPhone(),transfer.getDetailAddress());
    }
        //通过id查询
    @Override
    public Transfer getTransferByID(int id) throws SQLException {
        String sql="SELECT id,`city`,`companyName`,`linkPhone`,`detailAddress` FROM `transfer` WHERE id=?";
        Transfer transfer;
        try {
            res=queryDB(sql,id);
            transfer=null;
            if (res.next()){
                transfer =new Transfer();
                transfer.setId(res.getInt("id"));
                transfer.setCity(res.getString("city"));
                transfer.setCompanyName(res.getString("companyName"));
                transfer.setLinkPhone(res.getString("linkPhone"));
                transfer.setDetailAddress(res.getString("detailAddress"));
            }
        } finally {
                closeALL(conn,stat,res);
        }
                return transfer;
    }

    @Override
    public List<Transfer> getTransferList(int page, int pageSize) throws SQLException {
       List<Transfer> transferList=new ArrayList<>();
       String sql="SELECT `id`,`city`,`companyName`,`linkPhone`,`detailAddress` FROM `transfer` LIMIT ?,?;";
        Transfer transfer;
        try {
            res=queryDB(sql,(page-1)*pageSize,pageSize);
            transfer=null;
            while (res.next()){
                transfer =new Transfer();
                transfer.setId(res.getInt("id"));
                transfer.setCity(res.getString("city"));
                transfer.setCompanyName(res.getString("companyName"));
                transfer.setLinkPhone(res.getString("linkPhone"));
                transfer.setDetailAddress(res.getString("detailAddress"));
                transferList.add(transfer);
            }
        } finally {
            closeALL(conn,stat,res);
        }
            return transferList;
    }

    @Override
    public int getTransferCount() throws SQLException {
        int count=0;
        String sql="select count(`id`)from `transfer`";
        try {
            res=queryDB(sql,null);
            if (res.next()){
                count =res.getInt(1);
            }
        } finally {
             closeALL(conn,stat,res);
        }
             return count;
    }

}
