package ar.fiuba.tdd.tp.cell;

public class KakuroCell {
    private Integer upperRight = null;
    private Integer lowerLeft = null;
    private Integer center = null;

    public KakuroCell(Integer upperRight, Integer lowerLeft, Integer center) {
        this.upperRight = upperRight;
        this.lowerLeft = lowerLeft;
        this.center = center;
    }

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
        return (upperRight == null && lowerLeft == null);
    }

    public boolean isHorizontalDelimeter(){
        return upperRight != null && !isWritable();
    }
}
