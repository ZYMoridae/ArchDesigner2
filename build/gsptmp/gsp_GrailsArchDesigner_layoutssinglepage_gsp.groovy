import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_GrailsArchDesigner_layoutssinglepage_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/singlepage.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',13,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(3)
invokeTag('stylesheet','asset',17,['src':("bootstrap.min.css")],-1)
printHtmlPart(4)
invokeTag('stylesheet','asset',25,['src':("metisMenu.min.css")],-1)
printHtmlPart(5)
invokeTag('stylesheet','asset',25,['src':("timeline.css")],-1)
printHtmlPart(6)
invokeTag('stylesheet','asset',28,['src':("sb-admin-2.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',30,['src':("animate.css")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',33,['src':("morris.css")],-1)
printHtmlPart(9)
invokeTag('stylesheet','asset',36,['src':("font-awesome.min.css")],-1)
printHtmlPart(10)
invokeTag('layoutHead','g',48,[:],-1)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',48,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(12)
invokeTag('layoutBody','g',49,[:],-1)
printHtmlPart(13)
invokeTag('javascript','asset',55,['src':("jquery.min.js")],-1)
printHtmlPart(14)
invokeTag('javascript','asset',78,['src':("metisMenu.min.js")],-1)
printHtmlPart(15)
invokeTag('javascript','asset',79,['src':("raphael-min.js")],-1)
printHtmlPart(11)
invokeTag('javascript','asset',79,['src':("morris.min.js")],-1)
printHtmlPart(16)
invokeTag('javascript','asset',82,['src':("sb-admin-2.js")],-1)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',87,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1442461615000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
