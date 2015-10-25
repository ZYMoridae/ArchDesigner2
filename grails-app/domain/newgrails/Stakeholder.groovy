package newgrails

class Stakeholder {

    String stakeholderName;
    String remark;

    static mapping = {
        remark type: 'text'
    }

    static belongsTo = [app : ArchApplication]


    static hasMany = [decision: Decision]

    static constraints = {
    }

}
