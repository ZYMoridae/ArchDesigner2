//# sourceMappingURL=jspdf.js.map
/*
 jsPDF 0.9.0rc2 ( ${buildDate} ${commitID} )
Copyright (c) 2010-2012 James Hall, james@snapshotmedia.co.uk, https://github.com/MrRio/jsPDF
Copyright (c) 2012 Willow Systems Corporation, willow-systems.com
MIT license.

            -----------------------------------------------------------------------------------------------
            JavaScript PubSub library
            2012 (c) ddotsenko@willowsystems.com
            based on Peter Higgins (dante@dojotoolkit.org)
            Loosely based on Dojo publish/subscribe API, limited in scope. Rewritten blindly.
            Original is (c) Dojo Foundation 2004-2010. Released under either AFL or new BSD, see:
            http://dojofoundation.org/license for more information.
            -----------------------------------------------------------------------------------------------
*/
var jsPDF=function(){function G(e,l,n,m){e="undefined"===typeof e?"p":e.toString().toLowerCase();"undefined"===typeof l&&(l="mm");"undefined"===typeof n&&(n="a4");"undefined"===typeof m&&"undefined"===typeof zpipe&&(m=!1);var r=n.toString().toLowerCase(),u=[],s=0,x=m;m={a3:[841.89,1190.55],a4:[595.28,841.89],a5:[420.94,595.28],letter:[612,792],legal:[612,1008]};var t="0 g",E=0,Q=[],B=2,M=!1,I=[],v={},y={},N=16,z,q,C,c,w={title:"",subject:"",author:"",keywords:"",creator:""},R=0,S=0,p={},D=new Z(p),
J,f=function(a){return a.toFixed(2)},K=function(a){var b=a.toFixed(0);return 10>a?"0"+b:b},d=function(a){M?Q[E].push(a):(u.push(a),s+=a.length+1)},H=function(){B++;I[B]=s;d(B+" 0 obj");return B},U=function(a){d("stream");d(a);d("endstream")},V,W,O,F=function(a,b){var k;k=a;var g=b,h,d,c,f,e,l;void 0===g&&(g={});h=g.sourceEncoding?h:"Unicode";c=g.outputEncoding;if((g.autoencode||c)&&v[z].metadata&&v[z].metadata[h]&&v[z].metadata[h].encoding&&(h=v[z].metadata[h].encoding,!c&&v[z].encoding&&(c=v[z].encoding),
!c&&h.codePages&&(c=h.codePages[0]),"string"===typeof c&&(c=h[c]),c)){e=!1;f=[];h=0;for(d=k.length;h<d;h++)(l=c[k.charCodeAt(h)])?f.push(String.fromCharCode(l)):f.push(k[h]),f[h].charCodeAt(0)>>8&&(e=!0);k=f.join("")}for(h=k.length;void 0===e&&0!==h;)k.charCodeAt(h-1)>>8&&(e=!0),h--;if(e){f=g.noBOM?[]:[254,255];h=0;for(d=k.length;h<d;h++){l=k.charCodeAt(h);g=l>>8;if(g>>8)throw Error("Character at position "+h.toString(10)+" of string '"+k+"' exceeds 16bits. Cannot be encoded into UCS-2 BE");f.push(g);
f.push(l-(g<<8))}k=String.fromCharCode.apply(void 0,f)}return k.replace(/\\/g,"\\\\").replace(/\(/g,"\\(").replace(/\)/g,"\\)")},X=function(){E++;M=!0;Q[E]=[];d(f(.200025*c)+" w");d("0 G");0!==R&&d(R.toString(10)+" J");0!==S&&d(S.toString(10)+" j");D.publish("addPage",{pageNumber:E})},T=function(a,b){var k;void 0===a&&(a=v[z].fontName);void 0===b&&(b=v[z].fontStyle);try{k=y[a][b]}catch(g){k=void 0}if(!k)throw Error("Unable to look up font label for font '"+a+"', '"+b+"'. Refer to getFontList() for available fonts.");
return k},L=function(){M=!1;u=[];I=[];d("%PDF-1.3");V=C*c;W=q*c;var a,b,k,g,h;for(a=1;a<=E;a++){H();d("<</Type /Page");d("/Parent 1 0 R");d("/Resources 2 0 R");d("/Contents "+(B+1)+" 0 R>>");d("endobj");b=Q[a].join("\n");H();if(x){k=[];for(g=0;g<b.length;++g)k[g]=b.charCodeAt(g);h=adler32cs.from(b);b=new Deflater(6);b.append(new Uint8Array(k));b=b.flush();k=[new Uint8Array([120,156]),new Uint8Array(b),new Uint8Array([h&255,h>>8&255,h>>16&255,h>>24&255])];b="";for(g in k)k.hasOwnProperty(g)&&(b+=String.fromCharCode.apply(null,
k[g]));d("<</Length "+b.length+" /Filter [/FlateDecode]>>")}else d("<</Length "+b.length+">>");U(b);d("endobj")}I[1]=s;d("1 0 obj");d("<</Type /Pages");O="/Kids [";for(g=0;g<E;g++)O+=3+2*g+" 0 R ";d(O+"]");d("/Count "+E);d("/MediaBox [0 0 "+f(V)+" "+f(W)+"]");d(">>");d("endobj");for(var A in v)v.hasOwnProperty(A)&&(a=v[A],a.objectNumber=H(),d("<</BaseFont/"+a.PostScriptName+"/Type/Font"),"string"===typeof a.encoding&&d("/Encoding/"+a.encoding),d("/Subtype/Type1>>"),d("endobj"));D.publish("putResources");
I[2]=s;d("2 0 obj");d("<<");d("/ProcSet [/PDF /Text /ImageB /ImageC /ImageI]");d("/Font <<");for(var e in v)v.hasOwnProperty(e)&&d("/"+e+" "+v[e].objectNumber+" 0 R");d(">>");d("/XObject <<");D.publish("putXobjectDict");d(">>");d(">>");d("endobj");D.publish("postPutResources");H();d("<<");d("/Producer (jsPDF 0.9.0rc2)");w.title&&d("/Title ("+F(w.title)+")");w.subject&&d("/Subject ("+F(w.subject)+")");w.author&&d("/Author ("+F(w.author)+")");w.keywords&&d("/Keywords ("+F(w.keywords)+")");w.creator&&
d("/Creator ("+F(w.creator)+")");A=new Date;d("/CreationDate (D:"+[A.getFullYear(),K(A.getMonth()+1),K(A.getDate()),K(A.getHours()),K(A.getMinutes()),K(A.getSeconds())].join("")+")");d(">>");d("endobj");H();d("<<");d("/Type /Catalog");d("/Pages 1 0 R");d("/OpenAction [3 0 R /FitH null]");d("/PageLayout /OneColumn");D.publish("putCatalog");d(">>");d("endobj");A=s;d("xref");d("0 "+(B+1));d("0000000000 65535 f ");for(e=1;e<=B;e++)a=I[e].toFixed(0),a=10>a.length?Array(11-a.length).join("0")+a:a,d(a+" 00000 n ");
d("trailer");d("<<");d("/Size "+(B+1));d("/Root "+B+" 0 R");d("/Info "+(B-1)+" 0 R");d(">>");d("startxref");d(A);d("%%EOF");M=!0;return u.join("\n")},P=function(a){var b="S";if("F"===a)b="f";else if("FD"===a||"DF"===a)b="B";return b},Y=function(a,b){var k,g,d,c;switch(a){case void 0:return L();case "save":if(navigator.getUserMedia&&(void 0===window.URL||void 0===window.URL.createObjectURL))return p.output("dataurlnewwindow");k=L();g=k.length;d=new Uint8Array(new ArrayBuffer(g));for(c=0;c<g;c++)d[c]=
k.charCodeAt(c);k=new Blob([d],{type:"application/pdf"});saveAs(k,b);break;case "datauristring":case "dataurlstring":return"data:application/pdf;base64,"+btoa(L());case "datauri":case "dataurl":document.location.href="data:application/pdf;base64,"+btoa(L());break;case "dataurlnewwindow":window.open("data:application/pdf;base64,"+btoa(L()));break;default:throw Error('Output type "'+a+'" is not supported.');}};if("pt"===l)c=1;else if("mm"===l)c=72/25.4;else if("cm"===l)c=72/2.54;else if("in"===l)c=
72;else throw"Invalid unit: "+l;if(m.hasOwnProperty(r))q=m[r][1]/c,C=m[r][0]/c;else try{q=n[1],C=n[0]}catch(aa){throw"Invalid format: "+n;}if("p"===e||"portrait"===e)e="p",C>q&&(e=C,C=q,q=e);else if("l"===e||"landscape"===e)e="l",q>C&&(e=C,C=q,q=e);else throw"Invalid orientation: "+e;p.internal={pdfEscape:F,getStyle:P,getFont:function(){return v[T.apply(p,arguments)]},getFontSize:function(){return N},btoa:btoa,write:function(a,b,k,g){d(1===arguments.length?a:Array.prototype.join.call(arguments," "))},
getCoordinateString:function(a){return f(a*c)},getVerticalCoordinateString:function(a){return f((q-a)*c)},collections:{},newObject:H,putStream:U,events:D,scaleFactor:c,pageSize:{width:C,height:q},output:function(a,b){return Y(a,b)}};p.addPage=function(){X();return this};p.text=function(a,b,k,g){var h,e;"number"===typeof a&&(h=a,e=b,a=k,b=h,k=e);"string"===typeof a&&a.match(/[\n\r]/)&&(a=a.split(/\r\n|\r|\n/g));"undefined"===typeof g?g={noBOM:!0,autoencode:!0}:(void 0===g.noBOM&&(g.noBOM=!0),void 0===
g.autoencode&&(g.autoencode=!0));if("string"===typeof a)g=F(a,g);else if(a instanceof Array){a=a.concat();for(h=a.length-1;-1!==h;h--)a[h]=F(a[h],g);g=a.join(") Tj\nT* (")}else throw Error('Type of text must be string or Array. "'+a+'" is not recognized.');d("BT\n/"+z+" "+N+" Tf\n"+N+" TL\n"+t+"\n"+f(b*c)+" "+f((q-k)*c)+" Td\n("+g+") Tj\nET");return this};p.line=function(a,b,k,g){d(f(a*c)+" "+f((q-b)*c)+" m "+f(k*c)+" "+f((q-g)*c)+" l S");return this};p.lines=function(a,b,k,g,h){var f,e,l,m,n,p,s,
r;"number"===typeof a&&(f=a,e=b,a=k,b=f,k=e);h=P(h);g=void 0===g?[1,1]:g;d((b*c).toFixed(3)+" "+((q-k)*c).toFixed(3)+" m ");f=g[0];g=g[1];e=a.length;r=k;for(k=0;k<e;k++)l=a[k],2===l.length?(b=l[0]*f+b,r=l[1]*g+r,d((b*c).toFixed(3)+" "+((q-r)*c).toFixed(3)+" l")):(m=l[0]*f+b,n=l[1]*g+r,p=l[2]*f+b,s=l[3]*g+r,b=l[4]*f+b,r=l[5]*g+r,d((m*c).toFixed(3)+" "+((q-n)*c).toFixed(3)+" "+(p*c).toFixed(3)+" "+((q-s)*c).toFixed(3)+" "+(b*c).toFixed(3)+" "+((q-r)*c).toFixed(3)+" c"));d(h);return this};p.rect=function(a,
b,k,g,h){h=P(h);d([f(a*c),f((q-b)*c),f(k*c),f(-g*c),"re",h].join(" "));return this};p.triangle=function(a,b,d,g,h,c,f){this.lines([[d-a,g-b],[h-d,c-g],[a-h,b-c]],a,b,[1,1],f);return this};p.roundedRect=function(a,b,d,g,h,c,f){var e=4/3*(Math.SQRT2-1);this.lines([[d-2*h,0],[h*e,0,h,c-c*e,h,c],[0,g-2*c],[0,c*e,-(h*e),c,-h,c],[-d+2*h,0],[-(h*e),0,-h,-(c*e),-h,-c],[0,-g+2*c],[0,-(c*e),h*e,-c,h,-c]],a+h,b,[1,1],f);return this};p.ellipse=function(a,b,k,g,h){h=P(h);var e=4/3*(Math.SQRT2-1)*k,l=4/3*(Math.SQRT2-
1)*g;d([f((a+k)*c),f((q-b)*c),"m",f((a+k)*c),f((q-(b-l))*c),f((a+e)*c),f((q-(b-g))*c),f(a*c),f((q-(b-g))*c),"c"].join(" "));d([f((a-e)*c),f((q-(b-g))*c),f((a-k)*c),f((q-(b-l))*c),f((a-k)*c),f((q-b)*c),"c"].join(" "));d([f((a-k)*c),f((q-(b+l))*c),f((a-e)*c),f((q-(b+g))*c),f(a*c),f((q-(b+g))*c),"c"].join(" "));d([f((a+e)*c),f((q-(b+g))*c),f((a+k)*c),f((q-(b+l))*c),f((a+k)*c),f((q-b)*c),"c",h].join(" "));return this};p.circle=function(a,b,d,g){return this.ellipse(a,b,d,d,g)};p.setProperties=function(a){for(var b in w)w.hasOwnProperty(b)&&
a[b]&&(w[b]=a[b]);return this};p.setFontSize=function(a){N=a;return this};p.setFont=function(a,b){z=T(a,b);return this};p.setFontStyle=p.setFontType=function(a){z=T(void 0,a);return this};p.getFontList=function(){var a={},b,d,g;for(b in y)if(y.hasOwnProperty(b))for(d in a[b]=g=[],y[b])y[b].hasOwnProperty(d)&&g.push(d);return a};p.setLineWidth=function(a){d((a*c).toFixed(2)+" w");return this};p.setDrawColor=function(a,b,c,g){a=void 0===b||void 0===g&&a===b===c?"string"===typeof a?a+" G":f(a/255)+" G":
void 0===g?"string"===typeof a?[a,b,c,"RG"].join(" "):[f(a/255),f(b/255),f(c/255),"RG"].join(" "):"string"===typeof a?[a,b,c,g,"K"].join(" "):[f(a),f(b),f(c),f(g),"K"].join(" ");d(a);return this};p.setFillColor=function(a,b,c,g){a=void 0===b||void 0===g&&a===b===c?"string"===typeof a?a+" g":f(a/255)+" g":void 0===g?"string"===typeof a?[a,b,c,"rg"].join(" "):[f(a/255),f(b/255),f(c/255),"rg"].join(" "):"string"===typeof a?[a,b,c,g,"k"].join(" "):[f(a),f(b),f(c),f(g),"k"].join(" ");d(a);return this};
p.setTextColor=function(a,b,d){t=0===a&&0===b&&0===d||"undefined"===typeof b?(a/255).toFixed(3)+" g":[(a/255).toFixed(3),(b/255).toFixed(3),(d/255).toFixed(3),"rg"].join(" ");return this};p.CapJoinStyles={0:0,butt:0,but:0,bevel:0,1:1,round:1,rounded:1,circle:1,2:2,projecting:2,project:2,square:2,milter:2};p.setLineCap=function(a){var b=this.CapJoinStyles[a];if(void 0===b)throw Error("Line cap style of '"+a+"' is not recognized. See or extend .CapJoinStyles property for valid styles");R=b;d(b.toString(10)+
" J");return this};p.setLineJoin=function(a){var b=this.CapJoinStyles[a];if(void 0===b)throw Error("Line join style of '"+a+"' is not recognized. See or extend .CapJoinStyles property for valid styles");S=b;d(b.toString(10)+" j");return this};p.output=Y;p.save=function(a){p.output("save",a)};for(J in G.API)G.API.hasOwnProperty(J)&&("events"===J&&G.API.events.length?function(a,b){var d,c,h;for(h=b.length-1;-1!==h;h--)d=b[h][0],c=b[h][1],a.subscribe.apply(a,[d].concat("function"===typeof c?[c]:c))}(D,
G.API.events):p[J]=G.API[J]);(function(){var a=[["Helvetica","helvetica","normal"],["Helvetica-Bold","helvetica","bold"],["Helvetica-Oblique","helvetica","italic"],["Helvetica-BoldOblique","helvetica","bolditalic"],["Courier","courier","normal"],["Courier-Bold","courier","bold"],["Courier-Oblique","courier","italic"],["Courier-BoldOblique","courier","bolditalic"],["Times-Roman","times","normal"],["Times-Bold","times","bold"],["Times-Italic","times","italic"],["Times-BoldItalic","times","bolditalic"]],
b,d,c,h;b=0;for(d=a.length;b<d;b++){var f=a[b][0],e=a[b][1];c=a[b][2];h="F"+($(v)+1).toString(10);var f=v[h]={id:h,PostScriptName:f,fontName:e,fontStyle:c,encoding:"StandardEncoding",metadata:{}},l=h;void 0===y[e]&&(y[e]={});y[e][c]=l;D.publish("addFont",f);c=h;h=a[b][0].split("-");f=h[0];h=h[1]||"";void 0===y[f]&&(y[f]={});y[f][h]=c}D.publish("addFonts",{fonts:v,dictionary:y})})();z="F1";X();D.publish("initialized");return p}"undefined"===typeof btoa&&(window.btoa=function(e){var l="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".split(""),
n,m,r,u,s=0,x=0,t="",t=[];do n=e.charCodeAt(s++),m=e.charCodeAt(s++),r=e.charCodeAt(s++),u=n<<16|m<<8|r,n=u>>18&63,m=u>>12&63,r=u>>6&63,u&=63,t[x++]=l[n]+l[m]+l[r]+l[u];while(s<e.length);t=t.join("");e=e.length%3;return(e?t.slice(0,e-3):t)+"===".slice(e||3)});"undefined"===typeof atob&&(window.atob=function(e){var l,n,m,r,u,s=0,x=0;r="";var t=[];if(!e)return e;e+="";do l="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".indexOf(e.charAt(s++)),n="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".indexOf(e.charAt(s++)),
r="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".indexOf(e.charAt(s++)),u="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".indexOf(e.charAt(s++)),m=l<<18|n<<12|r<<6|u,l=m>>16&255,n=m>>8&255,m&=255,64===r?t[x++]=String.fromCharCode(l):64===u?t[x++]=String.fromCharCode(l,n):t[x++]=String.fromCharCode(l,n,m);while(s<e.length);return r=t.join("")});var $="function"===typeof Object.keys?function(e){return Object.keys(e).length}:function(e){var l=0,n;for(n in e)e.hasOwnProperty(n)&&
l++;return l},Z=function(e){this.topics={};this.context=e;this.publish=function(e,n){if(this.topics[e]){var m=this.topics[e],r=[],u,s,x,t,E=function(){};n=Array.prototype.slice.call(arguments,1);s=0;for(x=m.length;s<x;s++)t=m[s],u=t[0],t[1]&&(t[0]=E,r.push(s)),u.apply(this.context,n);s=0;for(x=r.length;s<x;s++)m.splice(r[s],1)}};this.subscribe=function(e,n,m){this.topics[e]?this.topics[e].push([n,m]):this.topics[e]=[[n,m]];return{topic:e,callback:n}};this.unsubscribe=function(e){if(this.topics[e.topic]){var n=
this.topics[e.topic],m,r;m=0;for(r=n.length;m<r;m++)n[m][0]===e.callback&&n.splice(m,1)}}};G.API={events:[]};return G}();