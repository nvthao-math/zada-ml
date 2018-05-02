/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zada.data.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author bigdata
 */
public class DataFrame {

    private List<Tuple<String, C>> data;
    private int colSize;
    private int rowSize;

    // constructor
    public DataFrame() {
        super();
    }

    public DataFrame(C... cols) {
        Set<Integer> cz = new HashSet<>();
        if (cols != null) {
            for (int i = 0; i < cols.length; i++) {
                C col = cols[i];
                if (col != null) {
                    String name = col.getName() == null ? String.format("column_%d", i) : col.getName();
                    Tuple tuple = new Tuple(name, col.coppy());
                    this.getData().add(tuple);
                } else {
                    throw new RuntimeException("Null Pointer Exception, input data has null elements");
                }
                cz.add(col.size());
                this.setRowSize(col.size());
            }
        }
        if (cz.size() > 1) {
            throw new RuntimeException(String.format("Arguments imply differing number of rows: %s", cz.toString()));
        }
        this.colSize = this.getData().size();
    }

    public DataFrame(List<C> cols) {
        Set<Integer> cz = new HashSet<>();
        if (cols != null) {
            for (int i = 0; i < cols.size(); i++) {
                C col = cols.get(i);
                if (col != null) {
                    String name = col.getName() == null ? String.format("column_%d", i) : col.getName();
                    Tuple tuple = new Tuple(name, col.coppy());
                    this.getData().add(tuple);
                } else {
                    throw new RuntimeException("Null Pointer Exception, input data has null elements");
                }
                cz.add(col.size());
                this.setRowSize(col.size());
            }
        }
        if (cz.size() > 1) {
            throw new RuntimeException(String.format("Arguments imply differing number of rows: %s", cz.toString()));
        }
        this.colSize = this.getData().size();
    }

    /**
     * @return the data
     */
    private List<Tuple<String, C>> getData() {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        return data;
    }

    /**
     * @param data the data to set
     */
    protected void setData(List<Tuple<String, C>> data) {
        this.data = data;
    }

    public <D> List<D> getRow(int rowIndex) {
        List<D> result = new ArrayList<>();
        for (Tuple<String, C> tuple : this.getData()) {
            D val = (D) tuple._2().get(rowIndex);
            result.add(val);
        }
        return result;
    }

    public C getColumn(int colIndex) {
        return this.getData().get(colIndex)._2();
    }

    public C getColumn(String colName) {
        C result = new C();
        for (Tuple<String, C> tuple : this.getData()) {
            if (colName.equals(tuple._1())) {
                result = tuple._2();
            }
        }
        return result;
    }

    public <D> D getElement(int row, int column) {
        Object val = this.getColumn(column).get(row);
        return (D) val;
    }

    /**
     * @return the colSize
     */
    public int getColSize() {
        return colSize;
    }

    /**
     * @param colSize the colSize to set
     */
    public void setColSize(int colSize) {
        this.colSize = colSize;
    }

    /**
     * @return the rowSize
     */
    public int getRowSize() {
        return rowSize;
    }

    /**
     * @param rowSize the rowSize to set
     */
    public void setRowSize(int rowSize) {
        this.rowSize = rowSize;
    }

    public List<String> getHeader() {
        List<String> header = new ArrayList<>();
        this.getData().forEach((tuple) -> {
            header.add(tuple._1());
        });
        return header;
    }

    public void setHeader(String... headers) {
        if (this.getData().size() == headers.length) {
            for (int i = 0; i < headers.length; i++) {
                this.getData().get(i).set1(headers[i]);
            }
        } else {
            throw new RuntimeException(String.format("Length argument and header are difference. argument: %d, header: %d", headers.length, this.getData().size()));
        }
    }

    public void setHeader(List<String> headers) {
        if (this.getData().size() == headers.size()) {
            for (int i = 0; i < headers.size(); i++) {
                this.getData().get(i).set1(headers.get(i));
            }
        } else {
            throw new RuntimeException(String.format("Length argument and header are difference. argument: %d, header: %d", headers.size(), this.getData().size()));
        }
    }

    public String toString(int limitIndex) {
        String headerInfo = String.format("index\t%s", String.join("\t", this.getHeader()));
        StringBuilder sb = new StringBuilder();
        sb.append(headerInfo).append("\n");
        for (int i = 0; i < this.getRowSize(); i++) {
            StringBuilder cabin = new StringBuilder();
            List<Object> row = this.getRow(i);
            row.forEach((obj) -> {
                cabin.append(obj.toString()).append("\t");
            });
            sb.append(i).append("\t").append(cabin.toString()).append("\n");
            if (i == limitIndex) {
                break;
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.toString(this.getRowSize());
    }

}
