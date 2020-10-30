package my3.entity;

/**
 * @BelongsProject: WebApplicationSecondary
 * @BelongsPackage: my3.entity
 * @Author: billzhang
 * @CreateTime: 2020-10-30
 * @Description:
 */
public class User {
    public int id;
    public String username;
    public String password;
    public String email;
    public boolean canRead;
    public boolean canPost;
    public boolean canReply;
    public int level;
    public Object timeCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCanRead() {
        return canRead;
    }

    public void setCanRead(boolean canRead) {
        this.canRead = canRead;
    }

    public boolean isCanPost() {
        return canPost;
    }

    public void setCanPost(boolean canPost) {
        this.canPost = canPost;
    }

    public boolean isCanReply() {
        return canReply;
    }

    public void setCanReply(boolean canReply) {
        this.canReply = canReply;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Object getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Object timeCreated) {
        this.timeCreated = timeCreated;
    }
}
