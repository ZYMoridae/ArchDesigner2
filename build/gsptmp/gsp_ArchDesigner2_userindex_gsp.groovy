import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ArchDesigner2_userindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'user.label', default: 'User'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
invokeTag('stylesheet','asset',9,['src':("archdesigner.css")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(entityName)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('set','g',27,['var':("fieldFname"),'value':("fname")],-1)
printHtmlPart(7)
invokeTag('set','g',28,['var':("fieldLname"),'value':("lname")],-1)
printHtmlPart(7)
invokeTag('set','g',30,['var':("fieldPwd"),'value':("userpwd")],-1)
printHtmlPart(7)
invokeTag('set','g',31,['var':("fieldLevel"),'value':("userlevel")],-1)
printHtmlPart(7)
invokeTag('set','g',32,['var':("fieldEmail"),'value':("email")],-1)
printHtmlPart(7)
invokeTag('set','g',34,['var':("fieldSessionid"),'value':("sessionid")],-1)
printHtmlPart(7)
invokeTag('set','g',35,['var':("fiedlTimestamp"),'value':("timestamp")],-1)
printHtmlPart(7)
invokeTag('set','g',36,['var':("fieldRemark"),'value':("remark")],-1)
printHtmlPart(8)
expressionOut.print(fieldFname)
printHtmlPart(9)
expressionOut.print(fieldFname)
printHtmlPart(10)
expressionOut.print(fieldLname)
printHtmlPart(11)
expressionOut.print(fieldLname)
printHtmlPart(10)
expressionOut.print(fieldPwd)
printHtmlPart(12)
expressionOut.print(fieldPwd)
printHtmlPart(10)
expressionOut.print(fieldLevel)
printHtmlPart(13)
expressionOut.print(fieldLevel)
printHtmlPart(10)
expressionOut.print(fieldEmail)
printHtmlPart(14)
expressionOut.print(fieldEmail)
printHtmlPart(10)
expressionOut.print(fieldRemark)
printHtmlPart(15)
expressionOut.print(fieldRemark)
printHtmlPart(16)
invokeTag('submitButton','g',78,['name':("create"),'class':("save btn btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(17)
})
invokeTag('form','g',79,['action':("save")],2)
printHtmlPart(18)
invokeTag('message','g',80,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(19)
loop:{
int i = 0
for( user in (newgrails.User.getAll()) ) {
printHtmlPart(20)
expressionOut.print(user.fname)
printHtmlPart(21)
expressionOut.print(user.lname)
printHtmlPart(22)
expressionOut.print(user.email)
printHtmlPart(23)
expressionOut.print(user.id)
printHtmlPart(24)
expressionOut.print(entityName)
printHtmlPart(25)
createTagBody(3, {->
printHtmlPart(26)
invokeTag('hiddenField','g',133,['name':("version"),'value':(this.user?.version)],-1)
printHtmlPart(27)
invokeTag('sall','ad',136,['entityid':(user.id),'entitytype':("user")],-1)
printHtmlPart(28)
expressionOut.print(message(code: 'default.button.update.label', default: 'Update'))
printHtmlPart(29)
})
invokeTag('form','g',147,['resource':(user),'method':("PUT")],3)
printHtmlPart(30)
expressionOut.print(user.id)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('form','g',158,['resource':(user),'method':("DELETE")],3)
printHtmlPart(33)
i++
}
}
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',175,[:],1)
printHtmlPart(35)
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
