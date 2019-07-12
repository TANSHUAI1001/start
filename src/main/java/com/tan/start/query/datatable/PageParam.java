package com.tan.start.query.datatable;

import com.tan.start.query.Query;

public class PageParam  extends Query {
    private Column[] columns;
    private Order[] order;
    private Search search;

    public Column[] getColumns() {
        return columns;
    }

    public void setColumns(Column[] columns) {
        this.columns = columns;
    }

    public Order[] getOrder() {
        return order;
    }

    public void setOrder(Order[] order) {
        this.order = order;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}




