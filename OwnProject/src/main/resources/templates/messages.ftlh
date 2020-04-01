<#ftl output_format="HTML"/>
<#import "parts/basic.ftlh" as base>
<#import "parts/loginhelper.ftlh" as log>

<#assign  sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<@base.page>
    <div>
        <form method="post" enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="text" name="text" placeholder="Введите сообщение"/>
            <input type="text" name="receiverName" placeholder="Кому:"/>
            <button type="submit">Добавить</button>
        </form>
    </div>
    <#list messages as message>
        <#if message.author.equals(currentUser)>
            <div style="text-align: center">
                <span>${message.text}</span>
                <span style="opacity: 0.5">
                (${message.date?time})
            </span>
            </div>
        <#else>
            <div style="text-align: left">
                <span style="opacity: 0.5">${message.author.getUsername()}:</span>
                <span>${message.text}</span>
                <span style="opacity: 0.5">
                (${message.date?time})
            </span>
            </div>
        </#if>
    <#else>
        <div>
            No messages
        </div>
    </#list>
    <div style="text-align: left">
        <a href="/">Back</a>
    </div>
</@base.page>