package entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "dbo", catalog = "forum")
public class UsersEntity {
    private String id;
    private String account;
    private String username;
    private Date birthday;
    private String gendar;
    private String password;
    private String address;
    private String email;
    private String head;
    private String msg;
    private String phone;
    private Timestamp regTime;
    private Collection<NewsEntity> newsById;
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
    @Column(name = "account", nullable = false, length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "gendar", nullable = true, length = 3)
    public String getGendar() {
        return gendar;
    }

    public void setGendar(String gendar) {
        this.gendar = gendar;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 10)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "head", nullable = true, length = 10)
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Basic
    @Column(name = "msg", nullable = true, length = 100)
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "regTime", nullable = true)
    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UsersEntity that = (UsersEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (account != null ? !account.equals(that.account) : that.account != null) {
            return false;
        }
        if (username != null ? !username.equals(that.username) : that.username != null) {
            return false;
        }
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) {
            return false;
        }
        if (gendar != null ? !gendar.equals(that.gendar) : that.gendar != null) {
            return false;
        }
        if (password != null ? !password.equals(that.password) : that.password != null) {
            return false;
        }
        if (address != null ? !address.equals(that.address) : that.address != null) {
            return false;
        }
        if (email != null ? !email.equals(that.email) : that.email != null) {
            return false;
        }
        if (head != null ? !head.equals(that.head) : that.head != null) {
            return false;
        }
        if (msg != null ? !msg.equals(that.msg) : that.msg != null) {
            return false;
        }
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) {
            return false;
        }
        if (regTime != null ? !regTime.equals(that.regTime) : that.regTime != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (gendar != null ? gendar.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (head != null ? head.hashCode() : 0);
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (regTime != null ? regTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByAuthorId")
    public Collection<NewsEntity> getNewsById() {
        return newsById;
    }

    public void setNewsById(Collection<NewsEntity> newsById) {
        this.newsById = newsById;
    }

    @OneToMany(mappedBy = "usersByAuthorId")
    public Collection<ReplayEntity> getReplaysById() {
        return replaysById;
    }

    public void setReplaysById(Collection<ReplayEntity> replaysById) {
        this.replaysById = replaysById;
    }
}
