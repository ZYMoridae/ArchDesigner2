package newgrails

class PairwiseQuality implements Serializable{

    Integer weight;

    static belongsTo = [stakeholder: Stakeholder, decision: Decision, firstquality: Quality, secondquality: Quality, app: ArchApplication]

    static constraints = {
    }

}
