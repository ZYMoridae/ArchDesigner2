package newgrails

class User {

    String fname;
    String lname;
    String userpwd;
    String userlevel;
    String email;
    Integer sessionid;
    String timestamp;
    String remark;

    static constraints = {
        sessionid nullable: true
        timestamp nullable: true
    }

}
