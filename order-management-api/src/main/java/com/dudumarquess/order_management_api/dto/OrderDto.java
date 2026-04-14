package com.dudumarquess.order_management_api.dto;

import java.util.List;

public class OrderDto {

    private Long id;
    private String status;
    private Double total;
    private String createdAt;
    private List<Long> itemsIds;

    public OrderDto(Long id, String status, Double total, String createdAt, List<Long> itemsIds) {
        this.id = id;
        this.status = status;
        this.total = total;
        this.createdAt = createdAt;
        this.itemsIds = itemsIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Long> getItemsIds() {
        return itemsIds;
    }

    public void setItemsIds(List<Long> itemsIds) {
        this.itemsIds = itemsIds;
    }
}
