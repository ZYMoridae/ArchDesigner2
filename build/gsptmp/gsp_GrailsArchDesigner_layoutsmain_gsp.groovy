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
invokeTag('layoutHead','g',47,[:],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',47,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)

if(session.user == null){
        response.sendRedirect(request.getContextPath()+"/user/login");
    }else{
        def targetApp = newgrails.ArchApplication.findAll("from ArchApplication as c where c.appName='" + session.user.id + "'")
        ArrayList<ArchApplication> userApplication = new ArrayList<>();
    }

printHtmlPart(6)
expressionOut.print(request.getContextPath())
printHtmlPart(7)
expressionOut.print(request.getContextPath())
printHtmlPart(8)
expressionOut.print(request.getContextPath())
printHtmlPart(9)
expressionOut.print(request.getContextPath())
printHtmlPart(10)
expressionOut.print(request.getContextPath())
printHtmlPart(11)
expressionOut.print(request.getContextPath())
printHtmlPart(12)
expressionOut.print(request.getContextPath())
printHtmlPart(13)
expressionOut.print(request.getContextPath())
printHtmlPart(14)
expressionOut.print(request.getContextPath())
printHtmlPart(15)
expressionOut.print(request.getContextPath())
printHtmlPart(16)
expressionOut.print(request.getContextPath())
printHtmlPart(17)

if(session.user != null && session.username == "admin"){

printHtmlPart(18)
expressionOut.print(request.getContextPath())
printHtmlPart(19)

}

printHtmlPart(18)
expressionOut.print(request.getContextPath())
printHtmlPart(20)
invokeTag('layoutBody','g',285,[:],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',285,['class':("animated fadeIn")],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446690631000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
