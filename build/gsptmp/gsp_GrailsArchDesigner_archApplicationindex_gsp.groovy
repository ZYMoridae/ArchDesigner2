import newgrails.ArchApplication
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_GrailsArchDesigner_archApplicationindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/archApplication/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'archApplication.label', default: 'ArchApplication'))],-1)
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
for( user in (newgrails.User.getAll()) ) {
printHtmlPart(7)
expressionOut.print(user.id)
printHtmlPart(8)
expressionOut.print(user.fname)
printHtmlPart(9)
expressionOut.print(user.lname)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('submitButton','g',60,['name':("create"),'class':("save btn btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(12)
})
invokeTag('form','g',61,['action':("save")],2)
printHtmlPart(13)
invokeTag('message','g',62,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(14)
loop:{
int i = 0
for( application in (newgrails.ArchApplication.findAll("from ArchApplication as c where c.user=:myuser", [myuser: session.user], [cache: true])) ) {
printHtmlPart(15)
expressionOut.print(application.appName)
printHtmlPart(16)
expressionOut.print(newgrails.User.findById(application.userId).fname)
printHtmlPart(17)
expressionOut.print(newgrails.User.findById(application.userId).lname)
printHtmlPart(16)
expressionOut.print(application.remark)
printHtmlPart(18)
expressionOut.print(application.id)
printHtmlPart(19)
expressionOut.print(entityName)
printHtmlPart(20)
createTagBody(3, {->
printHtmlPart(21)
invokeTag('hiddenField','g',111,['name':("version"),'value':(this.application?.version)],-1)
printHtmlPart(22)
invokeTag('sall','ad',114,['entityid':(application.id),'entitytype':("application")],-1)
printHtmlPart(23)
expressionOut.print(message(code: 'default.button.update.label', default: 'Update'))
printHtmlPart(24)
})
invokeTag('form','g',123,['resource':(application),'method':("PUT")],3)
printHtmlPart(25)
expressionOut.print(application.id)
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('form','g',139,['resource':(application),'method':("DELETE")],3)
printHtmlPart(28)
i++
}
}
printHtmlPart(29)
invokeTag('paginate','g',143,['next':("Next"),'prev':("Prev"),'total':(archApplicationCount?: 0)],-1)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',159,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444442321000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
