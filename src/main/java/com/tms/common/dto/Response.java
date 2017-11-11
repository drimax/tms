package com.tms.common.dto;

import java.util.List;

/**
 * Created by hp on 10/27/2017.
 */
public class Response<E> {

    private boolean success;

    private List<E> tableData;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<E> getTableData() {
        return tableData;
    }

    public void setTableData(List<E> tableData) {
        this.tableData = tableData;
    }

}
