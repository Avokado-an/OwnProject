<#ftl output_format="HTML"/>
<#import "parts/basic.ftlh" as base>
<#import "parts/loginhelper.ftlh" as log>

<#assign  sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<@base.page>
    <div>Contacts</div>
    <#list contacts as contact>
        <#if contact.owner.equals(currentUser)>
            <div>
                <span>
                    ${contact.user.username}
                </span>
            </div>
        <#else>
            <div>
                <span>
                    ${contact.owner.username}
                </span>
            </div>
        </#if>
        <div style="opacity: 0.5">
            ${contact.lastMessage}
            ${contact.time}
        </div>
    <#else>
        <div>
            No contact
        </div>
    </#list>
    <div style="text-align: left">
        <a href="/">Back</a>
    </div>
</@base.page>