<#import "parts/basic.ftlh" as base>

<@base.page>
    <div>
        <form method="post" enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="text" name="searchedUser" placeholder="Name of user to find"/>
            <button type="submit">Добавить</button>
        </form>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div>
        <#list users as user>
            <div>
                <span>${user.username}</span>
                <span>${user.password}</span>
            </div>
        <#else>
            No appropriate users!
        </#list>
    </div>
    <a href="/">Back</a>
</@base.page>