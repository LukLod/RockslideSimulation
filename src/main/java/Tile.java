public abstract class Tile {

    private boolean toBeDestroyed = false;
    protected boolean updatable = true;
    protected Position position;
    Tile(int x, int y){
        position=new Position(x,y);
    }

    abstract public void update(Simulation simulation);
    public boolean isUpdatable(){
        return updatable;
    }
    public int getX(){
        return position.getX();
    }
    public int getY(){
        return position.getY();
    }
    public void setUpdatability(){
        updatable = true;
    }
    public boolean isToBeDestroyed(){
        return toBeDestroyed;
    }
    public void destroy(){
        toBeDestroyed = true;
    }

}

