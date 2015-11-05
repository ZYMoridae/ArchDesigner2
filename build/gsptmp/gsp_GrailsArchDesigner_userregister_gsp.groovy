import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_GrailsArchDesigner_userregister_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/register.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("singlepage")],-1)
printHtmlPart(2)
invokeTag('set','g',12,['var':("entityName"),'value':(message(code: 'user.label', default: 'User'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(4)
invokeTag('stylesheet','asset',13,['src':("archdesigner.css")],-1)
printHtmlPart(2)
invokeTag('stylesheet','asset',15,['src':("animate.css")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',41,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('set','g',58,['var':("fieldFname"),'value':("fname")],-1)
printHtmlPart(8)
invokeTag('set','g',59,['var':("fieldLname"),'value':("lname")],-1)
printHtmlPart(8)
invokeTag('set','g',61,['var':("fieldPwd"),'value':("userpwd")],-1)
printHtmlPart(8)
invokeTag('set','g',62,['var':("fieldcPwd"),'value':("usercpwd")],-1)
printHtmlPart(8)
invokeTag('set','g',64,['var':("fieldLevel"),'value':("userlevel")],-1)
printHtmlPart(8)
invokeTag('set','g',64,['var':("fieldEmail"),'value':("email")],-1)
printHtmlPart(8)
invokeTag('set','g',66,['var':("fieldSessionid"),'value':("sessionid")],-1)
printHtmlPart(8)
invokeTag('set','g',67,['var':("fiedlTimestamp"),'value':("timestamp")],-1)
printHtmlPart(8)
invokeTag('set','g',68,['var':("fieldRemark"),'value':("remark")],-1)
printHtmlPart(9)
expressionOut.print(fieldFname)
printHtmlPart(10)
expressionOut.print(fieldFname)
printHtmlPart(11)
expressionOut.print(fieldLname)
printHtmlPart(12)
expressionOut.print(fieldLname)
printHtmlPart(13)
expressionOut.print(fieldPwd)
printHtmlPart(14)
expressionOut.print(fieldPwd)
printHtmlPart(15)
expressionOut.print(fieldPwd)
printHtmlPart(13)
expressionOut.print(fieldcPwd)
printHtmlPart(16)
expressionOut.print(fieldcPwd)
printHtmlPart(15)
expressionOut.print(fieldcPwd)
printHtmlPart(17)
expressionOut.print(fieldLevel)
printHtmlPart(18)
expressionOut.print(fieldLevel)
printHtmlPart(19)
expressionOut.print(fieldEmail)
printHtmlPart(20)
expressionOut.print(fieldEmail)
printHtmlPart(21)
expressionOut.print(fieldRemark)
printHtmlPart(22)
expressionOut.print(fieldRemark)
printHtmlPart(23)
invokeTag('submitButton','g',117,['name':("register"),'class':("save btn btn-primary btn-success"),'style':("font-weight: 100;"),'value':("Register")],-1)
printHtmlPart(24)
})
invokeTag('form','g',118,['action':("registerUser")],2)
printHtmlPart(25)
invokeTag('javascript','asset',121,['src':("jquery.min.js")],-1)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',136,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446690073000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
