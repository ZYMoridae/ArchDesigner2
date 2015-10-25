package newgrails

class Alternative implements Serializable{
    String alternativeName;
    String remark;

    static belongsTo = [app: ArchApplication, decision: Decision]

    static constraints = {
    }

    static mapping = {
    }

}
