package my3.entity;

/**
 * @BelongsProject: WebApplicationSecondary
 * @BelongsPackage: my3.entity
 * @Author: billzhang
 * @CreateTime: 2020-10-31
 * @Description:
 */
public class Topic {
    public int id;
    public String title;
    public int userId;
    public String content;
    public int numView;
    public int numReply;
    public byte flagTop;
    public byte flagNice;
    public Object timeCreated;
    public Object timeModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumView() {
        return numView;
    }

    public void setNumView(int numView) {
        this.numView = numView;
    }

    public int getNumReply() {
        return numReply;
    }

    public void setNumReply(int numReply) {
        this.numReply = numReply;
    }

    public byte getFlagTop() {
        return flagTop;
    }

    public void setFlagTop(byte flagTop) {
        this.flagTop = flagTop;
    }

    public byte getFlagNice() {
        return flagNice;
    }

    public void setFlagNice(byte flagNice) {
        this.flagNice = flagNice;
    }

    public Object getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Object timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Object getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(Object timeModified) {
        this.timeModified = timeModified;
    }
}
