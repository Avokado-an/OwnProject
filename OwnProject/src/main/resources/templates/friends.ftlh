<#ftl output_format="HTML"/>
<#import "parts/basic.ftlh" as base>
<#import "parts/loginhelper.ftlh" as log>

<#assign  sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<@base.page>
    <#list friends as friend>
            <span>${friend.username}</span>
    <#else>
        <div>
            No contact
        </div>
    </#list>
    <div style="text-align: left">
        <a href="/">Back</a>
    </div>
</@base.page>