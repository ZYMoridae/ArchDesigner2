import newgrails.ArchApplication
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_GrailsArchDesigner_qualityindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/quality/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'quality.label', default: 'Quality'))],-1)
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
invokeTag('submitButton','g',59,['name':("create"),'class':("save btn btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(11)
})
invokeTag('form','g',59,['action':("save")],2)
printHtmlPart(12)
invokeTag('message','g',60,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(13)
loop:{
int i = 0
for( quality in (userQuality) ) {
printHtmlPart(14)
expressionOut.print(quality.qualityName)
printHtmlPart(15)
expressionOut.print(newgrails.ArchApplication.findById(quality.appId).appName)
printHtmlPart(15)
expressionOut.print(quality.remark)
printHtmlPart(16)
expressionOut.print(quality.id)
printHtmlPart(17)
expressionOut.print(entityName)
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('hiddenField','g',111,['name':("version"),'value':(this.quality?.version)],-1)
printHtmlPart(20)
invokeTag('sall','ad',114,['entityid':(quality.id),'entitytype':("quality")],-1)
printHtmlPart(21)
expressionOut.print(message(code: 'default.button.update.label', default: 'Update'))
printHtmlPart(22)
})
invokeTag('form','g',124,['resource':(quality),'method':("PUT")],3)
printHtmlPart(23)
expressionOut.print(quality.id)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('form','g',139,['resource':(quality),'method':("DELETE")],3)
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',143,['next':("Next"),'prev':("Prev"),'total':(qualityCount?: 0)],-1)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',159,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444448479000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
