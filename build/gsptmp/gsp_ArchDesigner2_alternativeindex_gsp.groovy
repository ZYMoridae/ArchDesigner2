import newgrails.ArchApplication
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ArchDesigner2_alternativeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/alternative/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'alternative.label', default: 'Alternative'))],-1)
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
invokeTag('submitButton','g',66,['name':("create"),'class':("save btn btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(12)
})
invokeTag('form','g',67,['action':("save")],2)
printHtmlPart(13)
invokeTag('message','g',68,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(14)
loop:{
int i = 0
for( alternative in (userAlternative) ) {
printHtmlPart(15)
expressionOut.print(alternative.alternativeName)
printHtmlPart(16)
expressionOut.print(newgrails.ArchApplication.findById(alternative.appId).appName)
printHtmlPart(16)
expressionOut.print(newgrails.Decision.findById(alternative.decisionId).decisionName)
printHtmlPart(16)
expressionOut.print(alternative.remark)
printHtmlPart(17)
expressionOut.print(alternative.id)
printHtmlPart(18)
expressionOut.print(entityName)
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(20)
invokeTag('hiddenField','g',121,['name':("version"),'value':(this.alternative?.version)],-1)
printHtmlPart(21)
invokeTag('sall','ad',124,['entityid':(alternative.id),'entitytype':("alternative")],-1)
printHtmlPart(22)
expressionOut.print(message(code: 'default.button.update.label', default: 'Update'))
printHtmlPart(23)
})
invokeTag('form','g',132,['resource':(alternative),'method':("PUT")],3)
printHtmlPart(24)
expressionOut.print(alternative.id)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('form','g',146,['resource':(alternative),'method':("DELETE")],3)
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
invokeTag('paginate','g',150,['next':("Next"),'prev':("Prev"),'total':(alternativeCount?: 0)],-1)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',166,[:],1)
printHtmlPart(30)
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
