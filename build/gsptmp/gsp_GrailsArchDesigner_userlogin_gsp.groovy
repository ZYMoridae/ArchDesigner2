import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_GrailsArchDesigner_userlogin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/login.gsp" }
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
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',37,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(2)
if(true && (session.user != null)) {
printHtmlPart(6)
expressionOut.print(session.user.fname)
printHtmlPart(2)
}
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('set','g',60,['var':("fieldPwd"),'value':("userpwd")],-1)
printHtmlPart(9)
invokeTag('set','g',63,['var':("fieldEmail"),'value':("email")],-1)
printHtmlPart(10)
expressionOut.print(fieldEmail)
printHtmlPart(11)
expressionOut.print(fieldEmail)
printHtmlPart(12)
expressionOut.print(fieldPwd)
printHtmlPart(13)
expressionOut.print(fieldPwd)
printHtmlPart(14)
expressionOut.print(request.getContextPath())
printHtmlPart(15)
invokeTag('submitButton','g',83,['name':("login"),'class':("save btn btn-primary btn-success"),'value':("Login")],-1)
printHtmlPart(16)
})
invokeTag('form','g',84,['action':("loginValidate")],2)
printHtmlPart(17)
invokeTag('javascript','asset',87,['src':("jquery.min.js")],-1)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',91,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446690363000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
