<#import "parts/basic.ftlh" as base>
<#import "parts/loginhelper.ftlh" as log>

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
        <div>
            <span>${message.text}</span>
            <span style="opacity: 0.5">
                ${message.receiver}
            </span>
            <span style="opacity: 0.5">
                ${message.date?time}
            </span>
        </div>
    <#else>
        <div>
            No messages
        </div>
    </#list>
    <a href="/">Back</a>

</@base.page>