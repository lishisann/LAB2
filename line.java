package lab2;

class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    //Метод для вычисления длины линии (целое число)
    public int getLength() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return (int) Math.round(Math.sqrt(dx * dx + dy * dy)); // округление до ближайшего целого
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
