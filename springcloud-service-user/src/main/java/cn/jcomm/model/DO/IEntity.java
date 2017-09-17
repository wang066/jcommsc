package cn.jcomm.model.DO;

/**
 * Created by jowang on 2017/4/18 0018.
 */
public abstract class IEntity {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
