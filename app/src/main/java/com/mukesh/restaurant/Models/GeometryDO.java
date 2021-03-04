package com.mukesh.restaurant.Models;

import java.io.Serializable;

public class GeometryDO implements Serializable {
    LocationDO location;
    ViewPortDO viewport;

    public LocationDO getLocation() {
        return location;
    }

    public void setLocation(LocationDO location) {
        this.location = location;
    }

    public ViewPortDO getViewport() {
        return viewport;
    }

    public void setViewport(ViewPortDO viewport) {
        this.viewport = viewport;
    }
}
