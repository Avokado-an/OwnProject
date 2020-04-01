<#ftl output_format="HTML"/>
<#import "parts/basic.ftlh" as base>
<#import "parts/loginhelper.ftlh" as log>
<#assign  sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<@base.page>
    <div><a href="/messages">Messages</a></div>
    <div><a href="/userCatalog">Users</a></div>
    <div><a href="/contacts">Contacts</a></div>
    <@sec.authorize access="isAuthenticated()">
        <div>
            <@log.logout />
        </div>
    </@sec.authorize>
    <@sec.authorize access="!isAuthenticated()">
        <div>
            <form action="/login" method="post">
                <input type="submit" value="Sign In"/>
            </form>
        </div>
    </@sec.authorize>
</@base.page>
