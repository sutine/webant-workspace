package org.webant.plugin.regioncode.data;

import org.webant.commons.entity.HttpDataEntity;

import java.io.Serializable;

public class RegionEntity extends HttpDataEntity implements Serializable {
    private String code;
    private String name;
    private String category;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
