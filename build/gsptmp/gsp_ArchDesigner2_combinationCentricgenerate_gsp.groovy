import newgrails.User
import  newgrails.Decision
import  newgrails.ArchApplication
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ArchDesigner2_combinationCentricgenerate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/combinationCentric/generate.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'scoreAlternative.label', default: 'ScoreAlternative'))],-1)
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
for( application in (newgrails.ArchApplication.findAll("from ArchApplication as c where c.user=:myuser", [myuser: session.user], [cache: true])) ) {
printHtmlPart(5)
expressionOut.print(application.id)
printHtmlPart(6)
expressionOut.print(application.appName)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('javascript','asset',48,['src':("Chart.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',48,['src':("jspdf.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',53,['src':("jspdf.plugin.addimage.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',54,['src':("jspdf.plugin.from_html.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',55,['src':("FileSaver.js")],-1)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',82,[:],1)
printHtmlPart(10)
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
