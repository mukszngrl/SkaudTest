package com.mukesh.restaurant.Models;

import java.io.Serializable;

public class ViewPortDO implements Serializable {
    NorthEastDO northeast;
    SouthWestDO southwest;

    public NorthEastDO getNortheast() {
        return northeast;
    }

    public void setNortheast(NorthEastDO northeast) {
        this.northeast = northeast;
    }

    public SouthWestDO getSouthwest() {
        return southwest;
    }

    public void setSouthwest(SouthWestDO southwest) {
        this.southwest = southwest;
    }
}
