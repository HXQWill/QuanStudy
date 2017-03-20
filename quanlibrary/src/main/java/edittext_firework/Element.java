package edittext_firework;

/**
 * Created by wayww on 2016/9/8.
 * Updated by xq.he on 2017/3/20
 * 烟花的小火花，存放颜色，飞行方向，飞行速度这三个变量。
 */
public class Element {
    public int color;
    public Double direction;
    public float speed;
    public float x = 0;
    public float y = 0;

    public Element(int color, Double direction, float speed){
        this.color = color;
        this.direction = direction;
        this.speed = speed;
    }
}
