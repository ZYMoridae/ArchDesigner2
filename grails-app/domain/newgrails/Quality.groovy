package newgrails

class Quality{

    String qualityName;
    String remark;

    static belongsTo = [app: ArchApplication]

    static constraints = {
    }

    def getAttributes(){
        return ['qualityName']
    }


}
