import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ArchDesigner2notFound_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/notFound.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(3)
if((grails.util.Environment.current.name == 'development') && true) {
invokeTag('stylesheet','asset',5,['src':("errors.css")],-1)
}
printHtmlPart(4)
invokeTag('stylesheet','asset',6,['src':("animate.css")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(5)
createClosureForHtmlPart(6, 1)
invokeTag('captureBody','sitemesh',18,[:],1)
printHtmlPart(7)
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
