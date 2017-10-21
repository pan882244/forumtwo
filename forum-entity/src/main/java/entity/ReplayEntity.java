package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "replay", schema = "dbo", catalog = "forum")
public class ReplayEntity {
    private String id;
    private String content;
    private Timestamp replayTime;
    private NewsEntity newsByNewsId;
    private UsersEntity usersByAuthorId;

    @Id
    @Column(name = "id", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "replay_time", nullable = true)
    public Timestamp getReplayTime() {
        return replayTime;
    }

    public void setReplayTime(Timestamp replayTime) {
        this.replayTime = replayTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReplayEntity that = (ReplayEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            if (id != null ? !id.equals(that.id) : that.id != null) {}

        }
        if (content != null ? !content.equals(that.content) : that.content != null) {
            return false;
        }
        if (replayTime != null ? !replayTime.equals(that.replayTime) : that.replayTime != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (replayTime != null ? replayTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "news_id", referencedColumnName = "id")
    public NewsEntity getNewsByNewsId() {
        return newsByNewsId;
    }

    public void setNewsByNewsId(NewsEntity newsByNewsId) {
        this.newsByNewsId = newsByNewsId;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public UsersEntity getUsersByAuthorId() {
        return usersByAuthorId;
    }

    public void setUsersByAuthorId(UsersEntity usersByAuthorId) {
        this.usersByAuthorId = usersByAuthorId;
    }
}
