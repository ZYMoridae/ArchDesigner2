import newgrails.ArchApplication
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ArchDesigner2_decisionindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/decision/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'decision.label', default: 'Decision'))],-1)
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
invokeTag('submitButton','g',63,['name':("create"),'class':("save btn btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(11)
})
invokeTag('form','g',63,['action':("save")],2)
printHtmlPart(12)
invokeTag('message','g',64,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(13)
loop:{
int i = 0
for( decision in (userDecision) ) {
printHtmlPart(14)
expressionOut.print(decision.decisionName)
printHtmlPart(15)
expressionOut.print(newgrails.ArchApplication.findById(decision.appId).appName)
printHtmlPart(15)
expressionOut.print(decision.weight)
printHtmlPart(15)
expressionOut.print(decision.remark)
printHtmlPart(16)
expressionOut.print(decision.id)
printHtmlPart(17)
expressionOut.print(entityName)
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('hiddenField','g',115,['name':("version"),'value':(this.decision?.version)],-1)
printHtmlPart(20)
invokeTag('sall','ad',119,['entityid':(decision.id),'entitytype':("decision")],-1)
printHtmlPart(21)
expressionOut.print(message(code: 'default.button.update.label', default: 'Update'))
printHtmlPart(22)
})
invokeTag('form','g',128,['resource':(decision),'method':("PUT")],3)
printHtmlPart(23)
expressionOut.print(decision.id)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('form','g',143,['resource':(decision),'method':("DELETE")],3)
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',147,['next':("Next"),'prev':("Prev"),'total':(decisionCount?: 0)],-1)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',163,[:],1)
printHtmlPart(29)
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
