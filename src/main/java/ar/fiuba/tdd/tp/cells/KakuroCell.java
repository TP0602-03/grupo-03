package ar.fiuba.tdd.tp.cells;

public class KakuroCell {
    private Integer upperRight = null;
    private Integer lowerLeft = null;
    private Integer center = null;
    private boolean isWritable = true;

    public KakuroCell(Integer upperRight, Integer lowerLeft, Integer center) {
        this.upperRight = upperRight;
        this.lowerLeft = lowerLeft;
        this.center = center;
    }

    public KakuroCell() { }

    public Integer getUpperRight() {
        return upperRight;
    }

    public void setUpperRight(Integer upperRight) {
        this.upperRight = upperRight;
    }

    public Integer getLowerLeft() {
        return lowerLeft;
    }

    public void setLowerLeft(Integer lowerLeft) {
        this.lowerLeft = lowerLeft;
    }

    public Integer getCenter() {
        return center;
    }

    public void setCenter(Integer center) {
        this.center = center;
    }

    public boolean isWritable(){
        return this.isWritable;
    }

    public void setWrittability(boolean isWritable) {
        this.isWritable = isWritable;
    }
}
