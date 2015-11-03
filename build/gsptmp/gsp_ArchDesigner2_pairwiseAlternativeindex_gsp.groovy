import newgrails.User
import  newgrails.Decision
import  newgrails.ArchApplication
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ArchDesigner2_pairwiseAlternativeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pairwiseAlternative/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'pairwiseAlternative.label', default: 'PairwiseAlternative'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
invokeTag('stylesheet','asset',10,['src':("archdesigner.css")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(entityName)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
for( application in (newgrails.ArchApplication.getAll()) ) {
printHtmlPart(7)
expressionOut.print(application.id)
printHtmlPart(8)
expressionOut.print(application.appName)
printHtmlPart(9)
}
printHtmlPart(10)
for( decision in (newgrails.Decision.getAll()) ) {
printHtmlPart(7)
expressionOut.print(decision.id)
printHtmlPart(8)
expressionOut.print(decision.decisionName)
printHtmlPart(9)
}
printHtmlPart(11)
for( quality in (newgrails.Quality.getAll()) ) {
printHtmlPart(7)
expressionOut.print(quality.id)
printHtmlPart(8)
expressionOut.print(quality.qualityName)
printHtmlPart(9)
}
printHtmlPart(12)
for( alternative in (newgrails.Alternative.getAll()) ) {
printHtmlPart(7)
expressionOut.print(alternative.id)
printHtmlPart(8)
expressionOut.print(alternative.alternativeName)
printHtmlPart(9)
}
printHtmlPart(13)
for( alternative in (newgrails.Alternative.getAll()) ) {
printHtmlPart(7)
expressionOut.print(alternative.id)
printHtmlPart(8)
expressionOut.print(alternative.alternativeName)
printHtmlPart(9)
}
printHtmlPart(14)
invokeTag('submitButton','g',85,['name':("create"),'class':("save btn btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(15)
})
invokeTag('form','g',86,['action':("save")],2)
printHtmlPart(16)
invokeTag('message','g',86,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(17)
for( application in (userApplication) ) {
printHtmlPart(18)
expressionOut.print(application.id)
printHtmlPart(8)
expressionOut.print(application.appName)
printHtmlPart(19)
}
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('submitButton','g',117,['name':("generatePair"),'class':("btn btn-primary btn-info"),'value':("Generate Pairwise"),'style':("font-weight: 100;")],-1)
printHtmlPart(22)
})
invokeTag('form','g',118,['action':("generatePairwise")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('submitButton','g',123,['name':("deletePair"),'class':("btn btn-primary btn-danger"),'value':("Delete Pairwise"),'style':("font-weight: 100;")],3)
printHtmlPart(22)
})
invokeTag('form','g',124,['action':("")],2)
printHtmlPart(26)
loop:{
int i = 0
for( pairwisealternative in (newgrails.PairwiseAlternative.getAll()) ) {
printHtmlPart(27)
expressionOut.print(newgrails.ArchApplication.findById(pairwisealternative.appId).appName)
printHtmlPart(28)
expressionOut.print(newgrails.Decision.findById(pairwisealternative.decisionId).decisionName)
printHtmlPart(28)
expressionOut.print(newgrails.Alternative.findById(pairwisealternative.firstalterId).alternativeName)
printHtmlPart(28)
expressionOut.print(newgrails.Alternative.findById(pairwisealternative.secondalterId).alternativeName)
printHtmlPart(28)
expressionOut.print(newgrails.Quality.findById(pairwisealternative.qualityId).qualityName)
printHtmlPart(28)
expressionOut.print(pairwisealternative.weight)
printHtmlPart(29)
expressionOut.print(pairwisealternative.id)
printHtmlPart(30)
expressionOut.print(entityName)
printHtmlPart(31)
createTagBody(3, {->
printHtmlPart(32)
invokeTag('hiddenField','g',181,['name':("version"),'value':(this.pairwisealternative?.version)],-1)
printHtmlPart(33)
invokeTag('sall','ad',184,['entityid':(pairwisealternative.id),'entitytype':("pairwiseAlternative")],-1)
printHtmlPart(34)
expressionOut.print(message(code: 'default.button.update.label', default: 'Update'))
printHtmlPart(35)
})
invokeTag('form','g',197,['resource':(pairwisealternative),'method':("PUT")],3)
printHtmlPart(36)
expressionOut.print(pairwisealternative.id)
printHtmlPart(37)
createClosureForHtmlPart(38, 3)
invokeTag('form','g',212,['resource':(pairwisealternative),'method':("DELETE")],3)
printHtmlPart(39)
i++
}
}
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',254,[:],1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446589219000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
