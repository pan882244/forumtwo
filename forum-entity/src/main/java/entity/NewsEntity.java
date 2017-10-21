package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "news", schema = "dbo", catalog = "forum")
public class NewsEntity {
    private String id;
    private String loginuserHead;
    private String userAccount;
    private String title;
    private String content;
    private Date genTime;
    private UsersEntity usersByAuthorId;
    private Collection<ReplayEntity> replaysById;

    @Id
    @Column(name = "id", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "loginuser_head", nullable = true, length = 20)
    public String getLoginuserHead() {
        return loginuserHead;
    }

    public void setLoginuserHead(String loginuserHead) {
        this.loginuserHead = loginuserHead;
    }

    @Basic
    @Column(name = "user_account", nullable = true, length = 20)
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 20)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "gen_time", nullable = true)
    public Date getGenTime() {
        return genTime;
    }

    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            {
                return true;
            }
        }
        if (o == null || getClass() != o.getClass()) {
            {
                return false;
            }
        }

        NewsEntity that = (NewsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            {
                return false;
            }
        }
        if (loginuserHead != null ? !loginuserHead.equals(that.loginuserHead) : that.loginuserHead != null) {
            {
                return false;
            }
        }
        if (userAccount != null ? !userAccount.equals(that.userAccount) : that.userAccount != null) {
            {
                return false;
            }
        }
        if (title != null ? !title.equals(that.title) : that.title != null) {
            {
                return false;
            }
        }
        if (content != null ? !content.equals(that.content) : that.content != null) {
            {
                return false;
            }
        }
        if (genTime != null ? !genTime.equals(that.genTime) : that.genTime != null) {
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (loginuserHead != null ? loginuserHead.hashCode() : 0);
        result = 31 * result + (userAccount != null ? userAccount.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (genTime != null ? genTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public UsersEntity getUsersByAuthorId() {
        return usersByAuthorId;
    }

    public void setUsersByAuthorId(UsersEntity usersByAuthorId) {
        this.usersByAuthorId = usersByAuthorId;
    }

    @OneToMany(mappedBy = "newsByNewsId")
    public Collection<ReplayEntity> getReplaysById() {
        return replaysById;
    }

    public void setReplaysById(Collection<ReplayEntity> replaysById) {
        this.replaysById = replaysById;
    }
}
