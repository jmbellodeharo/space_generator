import java.awt.*;

public class SpaceObject {
    private Point startPoint;
    private int spaceObjectSize;
    private String typeSpaceObject;

    SpaceObject(Point start, int size, String type){
        setStartPoint(start);
        setSpaceObjectSize(size);
        setTypeSpaceObject(type);
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setSpaceObjectSize(int size) {
        this.spaceObjectSize = size;
    }

    public int getSpaceObjectSize() {
        return spaceObjectSize;
    }

    public void setTypeSpaceObject(String typeSpaceObject) {
        this.typeSpaceObject = typeSpaceObject;
    }

    public String getTypeSpaceObject() {
        return typeSpaceObject;
    }
}
