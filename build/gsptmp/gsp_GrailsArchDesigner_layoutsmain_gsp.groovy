import newgrails.ArchApplication
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_GrailsArchDesigner_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',7,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(2)
invokeTag('stylesheet','asset',14,['src':("bootstrap.min.css")],-1)
printHtmlPart(3)
invokeTag('stylesheet','asset',19,['src':("metisMenu.min.css")],-1)
printHtmlPart(4)
invokeTag('stylesheet','asset',22,['src':("timeline.css")],-1)
printHtmlPart(5)
invokeTag('stylesheet','asset',25,['src':("sb-admin-2.css")],-1)
printHtmlPart(6)
invokeTag('stylesheet','asset',27,['src':("animate.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',30,['src':("morris.css")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',33,['src':("font-awesome.min.css")],-1)
printHtmlPart(9)
invokeTag('layoutHead','g',57,[:],-1)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',57,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)

if(session.user == null){
        response.sendRedirect("/user/login");
    }else{
        def targetApp = newgrails.ArchApplication.findAll("from ArchApplication as c where c.appName='" + session.user.id + "'")
        ArrayList<ArchApplication> userApplication = new ArrayList<>();
    }

printHtmlPart(13)

if(session.user != null && session.username == "admin"){

printHtmlPart(14)

}

printHtmlPart(15)
invokeTag('javascript','asset',243,['src':("jquery.min.js")],-1)
printHtmlPart(16)
invokeTag('javascript','asset',261,['src':("metisMenu.min.js")],-1)
printHtmlPart(17)
invokeTag('javascript','asset',262,['src':("raphael-min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',265,['src':("morris.min.js")],-1)
printHtmlPart(18)
invokeTag('javascript','asset',266,['src':("sb-admin-2.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',268,['src':("jquery-ui.js")],-1)
printHtmlPart(19)
invokeTag('javascript','asset',269,['src':("jquery.dataTables.columnFilter.js")],-1)
printHtmlPart(20)
invokeTag('layoutBody','g',275,[:],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',275,['class':("animated fadeIn")],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446349656000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
