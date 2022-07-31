package DB;

public class Member {

    private String userId;
    private String name;
    private String email;
    private String password;
    private String hp1;
    private String hp2;
    private String hp3;
    private boolean useSmsYn;

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setHp1(String hp1) {
        this.hp1 = hp1;
    }
    public void setHp2(String hp2) {
        this.hp2 = hp2;
    }
    public void setHp3(String hp3) {
        this.hp3 = hp3;
    }
    public void setUseSmsYn(boolean useSmsYn) {
        this.useSmsYn = useSmsYn;
    }

    public String getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getHp1() {
        return hp1;
    }
    public String getHp2() {
        return hp2;
    }
    public String getHp3() {
        return hp3;
    }
    public boolean isUseSmsYn() {
        return useSmsYn;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", hp1='" + hp1 + '\'' +
                ", hp2='" + hp2 + '\'' +
                ", hp3='" + hp3 + '\'' +
                ", useSmsYn=" + useSmsYn +
                '}';
    }
}
