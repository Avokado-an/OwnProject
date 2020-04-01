<#import "parts/basic.ftlh" as base>

<@base.page>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div>
        <#list users as user>
            <div>
                <span>${user.id}: </span>
                <span>${user.username}</span>
                <span>${user.password}</span>
            </div>
        </#list>
    </div>
    <a href="/">Back</a>
</@base.page>