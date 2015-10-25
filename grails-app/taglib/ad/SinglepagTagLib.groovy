package ad

import newgrails.Alternative
import newgrails.ArchApplication
import newgrails.Decision
import newgrails.PairwiseAlternative
import newgrails.PairwiseQuality
import newgrails.Quality
import newgrails.Stakeholder
import newgrails.User

class SinglepagTagLib {

    static namespace = "ad"

    def sall = { attrs ->
        def entityid = attrs.entityid
        def entitytype = attrs.entitytype
        out << showEditElements(entityid, entitytype)
    }

    def showEditElements(entityid, entitytype){
        StringBuilder sb = new StringBuilder();

        if (entitytype == "user"){
            User tempUser = User.findById(entityid)
            sb << "<div class=\"fieldcontain required\"> <label for=\"fname\">First Name<span class=\"required-indicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"fname\" value=\"${tempUser.fname}\" required=\"\"/></div>\n"
            sb <<= "<div class=\"fieldcontain required\"> <label for=\"lname\">Last Name<span class=\"required-indicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"lname\" value=\"${tempUser.lname}\" required=\"\"/></div>\n"
            sb <<= "<div class=\"fieldcontain required\"> <label for=\"fname\">Password<span class=\"required-indicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"userpwd\" value=\"${tempUser.userpwd}\" required=\"\"/></div>\n"
            sb <<= "<div class=\"fieldcontain required\"> <label for=\"fname\">User Level<span class=\"required-indicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"userlevel\" value=\"${tempUser.userlevel}\" required=\"\"/></div>\n"
            sb <<= "<div class=\"fieldcontain required\"> <label for=\"fname\">Email<span class=\"required-indicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"email\" value=\"${tempUser.email}\" required=\"\"/></div>\n"
            sb <<= "<div class=\"fieldcontain required\"> <label for=\"fname\">Last Name<span class=\"required-indicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"remark\" value=\"${tempUser.remark}\" required=\"\"/></div>\n"

        }else if (entitytype == "stakeholder"){
            Stakeholder tempStakeholder = Stakeholder.findById(entityid)
            sb << "<div class=\"fieldcontain required\"> <label for=\"stakeholdername\">StakeHolderName<span class=\"required-i\\ndicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"stakeholderName\" value=\"${tempStakeholder.stakeholderName}\" required=\"\"/></div>\n" +
                    "<div class=\"fieldcontain required\"> <label for=\"email\">App<span class=\"required-i ndicator\">*</span></label>\n" +
                    "<select class=\"form-control\" name=\"app.id\">\n"

            def ArchApplicationList = ArchApplication.getAll()
            for (int i = 0; i < ArchApplicationList.size(); i++) {
                if (tempStakeholder.getAppId() == ArchApplicationList.get(i).id)
                {
                    sb <<= "<option selected value=\"${ArchApplicationList.get(i).id}\">${ArchApplicationList.get(i).appName}</option>"
                }else{
                    sb <<= "<option value=\"${ArchApplicationList.get(i).id}\">${ArchApplicationList.get(i).appName}</option>"
                }
            }
            sb <<= "</select></div><div class=\"fieldcontain required\"> <label for=\"remark\">Remark<span class=\"required-i\\ndicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"remark\" value=\"${tempStakeholder.remark}\" required=\"\"/></div>"
        }else if (entitytype == "quality"){
            Quality tempQuality = Quality.findById(entityid)
            sb << "<div class=\"fieldcontain required\"> <label for=\"qualityname\">QualityName<span " +
                    "class=\"required-indicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"qualityName\" value=\"${tempQuality.qualityName}\" required=\"\"/></div>\n" +
                    "<div class=\"fieldcontain required\"> <label for=\"email\">App<span class=\"required-i ndicator\">*</span></label>\n" +
                    "<select class=\"form-control\" name=\"app.id\">\n"
            def ArchApplicationList = ArchApplication.getAll()
            for (int i = 0; i < ArchApplicationList.size(); i++) {
                if (tempQuality.getAppId() == ArchApplicationList.get(i).id)
                {
                    sb <<= "<option selected value=\"${ArchApplicationList.get(i).id}\">${ArchApplicationList.get(i).appName}</option>"
                }else{
                    sb <<= "<option value=\"${ArchApplicationList.get(i).id}\">${ArchApplicationList.get(i).appName}</option>"
                }
            }
            sb <<= "</select></div>\n"
            sb <<=   "<div class=\"fieldcontain required\"> <label for=\"remark\">Remark<span " +
                    "class=\"required-indicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"remark\" value=\"${tempQuality.remark}\" required=\"\"/></div>\n"
        }else if (entitytype == "alternative"){
            Alternative tempAlternative = Alternative.findById(entityid)
            sb << "<div class=\"fieldcontain required\"> <label for=\"qualityname\">AlternativeName<span " +
                    "class=\"required-indicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"alternativeName\" value=\"${tempAlternative.alternativeName}\" required=\"\"/></div>\n" +
                    "<div class=\"fieldcontain required\"> <label for=\"email\">App<span class=\"required-i ndicator\">*</span></label>\n" +
                    "<select class=\"form-control\" name=\"app.id\">\n"
            def ArchApplicationList = ArchApplication.getAll()
            for (int i = 0; i < ArchApplicationList.size(); i++) {
                if (tempAlternative.getAppId() == ArchApplicationList.get(i).id)
                {
                    sb <<= "<option selected value=\"${ArchApplicationList.get(i).id}\">${ArchApplicationList.get(i).appName}</option>"
                }else{
                    sb <<= "<option value=\"${ArchApplicationList.get(i).id}\">${ArchApplicationList.get(i).appName}</option>"
                }
            }
            sb <<= "</select></div>\n"

            sb <<= "<div class=\"fieldcontain required\"> <label for=\"decision\">App<span class=\"required-i ndicator\">*</span></label>\n" +
                    "<select class=\"form-control\" name=\"decision.id\">\n"
            def decisionList= Decision.getAll()
            for (int i = 0; i < decisionList.size(); i++) {
                if (tempAlternative.getDecisionId() == decisionList.get(i).id)
                {
                    sb <<= "<option selected value=\"${decisionList.get(i).id}\">${decisionList.get(i).decisionName}</option>"
                }else{
                    sb <<= "<option value=\"${decisionList.get(i).id}\">${decisionList.get(i).decisionName}</option>"
                }
            }
            sb <<= "</select></div>\n"

            sb << "<div class=\"fieldcontain required\"> <label for=\"remark\">Remark<span " +
                    "class=\"required-indicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"remark\" value=\"${tempAlternative.remark}\" required=\"\"/></div>\n"
        }else if (entitytype == "application"){
            ArchApplication tempApplication = ArchApplication.findById(entityid)
            sb << "<div class=\"fieldcontain required\"> <label for=\"appname\">ApplicationName<span " +
                    "class=\"required-indicator\">*</span></label>\n <input type=\"text\" " +
                    "name=\"appName\" value=\"${tempApplication.appName}\" required=\"\"/></div>\n" +
                    "<div class=\"fieldcontain required\"> <label for=\"user\">User<span class=\"required-indicator\">*</span></label>\n" +
                    "<select class=\"form-control\"name=\"user.id\">\n"

            def userList= User.getAll()
            for (int i = 0; i < userList.size(); i++) {
                if (tempApplication.getUserId() == userList.get(i).id)
                {
                    sb <<= "<option selected value=\"${userList.get(i).id}\">${userList.get(i).fname}.${userList.get(i).lname}</option>"
                }else{
                    sb <<= "<option value=\"${userList.get(i).id}\">${userList.get(i).fname}.${userList.get(i).lname}</option>"
                }
            }
            sb <<= "</select></div><div class=\"fieldcontain required\"> <label for=\"remark\">Remark<span class=\"required-i\\ndicator\">*</span></label><input type=\"text\" " +
                    "name=\"remark\" value=\"${tempApplication.remark}\" required=\"\"/></div>"
        }else if (entitytype == "decision"){
            Decision tempDecision = Decision.findById(entityid)
            sb << "<div class=\"fieldcontain required\"> <label for=\"stakeholdername\">DecisionName<span " +
                    "class=\"required-indicator\">*</span></label>\n <input type=\"text\" " +
                    "name=\"stakeholderName\" value=\"${tempDecision.decisionName}\" required=\"\"/></div>\n" +
                    "<div class=\"fieldcontain required\"> <label for=\"email\">App<span class=\"required-i ndicator\">*</span></label>\n" +
                    "<select class=\"form-control\" name=\"app.id\">\n"
            def ArchApplicationList = ArchApplication.getAll()
            for (int i = 0; i < ArchApplicationList.size(); i++) {
                if (tempDecision.getAppId() == ArchApplicationList.get(i).id)
                {
                    sb <<= "<option selected value=\"${ArchApplicationList.get(i).id}\">${ArchApplicationList.get(i).appName}</option>"
                }else{
                    sb <<= "<option value=\"${ArchApplicationList.get(i).id}\">${ArchApplicationList.get(i).appName}</option>"
                }
            }
            sb <<= "</select></div>\n"
            sb <<=  "<div class=\"fieldcontain required\"> <label for=\"weight\">Weight<span class=\"required-indicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"weight\" value=\"${tempDecision.weight}\" required=\"\"/></div>"
            sb <<=  "<div class=\"fieldcontain required\"> <label for=\"weight\">Remark<span class=\"required-indicator\">*</span></label>\n" +
                    "<input type=\"text\" name=\"remark\" value=\"${tempDecision.remark}\" required=\"\"/></div>"
        }else if(entitytype == "pairwiseQuality"){

            PairwiseQuality tempPairwiseQuality = PairwiseQuality.findById(entityid)

            sb <<  "<div class=\"fieldcontain required\"> <label for=\"weight\">Application<span class=\"required-indicator\">*</span></label><input style=\"width: 100%;\" type=\"text\" " +
                    "name=\"app\" value=\"${tempPairwiseQuality.app.appName}\" required=\"\" disabled/></div>"

            sb <<=  "<div class=\"fieldcontain required\"> <label for=\"weight\">Decision<span class=\"required-indicator\">*</span></label><input style=\"width: 100%;\" type=\"text\" " +
                    "name=\"decison\" value=\"${tempPairwiseQuality.decision.decisionName}\" required=\"\" disabled/></div>"

            sb <<=  "<div class=\"fieldcontain required\"> <label for=\"fquality\">First Quality<span class=\"required-indicator\">*</span></label><input style=\"width: 100%;\" type=\"text\" " +
                    "name=\"firstquality\" value=\"${tempPairwiseQuality.firstquality.qualityName}\" required=\"\" disabled/></div>"

            sb <<=  "<div class=\"fieldcontain required\"> <label for=\"squality\">Second Quality<span class=\"required-indicator\">*</span></label><input style=\"width: 100%;\" type=\"text\" " +
                    "name=\"secondquality\" value=\"${tempPairwiseQuality.secondquality.qualityName}\" required=\"\" disabled/></div>"

            sb <<=  "<div class=\"fieldcontain required\"> <label for=\"weight\">Stakeholder<span class=\"required-indicator\">*</span></label><input style=\"width: 100%;\" type=\"text\" " +
                    "name=\"stakeholder\" value=\"${tempPairwiseQuality.stakeholder.stakeholderName}\" required=\"\" disabled/></div>"

            sb <<= "<div class=\"fieldcontain required\"> <label for=\"weight\">Weight<span class=\"required-i ndicator\">*</span></label>\n" + "<select class=\"form-control\" style=\"width: 100%;\" name=\"weight\">\n"
            for (int i = -9; i <= 9; i=i+2) {
                if ( i == tempPairwiseQuality.weight)
                {
                    sb <<= "<option selected value=\"${String.valueOf(i)}\">${String.valueOf(i)}</option>"
                }else{
                    sb <<= "<option value=\"${String.valueOf(i)}\">${String.valueOf(i)}</option>"
                }
            }
            sb <<= "</select></div>\n"


        }else if (entitytype == "pairwiseAlternative"){

            PairwiseAlternative tempPairwiseAlternative = PairwiseAlternative.findById(entityid)

            sb <<  "<div class=\"fieldcontain required\"> <label for=\"weight\">Application<span class=\"required-indicator\">*</span></label><input style=\"width: 100%;\" type=\"text\" " +
                    "name=\"app\" value=\"${tempPairwiseAlternative.app.appName}\" required=\"\" disabled/></div>"

            sb <<=  "<div class=\"fieldcontain required\"> <label for=\"weight\">Decision<span class=\"required-indicator\">*</span></label><input style=\"width: 100%;\" type=\"text\" " +
                    "name=\"decison\" value=\"${tempPairwiseAlternative.decision.decisionName}\" required=\"\" disabled/></div>"

            sb <<=  "<div class=\"fieldcontain required\"> <label for=\"fquality\">First Alternative<span class=\"required-indicator\">*</span></label><input style=\"width: 100%;\" type=\"text\" " +
                    "name=\"firstalter\" value=\"${tempPairwiseAlternative.firstalter.alternativeName}\" required=\"\" disabled/></div>"

            sb <<=  "<div class=\"fieldcontain required\"> <label for=\"squality\">Second Alternative<span class=\"required-indicator\">*</span></label><input style=\"width: 100%;\" type=\"text\" " +
                    "name=\"secondalter\" value=\"${tempPairwiseAlternative.secondalter.alternativeName}\" required=\"\" disabled/></div>"

            sb <<=  "<div class=\"fieldcontain required\"> <label for=\"weight\">Quality<span class=\"required-indicator\">*</span></label><input style=\"width: 100%;\" type=\"text\" " +
                    "name=\"quality\" value=\"${tempPairwiseAlternative.quality.qualityName}\" required=\"\" disabled/></div>"

            sb <<= "<div class=\"fieldcontain required\"> <label for=\"weight\">Weight<span class=\"required-i ndicator\">*</span></label>\n" + "<select class=\"form-control\" style=\"width: 100%;\" name=\"weight\">\n"
            for (int i = -9; i <= 9; i=i+2) {
                if ( i == tempPairwiseAlternative.weight)
                {
                    sb <<= "<option selected value=\"${String.valueOf(i)}\">${String.valueOf(i)}</option>"
                }else{
                    sb <<= "<option value=\"${String.valueOf(i)}\">${String.valueOf(i)}</option>"
                }
            }
            sb <<= "</select></div>\n"
        }
        sb.toString()
    }
}
