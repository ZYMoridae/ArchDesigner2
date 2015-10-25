package newgrails

class PairwiseAlternative {

    Integer weight;

    static belongsTo = [quality: Quality, app: ArchApplication, decision: Decision, firstalter: Alternative, secondalter: Alternative]

    static constraints = {
    }

}
