package com.github.sd4324530.fastexcel.entity;

import com.github.sd4324530.fastexcel.annotation.MapperCell;

/**
 * @author peiyu
 */
public class Crossing {

    @MapperCell(cellName = "ADDRESS", order = 2)
    private String address ;
    @MapperCell(cellName = "ROADNAME", order = 3)
    private String roadName ;
    @MapperCell(cellName = "X", order = 7)
    private String X ;

    @MapperCell(cellName = "Y", order = 8)
    private String Y ;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getY() {
        return Y;
    }

    public void setY(String y) {
        Y = y;
    }

    @Override
    public String toString() {
        return "Crossing{" +
                "address='" + address + '\'' +
                ", roadName='" + roadName + '\'' +
                ", X='" + X + '\'' +
                ", Y='" + Y + '\'' +
                '}';
    }

}
