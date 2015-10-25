package newgrails

class Decision implements Serializable{
    Integer weight;
    String remark;
    String decisionName;

    static belongsTo = [app : ArchApplication]

    static hasMany = []

    static constraints = {
    }

    static mapping = {
    }
}
