package com.marshmallow.test.durand.model;

public class Coordinates {
    private Integer x;
    private Integer y;

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }


    public void moveLeft() {
        this.x = this.x -1;
    }

    public void moveRight() {
        this.x = this.x + 1;
    }

    public void moveUp() {
        this.y = this.y + 1;
    }

    public void moveDown() {
        this.y = this.y - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(x, that.x)
                .append(y, that.y)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(x)
                .append(y)
                .toHashCode();
    }
}
